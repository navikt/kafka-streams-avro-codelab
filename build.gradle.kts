plugins {
    `java-library`
    id("com.commercehub.gradle.plugin.avro") version "0.14.2"
}


repositories {
    jcenter()
    maven("http://packages.confluent.io/maven/")
}

val log4j2Version = "2.11.1"
val kafkaClientsVersion = "2.0.1"
val confluentVersion = "5.0.2"

val libs = "$projectDir/libs"
val implementationLib = "$libs/implementation"


configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {

    if (gradle.startParameter.isOffline) {
        implementation(fileTree(implementationLib))
    } else {
        implementation(group = "io.confluent", name = "kafka-streams-avro-serde", version = confluentVersion)
        implementation(group = "org.apache.avro", name = "avro", version = "1.8.2")
        implementation(group = "org.apache.kafka", name = "kafka-streams", version = kafkaClientsVersion)
        implementation(group = "org.apache.logging.log4j", name = "log4j-api", version = log4j2Version)
        implementation(group = "org.apache.logging.log4j", name = "log4j-core", version = log4j2Version)
        implementation(group = "org.apache.logging.log4j", name = "log4j-slf4j-impl", version = log4j2Version)
        implementation(group = "com.google.code.gson", name = "gson", version = "2.8.5")
        implementation(group = "com.google.code.gson", name = "gson", version = "2.8.5")
    }

}

val copyDeps by tasks.creating(Copy::class) {
    from(configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { it.absolutePath }.toTypedArray()
    ).into(implementationLib)
}
