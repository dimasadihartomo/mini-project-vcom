# V-COM

V-Com is a video **game** digital distribution service by Enigma. It was launched t in 2021 as a way for Enigma to provide automatic updates for their **games**, and expanded to include **games** from third-party publishers. Though initially developed for use on [Microsoft Windows](https://en.wikipedia.org/wiki/Microsoft_Windows) [operating systems](https://en.wikipedia.org/wiki/Operating_system), versions for [macOS](https://en.wikipedia.org/wiki/MacOS) and [Linux](https://en.wikipedia.org/wiki/Linux) were later released.



V-Com has total 5 databases

- User
- Profile
- Payment
- Order
- Product



In this Application, you can do simple CRUD (Create, Read, Update, and Delete) Method. It's using JDBC Template for manipulating the database. For making Order, you must top-up your V-Pocket (E-Money) to buy your games. But there are several Free To Play Games in our product list.

For running this app, you must setting the application.properties

```
server.port: 8083
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://${DB_HOST:localhost}:3306/vmart?serverTimezone=UTC
    username: root
    password: root
  jpa:
    hibernate.ddl-auto: update
    generate-ddl: true
    show-sql: true
    properties.hibernate.dialect: org.hibernate.dialect.MySQL57Dialect
  messages.basename: i18n/messages
```

Change the server port and your MySQL schema, and I'm using MySQL for making the database.

After that run the app in the terminal`mvn spring-boot:run`

Your database automatically create at the your database in MySQL

I'm using JWT to Generate token so if you want to access the other url port, you must setting in WebSecurityConfig to permit all the url or you can sign up your username, sign in and get the token from there.

