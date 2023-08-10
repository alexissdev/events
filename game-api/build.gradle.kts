plugins {
    id("alexissdev.spigot-conventions")
}

dependencies {
    compileOnly(libs.spigot)

    implementation(libs.commons.validation)
    implementation(libs.commons.error)
    implementation(libs.storage.mongo)
    implementation(libs.commons.storage.mongo)
    implementation(libs.message.core)
    implementation(libs.item.nbt)
}