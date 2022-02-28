# Simple Implementation of Hexagonal Architecture

## What is Hexagonal Architecture?
<img src="https://reflectoring.io/images/posts/spring-hexagonal/hexagonal-architecture_hu6764515d7030d45af6f7f498c79e292b_50897_956x0_resize_box_3.png" width="70%"/>

인프라 <- 서비스 <- 프레젠테이션 의 방향으로 의존성이 설계된 MVC 아키텍쳐에서는 인프라의 변화가 곧 뷰의 변화로 이어지기 쉽다. 하지만 웹서비스에서의 핵심은 인프라가 아니라 실제 비즈니스 로직이 수행되는 서비스 계층, 더욱 정확하게는 개발팀의 의사소통 단위가 되는 도메인 객체들이다. 

도메인 객체들은 근본적으로 서비스가 지니는 바운디드 컨텍스트 안에서 독립적인 로직을 가지고 있다. 영속성 계층, 혹은 메시지 큐와 같은 인프라는 결국 이러한 도메인의 상태를 저장하거나 전달하기 위해 존재한다. 즉, 도메인 객체들은 인프라에 의존하지 않아야 한다.

그렇기 때문에 클린아키텍쳐의 일종인 헥사고날 아키텍쳐는 의존의 방향이 레이어드 아키텍쳐와 다르다. 어디에도 의존하지 않는 도메인 객체들이 존재하고, 이들에 의존하는 서비스계층(또는 usecase 계층)이 존재한다. 서비스계층에서 수행되는 비즈니스 로직들은 외부와 연결된 포트를 통해 시스템 외부로 전달되며 인프라는 포트에 의존한다. 

한 마디로, 외부와의 통신을 인터페이스로 추상화하여 외부 코드나 로직의 주입을 막는다는 것이 헥사고날 아키텍쳐의 핵심이다.

## How it is implemented in this project
<img src="https://github.com/Gummybearr/random-kata/blob/main/kotlin/simple-hexagonal/architecture.drawio.png?raw=true"/>

## Project Overview

의존하지 않는 모듈
```
1. core 모듈: 소통의 단위가 되는 도메인 객체들을 정의
```

core에 의존하는 모듈
```
2. usecase 모듈: 시스템과 연관된 요청들이 정의되거나 구현된 곳
port
--in: 요청을 처리하거나 알리기 위해 내부 시스템을 호출해야 하는 요청들이 정의되어있는 곳
--out: 요청을 처리하거나 알리기 위해 시스템 외부로 나가야 하는 요청들이 정의되어있는 곳
adapter
--in: 내부요청의 구체적인 동작이 정의된 곳.
--out: 시스템 외부로 나가야 하는 요청들의 구체적인 동작이 구현된 곳. usecase모듈이 아닌 adapter모듈에 구현하여 시스템 외부와 내부를 격리시키고 코드나 데이터의 진입을 매퍼를 통해 제어
----mapper: 외부응답을 서비스 내에 정의된 값들로 변형하거나, 내부의 값을 외부에서 사용할 수 있는 값들로 변형.
config: 정의된 포트를 구현체인 어댑터들을 이용하여 조립, mapper를 빈으로 사용할 수 있도록 제공
```

core, usecase에 의존하는 모듈
```
3. webapp 모듈: 웹요청 중 이 마이스로서비스에 영향을 미치는 요청의 진입점. 웹요청을 처리하기 위해 in-포트 호출
api: 메시지 핸들러
--mapper: 외부요청을 usecase에 정의된 값으로 변형하거나, usecase의 리턴값을 외부에서 사용할 수 있는 값들로 변형
config: 웹앱에서 사용하는 usecase, port와 구현체들을 조립

4. eventapp 모듈: 메시지큐에 전달되는 이벤트 중 이 마이크로서비스에 영향을 미치는 이벤트들의 진입점. 이벤트를 컨슘하기 위해 in-포트 호출
consumer: 메시지 핸들러
--mapper: 외부요청을 usecase에 정의된 값으로 변형
config: 이벤트앱에서 사용하는 usecase, port와 구현체들을 조립
```

core, usecase, 인프라에 의존하는 모듈
```
5. data 모듈: 이 마이크로서비스가 관리하는 데이터베이스로의 접근점
--entity: 데이터베이스 엔티티 정의
--repository: 레포지토리
```

## Understanding flow with usecase
1. 광고 생성 요청이 webapp.api.AdvertisementController를 호출
2. webapp.api.AdvertisementController가 웹 요청을 전달받아 광고 생성 유즈케이스를 호출
3. 유즈케이스의 구현체인 adapter.in.CreateAdvertisement가 광고를 데이터베이스에 저장하기 위해 광고 포트를 호출
4. 광고 포트의 구현체인 data.repository.AdvertisementRepositoryImpl가 데이터베이스에 광고를 저장
5. adapter.in.CreateAdvertisement가 광고 심사를 위해 심사 포트를 호출
6. 심사 포트의 구현체인 adapter.out.AdvertisementInspectionPortAdapter가 메시지큐로 광고 심사요청 이벤트를 전송

네트워크 요청이 webapp -> usecase.port.in -> usecase.port.out의 흐름으로 진행. 이 때 직접 구현체를 호출하지 않고 인터페이스를 호출하여 구현을 숨김. 
또, 시스템 외부로 나가거나 들어오는 요청들은 매퍼를 통한 변환을 해줌으로써 외부 코드나 로직이 시스템 내부로 스며드는 것을 방어

## Use Cases in this project
웹앱을 통해 처리 가능한 케이스
```
1. 제목, 사진, 설명을 등록하여 광고를 만들 수 있다.
2. 등록한 광고의 정보를 조회할 수 있다.
3. 제목, 사진, 설명을 수정하여 광고를 수정할 수 있다.
4. 광고를 삭제할 수 있다.
```
이벤트앱을 통해 처리 가능한 케이스
```
5. 외부 시스템이 광고를 심사하고 나면 광고가 송출되어도 되는지 결과가 나온다.
6. 광고가 심사부적격이거나 차단되면 외부 시스템이 광고가 차단되었음을 알려준다.
```

## Test Strategy 

<img src = "https://github.com/Gummybearr/random-kata/blob/main/kotlin/simple-hexagonal/mock-strategy.drawio.png?raw=true"/>
output port의 어댑터들만 모킹하여 테스트한다. 테스트 범위가 좁은 모듈의 테스트부터 나열하면 다음과 같다.

케이스 1. Core 모듈 테스트

케이스 2. Usecase 모듈 테스트

케이스 3. Webapp, Eventapp, Data 테스트
