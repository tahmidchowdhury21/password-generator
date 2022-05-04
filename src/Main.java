import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Instantiating the class variable
		PasswordGenerator passwordGenerator = new PasswordGenerator();

		// Getting the userInputs
		Scanner userInput = new Scanner(System.in);
		System.out.print("\nEnter the length of the password: ");

		int length = userInput.nextInt();
		
		System.out.println();

		// generated password
		String generatedPassword = passwordGenerator.generateRandomPassword(length);
		System.out.println(generatedPassword);
		
		userInput.close();

	}

}
