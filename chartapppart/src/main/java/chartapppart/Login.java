package chartapppart;

public class Login {
    String username;
    String password;
    String phoneNumber;
    String firstName;
    String lastName;

    public Login() {}
    
    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        if (password == null) return false;
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }
        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }

    // Regex source: W3Schools Java RegEx article, https://www.w3schools.com/java/java_regex.asp, Accessed: 18 September 2026
    // Regex source: GeeksforGeeks Java RegEx for SA numbers, https://www.geeksforgeeks.org/how-to-validate-international-phone-numbers-in-java/, Accessed: 18 September 2026
    public boolean checkCellPhoneNumber(String phone) {
        return phone != null && phone.matches("^\\+27\\d{9}$");
    }

    public String getUserNameMessage(String username) {
        if (checkUserName(username)) {
            return "Username successfully captured.";
        } else {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
    }

    public String getPasswordMessage(String password) {
        if (checkPasswordComplexity(password)) {
            return "Password successfully captured.";
        } else {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
    }

    public String registerUser(String username, String password, String phoneNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(phoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        return "User registered successfully.";
    }

    public String registerUser(String username, String password, String phoneNumber, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        return registerUser(username, password, phoneNumber);
    }

    public boolean loginUser(String username, String password) {
        return this.username != null && this.username.equals(username) && this.password.equals(password);
    }

    public String returnLoginStatus(boolean success) {
        if (success) {
            if (firstName != null && lastName != null) {
                return "Welcome " + firstName + " " + lastName + " it is great to see you again.";
            } else {
                return "Welcome " + username + " it is great to see you again.";
            }
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    public String returnLoginStatus(String username, String password, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        boolean logged = loginUser(username, password);
        return returnLoginStatus(logged);
    }
}