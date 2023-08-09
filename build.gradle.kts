plugins {
    id("java")
}

subprojects {
    apply(plugin = "alexissdev.spigot-conventions")

    dependencies {
        implementation("dev.alexisdev:commons-bukkit:0.0.1")
        implementation("dev.alexisdev:commons-error:0.0.1")
        implementation("dev.alexisdev:commons-validate:0.0.1")
    }
}
