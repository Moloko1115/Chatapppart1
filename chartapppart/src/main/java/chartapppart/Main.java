package chartapppart;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login login = new Login();

        System.out.println("=== USER REGISTRATION ===");
        while (true) {
            System.out.print("Enter first name: ");
            String firstName = input.nextLine();
            System.out.print("Enter last name: ");
            String lastName = input.nextLine();
            System.out.print("Enter a username: ");
            String username = input.nextLine();
            System.out.print("Enter a password: ");
            String password = input.nextLine();
            System.out.print("Enter your South African phone number (+27...): ");
            String phone = input.nextLine();

            String response = login.registerUser(username, password, phone, firstName, lastName);
            System.out.println(response);

            if (response.equals("User registered successfully.")) {
                break;
            }
            System.out.println("Please try again\n");
        }

        System.out.println("\n=== USER LOGIN ===");
        System.out.print("Enter your username: ");
        String loginUsername = input.nextLine();
        System.out.print("Enter your password: ");
        String loginPassword = input.nextLine();

        boolean loggedIn = login.loginUser(loginUsername, loginPassword);
        String loginMessage = login.returnLoginStatus(loggedIn);
        System.out.println(loginMessage);
    }
}