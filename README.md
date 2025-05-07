# Book Management System Documentation

## Project Overview
This is a Spring Boot-based Book Management System that provides functionality to manage authors and their books. The application follows a standard three-tier architecture with a web-based user interface built using JSP.

## Technology Stack
- **Backend Framework**: Spring Boot 3.2.3
- **Database**: MySQL (Production), H2 (Testing)
- **View Layer**: JSP with JSTL
- **Build Tool**: Maven
- **Java Version**: 17
- **Testing**: JUnit 5, Mockito, Spring Test

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/example/demo/
│   │       ├── config/         # Configuration classes
│   │       ├── controller/     # MVC Controllers
│   │       ├── model/          # Entity classes
│   │       ├── repository/     # Data access layer
│   │       ├── service/        # Business logic layer
│   │       └── DemoApplication.java
│   ├── resources/
│   │   └── application.properties
│   └── webapp/
│       └── WEB-INF/
│           └── views/          # JSP templates
└── test/
    ├── java/
    │   └── com/example/demo/
    │       ├── repository/     # Repository tests
    │       ├── service/        # Service tests
    │       └── config/         # Test configurations
    └── resources/
        └── application.properties
```

## Core Features

### Author Management
- View list of all authors
- Add new authors
- Edit existing author details
- Delete authors
- View author details with associated books

### Book Management
- View list of all books
- Add new books
- Edit book details
- Delete books
- Associate books with authors

## API Endpoints

### Author Endpoints
```
GET    /authors              - List all authors
GET    /authors/{id}         - Get author by ID
GET    /authors/new          - Show new author form
POST   /authors              - Create new author
GET    /authors/{id}/edit    - Show edit author form
PUT    /authors/{id}         - Update author
DELETE /authors/{id}         - Delete author
```

### Book Endpoints
```
GET    /books               - List all books
GET    /books/{id}          - Get book by ID
GET    /books/new           - Show new book form
POST   /books               - Create new book
GET    /books/{id}/edit     - Show edit book form
PUT    /books/{id}          - Update book
DELETE /books/{id}          - Delete book
```

## Data Models

### Author
- id (Long, Primary Key)
- name (String)
- email (String)
- biography (String)
- books (One-to-Many relationship with Book)

### Book
- id (Long, Primary Key)
- title (String)
- isbn (String)
- price (BigDecimal)
- publicationDate (LocalDate)
- author (Many-to-One relationship with Author)

## Testing Strategy

### Unit Tests
1. **Service Layer Tests**
   - AuthorServiceTest: Tests business logic for author operations
   - BookServiceTest: Tests business logic for book operations
   - Coverage includes CRUD operations and exception handling

2. **Repository Layer Tests**
   - AuthorRepositoryTest: Tests data access operations for authors
   - BookRepositoryTest: Tests data access operations for books
   - Uses H2 in-memory database for testing

### Test Configuration
- Uses H2 in-memory database for testing
- Configured in `src/test/resources/application.properties`
- SQL queries are logged during tests for debugging

## UI Components

### Author Views
- `author-list.jsp`: Displays all authors in a table format
- `author-form.jsp`: Form for creating/editing authors
- `author-detail.jsp`: Shows detailed view of an author with their books

### Book Views
- `book-list.jsp`: Displays all books in a table format
- `book-form.jsp`: Form for creating/editing books
- `book-detail.jsp`: Shows detailed view of a book with author information
