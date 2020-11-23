package com.epam.jwd.app;

import com.epam.jwd.model.Human;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

	private static final Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[] args) {

		logger.info("Entering application.");
		Human[] humans = new Human[5];
		humans[0] = new Human(33, "John");
		humans[1] = new Human(53, "Olya");
		humans[2] = new Human(43, "Sasha");
		humans[3] = new Human(23, "Mike");
		humans[4] = new Human(29, "Vasya");

		Human[] humans1 = new Human[0];
		logger.fatal("Array humans1 is empty.");

		for (Human human : humans) {
			logger.trace("Human " + human.getName() + " with age: " + human.getAge() + " was created");
		}

		logger.info("Exiting application.");
	}
}
