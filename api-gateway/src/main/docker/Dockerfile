FROM oracle/openjdk:8

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    SLEEP=0 \
    JAVA_OPTS=""

# install netcat into oracle linux image
RUN yum install -y nc

# add directly the jar
ADD *.jar /app.jar
EXPOSE 8080
CMD echo "The application will start in ${SLEEP}s..." && \
    sleep ${SLEEP} && \
    java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar
