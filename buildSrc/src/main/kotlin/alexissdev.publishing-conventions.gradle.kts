plugins {
    id("alexissdev.common-conventions")
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "${rootProject.name}-${project.name}"
            from(components["java"])
        }
    }
}