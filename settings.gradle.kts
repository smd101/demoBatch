pluginManagement {
    plugins {
        id("org.springframework.boot") version "2.6.7"
        id("io.spring.dependency-management") version "1.0.11.RELEASE"
        id("org.jmailen.kotlinter") version "3.3.0"
        kotlin("jvm") version "1.6.21"
        kotlin("plugin.spring") version "1.6.21"
    }
}

rootProject.name = "demoBatch"
include("infrastructure")
include("domain")
include("application")
