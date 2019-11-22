FROM java:8
VOLUME /tmp
EXPOSE 8080
ADD /build/libs/rps-0.0.1-SNAPSHOT.jar rps-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","rps-0.0.1-SNAPSHOT.jar"]