package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	private DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

//	private void test() {
//		Film film = db.findFilmById(1);
//		System.out.println(film);
//	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void printMenu() {
		System.out.println("-----------------------");
		System.out.println("1: Look Up by ID");
		System.out.println("2: Look Up by keyword");
		System.out.println("3: Exit Application");
		System.out.println("-----------------------");

	}

	private void startUserInterface(Scanner input) {
		int userChoice = 0;
		boolean running = true;
		Film film = new Film();

		System.out.println("Welcome to FilmQuery!!");

		while (running) {
			printMenu();
			userChoice = input.nextInt();
			input.nextLine();

			if (userChoice == 1) {
				System.out.println("Please provide the film id: ");
				int filmId = input.nextInt();
				input.nextLine();
				film = db.findFilmById(filmId);

				if (film == null) {
					System.out.println("Film not found.");
				} else {
					System.out.println("Film found:");
					System.out.println("Title: " + film.getTitle());
					System.out.println("Year: " + film.getReleaseYear());
					System.out.println("Rating: " + film.getRating());
					System.out.println("Language: " + film.getLanguage());
					System.out.println("Description: " + film.getDescription());
					System.out.println("Cast: \n" + film.printActors());
				}
			} else if (userChoice == 2) {
				System.out.println("Please provide the keyword: ");
				String keyword = input.nextLine();
				List<Film> films = db.findFilmByQuery(keyword);

				if (films.isEmpty()) {
					System.out.println("No matching films found.");
				} else {
					System.out.println("Matching films:");
					for (Film foundFilm : films) {
						System.out.println("Title: " + foundFilm.getTitle());
						System.out.println("Year: " + foundFilm.getReleaseYear());
						System.out.println("Rating: " + foundFilm.getRating());
						System.out.println("Language: " + film.getLanguage());
						System.out.println("Description: " + foundFilm.getDescription());
						System.out.println("Cast: \n" + foundFilm.printActors());
					}
				}

			} else if (userChoice == 3) {
				System.out.println("Goodbye....");
				System.exit(0);
				running = false;
			} else {
				System.out.println("Please enter a valid choice.");
			}

		}

	}

}
