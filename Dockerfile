# Use official openjdk 21 image from docker hub
FROM openjdk:21
# Set working directory inside the container
WORKDIR /app
#Copy the compiled java application JAR file into the container
COPY ./target/inventory-management-0.0.1-SNAPSHOT.jar /app
#Expose the port the springboot application will run on
EXPOSE 8080 
#Command to run the application
CMD ["java", "-jar", "inventory-management-0.0.1-SNAPSHOT.jar" ]
