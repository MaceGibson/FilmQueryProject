# Film Query Project

## Description
This project is a Java application that interacts with a MySQL database to query and retrieve information about films and actors. It includes classes for films and actors, a database accessor for database interactions, and a user interface for querying films by ID or pattern match/keyword.

## Technologies Used
- Java
- MySQL
- JDBC
- GitHub

## How to Use
1. Clone the repository to your local machine:

	```git clone https://github.com/your-username/FilmQueryProject.git```

2. Set up your MySQL database and update the database connection details in the `DatabaseAccessorObject` class.

3. Run the `FilmQueryApp` class to launch the user interface.

	```
	cd FilmQueryProject/src/com/skilldistillery/filmquery/app
	javac FilmQueryApp.java
	java FilmQueryApp
	```

4. Follow the prompts to query films by their ID, keyword, or exit the program.

## Lessons Learned
- Implementing JDBC for database connectivity.
- Designing and implementing classes for entities (films and actors) OOP.
- User interface development and input validation.
- Using switch statements for mapping language IDs to language names.
- [Resolved]Had prompting issues due to 'input.nextInt()' not consuming newLine character.