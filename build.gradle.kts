import org.jetbrains.kotlin.konan.properties.hasProperty

version = "LOCAL-SNAPSHOT"

buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.3.61"))
    }
}

plugins {
    java
    jacoco
    id("org.springframework.boot") version "2.4.2"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.4.2") {
        exclude(group = "jakarta.validation", module = "jakarta.validation-api")
    }
    implementation("com.google.guava:guava:23.5-jre")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.4.2") {
        exclude(group = "jakarta.activation", module = "jakarta.activation-api")
        exclude(group = "jakarta.xml.bind", module = "jakarta.xml.bind-api")
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.5.2")
    testImplementation("org.assertj:assertj-core:3.11.1")
    testCompileOnly("org.projectlombok:lombok:1.18.16")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.16")
}

sourceSets {
    test {
        java {
            srcDir("src/test/java")
        }
    }
}

tasks {
    test {

        sourceSets.test.get().java.exclude("**/*IT.java")

        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
    bootRun {
        val props = System.getProperties()
        if (props.hasProperty("args")) {
            args = listOf(props.getProperty("args"))
        }
    }
}