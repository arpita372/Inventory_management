# Use official openjdk 17 image from docker hub
FROM openjdk:17
# Set working directory inside the container
WORKDIR /app
#Copy the compiled java application JAR file into the container
COPY ./target/inventory-management.jar /app
#Expose the port the springboot application will run on
EXPOSE 8080 
#Command to run the application
CMD ["java", "-jar", "inventory-management.jar" ]
