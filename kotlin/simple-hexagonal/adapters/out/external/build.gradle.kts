dependencies {
    api(project(":domain"))
    api(project(":application"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("javax.transaction:javax.transaction-api:1.3")
    implementation("com.google.api-client:google-api-client:1.32.1")
}
