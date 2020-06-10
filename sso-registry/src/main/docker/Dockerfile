FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD sso-registry.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
EXPOSE 9200
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]