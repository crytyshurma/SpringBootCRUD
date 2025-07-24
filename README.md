# Spring Boot Family Member Management API

This is a simple Spring Boot RESTful API to manage family member data. It demonstrates core backend features including CRUD operations, validation, pagination, and search functionality. The application uses Spring Boot with Spring Data JPA and an H2 in-memory database for data persistence.

## Features

- Add, update, delete family members
- Fetch all members or paginated data
- Input validation for request bodies
- In-memory database using H2
- Swagger UI for interactive API testing

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Swagger (Springdoc OpenAPI)

## Project Structure

```

src
├── main
│   ├── java
│   │   └── com.example.demo
│   │       ├── controller (HelloController.java)
│   │       ├── model (FamilyMember.java)
│   │       ├── repository (FamilyMemberRepository.java)
│   │       └── DemoApplication.java
│   └── resources
│       ├── application.properties

````

## API Endpoints

| Method | Endpoint                  | Description                      |
|--------|---------------------------|----------------------------------|
| GET    | `/`                       | Base welcome route               |
| GET    | `/about`                  | Returns information about app    |
| GET    | `/family`                 | Fetch all family members         |
| GET    | `/family/page`           | Fetch paginated and searchable data |
| POST   | `/add-member`            | Add a new member                 |
| PUT    | `/update-member/{id}`    | Update a member by ID            |
| DELETE | `/delete-member/{id}`    | Delete a member by ID            |

## Sample Request Payloads

### Add Member
```json
{
  "name": "John Doe",
  "age": 30,
  "weight": 75,
  "gender": "Male"
}
````

### Update Member

```json
{
  "id": 1,
  "name": "Jane Doe",
  "age": 28,
  "weight": 65,
  "gender": "Female"
}
```

### Pagination & Search (GET `/family/page`)

Query Parameters:

* `page` (default: 0)
* `size` (default: 5)
* `name` (optional, for searching by name)

Example:

```
/family/page?page=0&size=3&name=Jane
```

## Setup Instructions

### Prerequisites

* Java 17+
* Maven

### Run Locally

1. Clone the repository:

   ```
   git clone https://github.com/your-username/your-repo-name.git
   ```

2. Navigate to the project directory:

   ```
   cd your-repo-name
   ```

3. Build the project:

   ```
   mvn clean install
   ```

4. Run the application:

   ```
   mvn spring-boot:run
   ```

5. Access the application at:

   ```
   http://localhost:8080/
   ```

### Swagger UI (API Documentation)

After running the application, access Swagger UI here:

```
http://localhost:8080/swagger-ui/index.html
```

## Database Access (H2 Console)

You can access the in-memory H2 database at:

```
http://localhost:8080/h2-console
```

* JDBC URL: `jdbc:h2:mem:testdb`
* Username: `sa`
* Password: (leave blank)
