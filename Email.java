import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String alternateEmail;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 15;
    private String companySuffix = "aeycompany.com";

    // Constructor to receive the first, name and last name

    public Email(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;

        // System.out.println("Email Created " + this.firstName + " " + this.lastName);

        // call a method asking for the department -return the department
        this.department = setDepartment();
        // System.out.println("Department: " + this.department);

        // call a method that returns a random password-returns random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is : " + this.password);

        // combine elements to generate email
        email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        // System.out.println("Your email is: " + email);
    }

    // Ask for the department
    private String setDepartment() {
        System.out.println("New worker: " + firstName
                + ". DEPARTMENT CODES: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "Development";
        } else if (depChoice == 3) {
            return "Accounting";
        } else {
            return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%&";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);

        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapicity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "Display Name: " + firstName + " " + lastName + "\nCompany Email: " + email + "\nMailbox Capacity: "
                + mailboxCapacity + "mb";
    }
}