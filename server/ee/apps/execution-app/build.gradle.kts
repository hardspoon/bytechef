group = "com.bytechef.execution"
description = ""

springBoot {
    mainClass.set("com.bytechef.execution.ExecutionApplication")
}

dependencies {
    implementation("org.apache.commons:commons-lang3")
    implementation(libs.org.openapitools.jackson.databind.nullable)
    implementation(libs.org.springdoc.springdoc.openapi.starter.common)
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-config")
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
    implementation("org.springframework.retry:spring-retry")
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-converter"))
    implementation(project(":server:libs:atlas:atlas-execution:atlas-execution-repository:atlas-execution-repository-jdbc"))
    implementation(project(":server:libs:atlas:atlas-execution:atlas-execution-config"))
    implementation(project(":server:libs:atlas:atlas-execution:atlas-execution-service"))
    implementation(project(":server:libs:atlas:atlas-file-storage:atlas-file-storage-service"))
    implementation(project(":server:libs:automation:automation-workflow:automation-workflow-execution:automation-workflow-execution-rest"))
    implementation(project(":server:libs:automation:automation-workflow:automation-workflow-execution:automation-workflow-execution-service"))
    implementation(project(":server:libs:automation:automation-swagger"))
    implementation(project(":server:libs:config:async-config"))
    implementation(project(":server:libs:config:environment-config"))
    implementation(project(":server:libs:config:jackson-config"))
    implementation(project(":server:libs:config:jdbc-config"))
    implementation(project(":server:libs:config:messages-config"))
    implementation(project(":server:libs:config:liquibase-config"))
    implementation(project(":server:libs:config:rest-config"))
    implementation(project(":server:libs:core:commons:commons-data"))
    implementation(project(":server:libs:core:commons:commons-util"))
    implementation(project(":server:libs:core:file-storage:file-storage-base64-service"))
    implementation(project(":server:libs:core:file-storage:file-storage-filesystem-service"))
    implementation(project(":server:libs:core:file-storage:file-storage-noop-service"))
    implementation(project(":server:libs:core:message:message-broker:message-broker-amqp"))
    implementation(project(":server:libs:core:message:message-broker:message-broker-kafka"))
    implementation(project(":server:libs:core:message:message-broker:message-broker-redis"))
    implementation(project(":server:libs:core:message:message-event:message-event-impl"))
    implementation(project(":server:libs:platform:platform-component:platform-component-rest"))
    implementation(project(":server:libs:platform:platform-data-storage:platform-data-storage-db:platform-data-storage-db-service"))
    implementation(project(":server:libs:platform:platform-file-storage:platform-file-storage-service"))
    implementation(project(":server:libs:platform:platform-workflow:platform-workflow-execution:platform-workflow-execution-rest:platform-workflow-execution-rest-impl"))
    implementation(project(":server:libs:platform:platform-workflow:platform-workflow-execution:platform-workflow-execution-service"))

    implementation(project(":server:ee:libs:atlas:atlas-execution:atlas-execution-remote-rest"))
    implementation(project(":server:ee:libs:automation:automation-configuration:automation-configuration-remote-client"))
    implementation(project(":server:ee:libs:core:discovery:discovery-redis"))
    implementation(project(":server:ee:libs:platform:platform-component:platform-component-registry:platform-component-registry-remote-client"))
    implementation(project(":server:ee:libs:platform:platform-configuration:platform-configuration-remote-client"))
    implementation(project(":server:ee:libs:platform:platform-data-storage:platform-data-storage-db:platform-data-storage-db-remote-rest"))
    implementation(project(":server:ee:libs:platform:platform-scheduler:platform-scheduler-remote-client"))
    implementation(project(":server:ee:libs:platform:platform-workflow:platform-workflow-execution:platform-workflow-execution-remote-rest"))

    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("com.zaxxer:HikariCP")
    runtimeOnly(libs.org.springdoc.springdoc.openapi.starter.webmvc.ui)
    runtimeOnly("org.springframework.boot:spring-boot-starter-actuator")
    runtimeOnly("org.springframework.boot:spring-boot-starter-aop")
    runtimeOnly("org.springframework.boot:spring-boot-starter-data-redis")

    testImplementation(project(":server:libs:test:test-int-support"))
}
