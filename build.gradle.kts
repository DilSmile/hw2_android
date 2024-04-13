import io.gitlab.arturbosch.detekt.extensions.DetektExtension

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.0" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.22" apply false
    id("com.google.devtools.ksp") version "1.9.21-1.0.15" apply false
    id("com.android.library") version "8.2.0" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
    id("org.jetbrains.kotlin.kapt") version "1.9.22" apply false
    id("io.gitlab.arturbosch.detekt") version("1.23.3") apply false
}

allprojects.onEach {project ->
    with(project.plugins){
        if (hasPlugin("org.jetbrains.kotlin.android".get().pluginId)
            ||hasPlugin("org.jetbrains.kotlin.android".get().pluginId)
        ){
            apply("io.gitlab.arturbosch.detekt".get().pluginId)
            project.extensions.configure<DetektExtension>{
                config = rootProject.files("default-detekt-config.yml")
            }
            project.dependencies.add("detektPlugins","io.gitlab.arturbosch.detekt:detekt-formatting".get().toString())
        }
    }
}
