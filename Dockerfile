FROM openjdk:8-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/app-0.0.1-SNAPSHOT.jar app-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar app-0.0.1-SNAPSHOT.jar
# ADD target/app.jar app.jar
# ENTRYPOINT [ "java", "-jar", "/app.jar" ]
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar