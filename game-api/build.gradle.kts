plugins {
    id("alexissdev.spigot-conventions")
}

dependencies {
    implementation(libs.commons.validation)
    implementation(libs.commons.error)
    implementation(libs.storage.mongo)
    implementation(libs.commons.storage.mongo)
    compileOnly(libs.spigot)
}