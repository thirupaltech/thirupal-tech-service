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

## User APIs
- `POST /api/users/register` creates a user.
- `POST /api/users/login` verifies email and password and returns the user profile. Invalid credentials and inactive accounts return `401 Unauthorized`.

Login request:

```json
{
	"email": "user@example.com",
	"password": "your-password"
}
```

The login endpoint currently verifies credentials only; it does not issue a token or create a server-side session.

## Database config
The app uses these default values:
- JDBC URL: `jdbc:postgresql://localhost:5432/thirupal_tech_db`
- Username: `postgres`
- Password: `postgres`

## CORS config
The API allows browser requests from `http://localhost:3000`, `http://localhost:4200`, and `http://localhost:5173` by default. Set `CORS_ALLOWED_ORIGINS` to a comma-separated list of exact frontend origins for other environments, for example `https://portal.example.com`.

## Notes
This service is created as a separate application from the frontend portal so the UI and backend can evolve independently.
