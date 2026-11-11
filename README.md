# Thirupal Tech Service

Standalone Spring Boot backend for the Thirupal Tech portal.

## Tech stack
- Java 17
- Spring Boot 3.3.x
- PostgreSQL
- Spring Data JPA
- Maven

## Run PostgreSQL locally

```bash
docker-compose up -d
```

## Run the application

```bash
mvn spring-boot:run
```

## Application URL
- Health check: http://localhost:8081/api/health

## Database config
The app uses these default values:
- JDBC URL: `jdbc:postgresql://localhost:5432/thirupal_tech_db`
- Username: `postgres`
- Password: `postgres`

## Notes
This service is created as a separate application from the frontend portal so the UI and backend can evolve independently.
