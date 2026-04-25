# User Management System (Spring Boot + MySQL)

## Overview
This project is a Spring Boot User Management System using base package `com.ums`.  
It provides CRUD operations along with status management using Enum.  
Users can update status and retrieve users filtered by status.

## Features
- Create user  
- Get all users  
- Get user by ID  
- Update user  
- Delete user  
- Update user status  
- Get users by status  
- Enum-based status handling  

## Project Structure
```
src/main/java/com/ums/
 ├── controller/
 ├── service/
 ├── repository/
 ├── model/
 ├── enums/
 └── exception/
```

## Status Enum
```java
package com.ums.enums;

public enum Status {
    ACTIVE,
    DEACTIVE
}
```

## User Entity
```java
package com.ums.model;

import com.ums.enums.Status;
import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;
}
```

## API Endpoints
- POST /users → Create user  
- GET /users → Get all users  
- GET /users/{id} → Get user by ID  
- PUT /users/{id} → Update user  
- DELETE /users/{id} → Delete user  
- PATCH /users/{id}/status → Update user status  
- GET /users/status/{status} → Get users by status  

## Database Configuration
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ums_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Sample Request

### Create User
```json
{
  "name": "Som",
  "email": "som@example.com"
}
```

### Update Status
```json
"DEACTIVE"
```

## Notes
- Base package: com.ums  
- Default status is ACTIVE  
- Status handled using Enum 

## Developer
Som Gupta
