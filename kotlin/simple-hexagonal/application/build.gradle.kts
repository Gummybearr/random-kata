dependencies {
    api(project(":domain"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("javax.transaction:javax.transaction-api:1.3")
}
