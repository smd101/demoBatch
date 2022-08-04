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
    implementation("org.springframework.boot:spring-boot-starter-batch")
    implementation(kotlin("stdlib"))
    implementation(project(":domain"))
}