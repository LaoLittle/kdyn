plugins {
    kotlin("multiplatform") version "1.6.21"
}

group = "org.laolittle"
version = "0.1.0"

repositories {
    mavenCentral()
}

kotlin {
    macosX64()
    linuxX64()
    mingwX64()
    sourceSets {
        val commonMain by getting {
            dependencies {

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val linuxX64Main by getting
        val linuxX64Test by getting
    }
}
