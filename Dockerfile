FROM openjdk:8
EXPOSE 8080
ADD target/Shop-Application.jar Shop-Application.jar
ENTRYPOINT ["java","-jar","/Shop-Application.jar"]