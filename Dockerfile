FROM openjdk:11
EXPOSE 8080
COPY target/Shop-Application.jar Shop-Application.jar
ENTRYPOINT ["java","-jar","/Shop-Application.jar"]