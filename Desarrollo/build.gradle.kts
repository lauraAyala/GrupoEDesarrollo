import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.5"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
}

group = "Grupo-E"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation(kotlin("stdlib-jdk8"))
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

	testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")

	implementation("com.google.guava:guava:31.1-jre")
	testImplementation("org.testng:testng:7.1.0")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("junit:junit:4.13.1")
	testImplementation("junit:junit:4.13.1")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
kotlin {
    jvmToolchain(1_8)
}