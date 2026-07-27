# Uoion Apps21 : Springboot JAVA Application with MySQL database connection.

    docker compose up -d
    docker compose up -d --build
    docker compose down
    docker compose ps

    docker compose logs -f
    docker compose logs -f [cointainer-name]

Rebuild after code changes:

    mvn clean package -DskipTests
    docker compose up -d --build

Build Docker Image:

    docker build -t student-app:v1 .

Run only the Spring Boot container:

    docker run -d --name student-app -p 8080:8080 student-app:v1
    This works only if your MySQL is already running and reachable

Access the application:

    http://localhost:8080/


Verify Spring Boot is listening:

    docker exec -it uoion-apps20 sh
    netstat -tln
    

Run the container: If your MySQL is running on your Ubuntu host:

    docker run -d --name uoion-apps21 -p 8080:8080 -e SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/studentdb -e SPRING_DATASOURCE_USERNAME=root -e SPRING_DATASOURCE_PASSWORD=root123 uoion-apps20:v1

On Ubuntu, host.docker.internal may not be available by default. You can add it with:

    docker run -d --name uoion-apps20 --add-host=host.docker.internal:host-gateway -p 8080:8080 -e SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/studentdb -e SPRING_DATASOURCE_USERNAME=root -e SPRING_DATASOURCE_PASSWORD=root123  uoion-apps20:v1

If MySQL is also running in Docker
If you're using Docker Compose and your MySQL service is named mysql, then use:

    spring.datasource.url=jdbc:mysql://mysql:3306/studentdb

or pass it as an environment variable:

    -e SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/studentdb


Project Structure: Your project should look like this:

    uoion-apps20/
    ├── Dockerfile
    ├── docker-compose.yml
    ├── pom.xml
    ├── src/
    └── target/
        └── uoion-apps20-0.0.1-SNAPSHOT.jar


Build the Docker image

    docker build -t student-app:v1 .

Verify:

    docker images
