plugins {
	kotlin("multiplatform") version "1.3.21"
}

repositories {
	mavenCentral()
}

kotlin {
	linuxX64("native") {
		binaries {
			executable()
		}
	}
}
