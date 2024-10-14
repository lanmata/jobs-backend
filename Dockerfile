FROM amazoncorretto:17.0.10-alpine
LABEL version="1.1"
LABEL description="Jobs Backend API"
LABEL mantainer="Luis Mata luis.antonio.mata@gmail.com"

ENV SPRING_BOOT_PROFILE_ACTIVE local
ENV SPRING_CLOUD_CONFIG_LABEL develop
ENV CONFIG_SERVER_URL http://prx-qa.config-server.tst
ENV VAULT_SERVER_URL http://prx-qa.vault.tst
ENV VAULT_TOKEN s.1XZ1Z1Z1Z1Z1Z1Z1Z1Z1Z1Z1
ARG TARGET_FILE=target/
ARG CRT_QA_DOCKER_FILE=prx-qa
ARG RESOURCE_PATH=src/main/resources/
WORKDIR /usr/local/runme
COPY ${TARGET_FILE}${JAR_FILE} ${JAR_FILE}
COPY ${RESOURCE_PATH}${CRT_QA_DOCKER_FILE}.jks ${CRT_QA_DOCKER_FILE}.jks

RUN addgroup -S appmng && adduser -S jvapps -G appmng
RUN chown -R jvapps:appmng .
RUN chmod -R 740 .
RUN keytool -import -alias ${CRT_QA_DOCKER_FILE} -keystore /usr/lib/jvm/default-jvm/jre/lib/security/cacerts \
    -file ${CRT_QA_DOCKER_FILE}.jks -storepass changeit -noprompt
RUN rm *.crt

USER jvapps:appmng

EXPOSE 8191
ENTRYPOINT ["java", "-Dspring.application.name=jobs-backend-api", "-jar", "jobs-backend.jar" ]
