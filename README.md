Job Recruitment System Project

This is my project for the Java course. It is a simple Job Recruitment System (JRS). It can manage different types of users like Recruiters and Candidates and save them into a database so the data is not lost when you close the program.
What this project does::

-You can add Recruiters (with company name) and Candidates (with portfolio link).

-Everything goes to PostgreSQL. I used JDBC to connect Java and the database.

-If you try to use the same email twice the system shows a "Business Rule" error. It doesn't crash, it just catches the exception.

-I used a parent class User and child classes Candidate and Recruiter. The main list uses Polymorphism to show everyone.

How to start it

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