plugins {
    `java-library`
}

repositories {
    mavenLocal()
    maven("https://jitpack.io")
    maven("https://repo.unnamed.team/repository/unnamed-public/")
    maven("https://repo.codemc.io/repository/maven-public/")
    mavenCentral()
}

tasks {
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(8))
        }
    }

    compileJava {
        options.compilerArgs.add("-parameters")
    }
}