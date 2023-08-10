plugins {
    id("alexissdev.spigot-conventions")
}


dependencies {
    api(libs.commons.bukkit)
    compileOnly(libs.spigot)
    implementation(libs.inject)
    implementation(libs.message.core)
    implementation(libs.message.bukkit)
    implementation(libs.storage.mongo)
}