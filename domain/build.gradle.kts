plugins {
    kotlin("jvm")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.jmailen.kotlinter")
    kotlin("plugin.spring")

}

group = "jp.demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation(kotlin("stdlib"))
    implementation(project(":infrastructure"))
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-csv:2.13.3")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")

}