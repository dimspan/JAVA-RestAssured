# Use a base image with Java and Maven pre-installed
FROM maven:3.8.3-openjdk-17

  # Set working directory
WORKDIR /mnt/restassured

  # Download dependencies to cache layers and speed up builds
#RUN /usr/bin/mvn dependency:resolve

  # Default command when container starts
ENTRYPOINT ["/bin/bash"]