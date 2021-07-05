FROM maven:3-openjdk-16
EXPOSE 8080
WORKDIR /app
COPY . /app/
RUN mvn clean install
RUN mvn package
CMD ["mvn", "spring-boot:run"]