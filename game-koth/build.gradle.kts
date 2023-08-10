plugins {
    id("alexissdev.spigot-conventions")
}

dependencies {
    implementation("org.jetbrains:annotations:24.0.0")
    compileOnly(libs.spigot)
    implementation(project(":game-api"))
    implementation(libs.storage.mongo)
    implementation(libs.inject)
}