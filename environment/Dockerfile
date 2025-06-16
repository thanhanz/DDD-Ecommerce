FROM openjdk:21

ARG FILE_JAR=target/*.jar

ADD ${FILE_JAR} ddd-ecommerce-app.jar

ENTRYPOINT ["java","-jar","/ddd-ecommerce-app.jar"]

EXPOSE 8080