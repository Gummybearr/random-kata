# Simple Implementation of Hexagonal Architecture

## What is Hexagonal Architecture?
<img src="https://reflectoring.io/images/posts/spring-hexagonal/hexagonal-architecture_hu6764515d7030d45af6f7f498c79e292b_50897_956x0_resize_box_3.png"/>

## How it is implemented in this project
<img src="https://github.com/Gummybearr/random-kata/blob/main/kotlin/simple-hexagonal/architecture.drawio.png?raw=true"/>

## Project Overview
```html
simple-hexagonal

adapter 모듈
--out: 시스템 외부로 나가야 하는 요청들의 구체적인 동작이 구현된 곳. usecase모듈이 아닌 adapter모듈에 구현하여 시스템 외부와 내부를 격리시키고 코드나 데이터의 진입을 매퍼를 통해 제어
----mapper: 외부응답을 서비스 내에 정의된 값들로 변형하거나, 내부의 값을 외부에서 사용할 수 있는 값들로 변형.
--config: 구현체(adapter)를 인터페이스(port) 타입으로 사용할 수 있도록 객체 조립

core 모듈: 소통의 단위가 되는 도메인 객체들을 정의

data 모듈: 이 마이크로서비스가 관리하는 데이터베이스로의 접근점
--entity: 데이터베이스 엔티티 정의
--repository: 레포지토리

eventapp 모듈: 메시지큐에 전달되는 이벤트 중 이 마이크로서비스에 영향을 미치는 이벤트들의 진입점. 이벤트를 컨슘하기 위해 인포트 호출

usecase 모듈: 시스템과 연관된 요청들이 정의되거나 구현된 곳
--adapter
----in: 내부요청의 구체적인 동작이 정의된 곳.
--port
----in: 요청을 처리하거나 알리기 위해 내부 시스템을 호출해야 하는 요청들이 정의되어있는 곳
----out: 요청을 처리하거나 알리기 위해 시스템 외부로 나가야 하는 요청들이 정의되어있는 곳

webapp 모듈: 
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
