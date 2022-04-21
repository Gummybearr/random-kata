dependencies {
    api(project(":domain"))
    api(project(":application"))
    api(project(":data"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("javax.transaction:javax.transaction-api:1.3")
}
