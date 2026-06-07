# Base image with Java + Maven
FROM maven:3.9-eclipse-temurin-17

# Install Chrome for Selenium
RUN apt-get update && apt-get install -y \
    wget gnupg curl unzip \
    && wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb http://dl.google.com/linux/chrome/deb/ stable main" \
       > /etc/apt/sources.list.d/google.list \
    && apt-get update \
    && apt-get install -y google-chrome-stable \
    && apt-get clean

WORKDIR /app

COPY pom.xml .
COPY src ./src

# Run tests when container starts
CMD ["mvn", "clean", "test"]