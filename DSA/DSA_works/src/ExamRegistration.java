import java.util.Scanner;

public class ExamRegistration {

    public static void validateRegistration(
            String studentId,
            String name,
            int age,
            double examMark,
            int subjects)
            throws InvalidRegistrationException {

        if (studentId.trim().isEmpty()) {
            throw new InvalidRegistrationException(
                    "Student ID cannot be empty.");
        }

        if (name.trim().isEmpty()) {
            throw new InvalidRegistrationException(
                    "Student name cannot be empty.");
        }

        if (age < 18) {
            throw new InvalidRegistrationException(
                    "Student age must be at least 18.");
        }

        if (examMark < 0 || examMark > 100) {
            throw new InvalidRegistrationException(
                    "Exam mark must be between 0 and 100.");
        }

        if (subjects < 1 || subjects > 5) {
            throw new InvalidRegistrationException(
                    subjects > 5
                            ? "Maximum allowed subjects is 5."
                            : "Minimum allowed subjects is 1.");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== EXAM REGISTRATION SYSTEM =====");

        try {
            System.out.print("Enter Student ID: ");
            String studentId = input.nextLine();

            System.out.print("Enter Student Name: ");
            String name = input.nextLine();

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(input.nextLine());

            System.out.print("Enter Exam Mark: ");
            double examMark = Double.parseDouble(input.nextLine());

            System.out.print("Enter Number of Subjects: ");
            int subjects = Integer.parseInt(input.nextLine());

            validateRegistration(
                    studentId, name, age, examMark, subjects);

            System.out.println("\nRegistration Successful!");
            System.out.println("student id:" + studentId);
            System.out.println("Student: " + name);
            System.out.println("Registered Subjects: " + subjects);
            System.out.println("student age: " + age   );
            System.out.println("exam marks: " + examMark);

        } catch (InvalidRegistrationException e) {
            System.out.println("\nRegistration Failed!");
            System.out.println("Error: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("\nRegistration Failed!");
            System.out.println(
                    "Error: Please enter valid numbers for age, mark, and subjects.");

        } finally {
            System.out.println("\nRegistration attempt completed.");
            input.close();
        }
    }
}