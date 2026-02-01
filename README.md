Job Recruitment System Project
This is my project for the Java course. It is a simple Job Recruitment System (JRS). It can manage different types of users like Recruiters and Candidates and save them into a database so the data is not lost when you close the program.


What this project does::

-You can add Recruiters (with company name) and Candidates (with portfolio link).

-Everything goes to PostgreSQL. I used JDBC to connect Java and the database.

-If you try to use the same email twice the system shows a "Business Rule" error. It doesn't crash, it just catches the exception.

-I used a parent class User and child classes Candidate and Recruiter. The main list uses Polymorphism to show everyone.


How to start it:

-Create a database in your pgAdmin named job_rec_system.

-Open the schema.sql file and copy-paste the code into your Query Tool in pgAdmin to create the tables.

-You must add the postgresql-42.7.9.jar file to your project libraries in IntelliJ (File > Project Structure > Libraries). If you don't do this, it will say "Driver not found."

-Go to src/com/jrs/util/DatabaseConnection.java and change the password to your own Postgres password.

-Open Main.java and run it


Project Structure:

-com.jrs.model: The classes for User, Candidate, and Recruiter.

-com.jrs.service: The logic for registering and listing users.

-com.jrs.exception: My custom error classes.

-com.jrs.util: The code for connecting to the database.

-com.jrs.controller: The Main class to test everything.

My reflection:

CRUD was difficult for me because connecting the database with JDBC needs being careful. I spent a lot of time fixing errors with the driver and my password, and it was hard to learn how to turn SQL rows into Java objects correctly.


Assignment 4 Update:
SOLID Documentation:
I updated the code to follow SOLID rules.
-SRP (Single Responsibility): Each class only has one job. UserRepository only does SQL, and UserService only does business logic.

-OCP (Open-Closed): I can add a new type of user (like Admin) by making a new subclass. I don't need to change the code I already wrote for User.

-LSP (Liskov Substitution): My program treats Candidate and Recruiter exactly like a User. The system doesn't break when using the child classes instead of the parent.

-ISP (Interface Segregation): I made small interfaces like Validatable. Classes only implement the small things they need, so the code is not messy.

-DIP (Dependency Inversion): My UserService doesn't create the database repository inside. It takes the interface in the constructor. This is "Dependency Injection"


Advanced OOP Features:
-I used these advanced features to make the system better.

-Generics: My CrudRepository<T> uses <T> so it can work with any type of object, not just Users.

-Lambdas: I used a lambda (u1, u2) -> ... to sort the user list by name very easily in one line.

-Reflection: I made a tool that looks at the Recruiter class while the program is running to show its private fields and methods in the console.

-Interface Methods: My Validatable interface has a default method to log status and a static method to check if an email is valid.


C. OOP Documentation

-Abstract Class: User is abstract. You cannot create a "User" object, only Candidate or Recruiter.

-Composition: My JobPosting class "has-a" Recruiter. It is not inheritance; it is a relationship between two objects.

-Polymorphism: I put all candidates and recruiters in a List<User>. When I call getRole(), Java automatically knows which one to use.

-UML Diagram: (Make sure to include your high-detail diagram here).

D. Database Section

-Schema: I used two tables: users and jobs.

-Constraints: I used SERIAL PRIMARY KEY for IDs and UNIQUE for the email so no two people have the same email

Sample Insert: INSERT INTO users (name, email, role, additional_info) VALUES ('Krabs', 'k@test.com', 'RECRUITER', 'KrustyKrabs');