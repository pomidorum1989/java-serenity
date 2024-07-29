plugins {
    id ("net.serenity-bdd.serenity-gradle-plugin") version "4.1.12"
    java
}

group = "io.dorum"
version = "1.0-SNAPSHOT"

val lombokVersion = "1.18.34"
val log4jVersion = "2.23.1"
val serenityVersion = "4.1.20"
val junitVersion = "5.11.0-M2"
val assertjVersion = "3.26.3"

defaultTasks(tasks.clean.name, tasks.test.name, tasks.aggregate.name)

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
    implementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")

    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")

    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-slf4j2-impl
    implementation("org.apache.logging.log4j:log4j-slf4j2-impl:$log4jVersion")

    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")

    // https://mvnrepository.com/artifact/org.projectlombok/lombok
    implementation("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
    testAnnotationProcessor("org.projectlombok:lombok:$lombokVersion")

    // https://mvnrepository.com/artifact/net.serenity-bdd/serenity-core
    implementation("net.serenity-bdd:serenity-core:$serenityVersion")

    // https://mvnrepository.com/artifact/net.serenity-bdd/serenity-screenplay
    implementation("net.serenity-bdd:serenity-screenplay:$serenityVersion")

    // https://mvnrepository.com/artifact/net.serenity-bdd/serenity-junit5
    testImplementation("net.serenity-bdd:serenity-junit5:$serenityVersion")

    // https://mvnrepository.com/artifact/net.serenity-bdd/serenity-screenplay-webdriver
    implementation("net.serenity-bdd:serenity-screenplay-webdriver:$serenityVersion")

    // https://mvnrepository.com/artifact/net.serenity-bdd/serenity-ensure
    implementation("net.serenity-bdd:serenity-ensure:$serenityVersion")

    // https://mvnrepository.com/artifact/net.serenity-bdd/serenity-rest-assured
    implementation("net.serenity-bdd:serenity-rest-assured:$serenityVersion")

    // https://mvnrepository.com/artifact/org.assertj/assertj-core
    testImplementation("org.assertj:assertj-core:$assertjVersion")
}

serenity {
    testRoot = "io.dorum.tests"
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
    }
    finalizedBy(tasks.aggregate)
}