plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.jmailen.kotlinter")
    kotlin("jvm")
    kotlin("plugin.spring")
}

group = "jp.demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0")
    runtimeOnly("com.h2database:h2") // H2

    implementation(kotlin("stdlib"))
}