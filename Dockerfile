FROM openjdk:11
EXPOSE 8090
COPY target/Shop-Application.jar Shop-Application.jar
ENTRYPOINT ["java","-jar","/Shop-Application.jar"]