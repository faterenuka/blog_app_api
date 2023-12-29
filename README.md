# Blog App Api
This is an Individual project, I have worked on rest API service for a Blog Application . This service provides users to register and login, create post, add comment to the post.

# Functionalities
-   User can register/login
-   See all posts
-   Find Post by category/user
-   Add Comment to the post
-   Upload post with image


## Backend Work
-  User Authentication of signUp and Login using Spring security
-  Proper Exception Handling
-  Proper Input Validation
-  Data Stored in the database(mySQL)

  
## Installation and Run
-  You can clone this repo and start the serve on localhost
-   Before running the API server, we should update the database config inside the application.properties file.
-   Update the port number, username and password as per our local database config.
```
server.port=8089

spring.datasource.url=jdbc:mysql://localhost:3306/blog_app_apis
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.show-sql=true

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
#create , update ,  create-drop, validate
spring.jpa.hibernate.ddl-auto=update
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
project.image=images/
logging.level.org.springframework.security=DEBUG
spring.profiles.active=dev

spring.security.user.name=Renuka
spring.security.user.password==Renuka
spring.security.user.roles==Admin
```
# Tech Stacks

-   Java Core
-   Spring Data JPA
-   Spring security
-   Spring Boot
-   Hibernate
-   MySQL

### User
```
Register User

{
    "id": 28,
    "name": "navya",
    "email": "navya@gmail.com",
    "password": "navya@23",
    "about": "Learning programming language",
    "roles": [
        {
            "id": 502,
            "name": "Normal User"
        }
    ]
}

 User Login
 
{
    "userName": "navya@gmail.com",
    "password": "navya@23"
}
```

### Post
```
{
    "postId": 7,
    "title": "Title for Computer Science Post",
    "content": "Content Is Realated to Computer Science",
    "imageName": "default.png",
    "addedDate": 1703656704254,
    "category": {
        "categoryId": 6,
        "categoryTitle": "Computer Science ",
        "categoryDescription": "This category contains topic related to Computer Science "
    },
    "user": {
        "id": 27,
        "name": "kavya",
        "email": "kavya@gmail.com",
        "password": "kavi@23",
        "about": "Learning programming language",
        "roles": [
            {
                "id": 502,
                "name": "Role_Normal"
            }
        ]
    },
    "comments": [],
    "id": 7
}

Upload Post with Image

{
    "postId": 6,
    "title": "Title for Computer Science Post",
    "content": "Content Is Realated to Computer Science",
    "imageName": "b74eb0d2-0649-4ee5-91d7-b07adbaac987.jpeg",
    "addedDate": 1703654396184,
    "category": {
        "categoryId": 6,
        "categoryTitle": "Computer Science ",
        "categoryDescription": "This category contains topic related to Computer Science "
    },
    "user": {
        "id": 27,
        "name": "kavya",
        "email": "kavya@gmail.com",
        "password": "kavi@23",
        "about": "Learning programming language",
        "roles": [
            {
                "id": 502,
                "name": "Role_Normal"
            }
        ]
    },
    "comments": [],
    "id": 6
}
```
### Category
```
{
    "categoryId": 6,
    "categoryTitle": "Computer Science ",
    "categoryDescription": "This category contains topic related to Computer Science "
}

```
### Comments
```
{
    "commentId": 10,
    "content": "This is new comment of post 5"
}
```

# Backend

## Swagger UI

## Thank You! Your Blog is Displayed : )
[![SwaggerUI](https://github.com/faterenuka/blog_app_api/blob/main/images/thank-you-blogging.jpg?raw=true)](https://github.com/faterenuka/blog_app_api/blob/main/images/thank-you-blogging.jpg?raw=true)
