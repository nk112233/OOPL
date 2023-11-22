import java.util.ArrayList;
import java.util.Scanner;
public class assgn7 {
    // Method to count elements based on a specified condition
    static int count(ArrayList<Integer> nums, int condition) {
        int count = 0;
        for (int num : nums) {
            switch (condition) {
                case 1: // Even numbers
                    if (num % 2 == 0) {
                        count++;
                    }
                    break;
                case 2: // Odd numbers
                    if (num % 2 != 0) {
                        count++;
                    }
                    break;
                case 3: // Prime numbers
                    if (isPrime(num)) {
                        count++;
                    }
                    break;
                case 4: // Palindromes
                    if (isPalindrome(num)) {
                        count++;
                    }
                    break;
                default:
                    System.out.println("Invalid condition.");
            }
        }
        return count;
    }

    // Method to check if a number is prime
    static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a number is a palindrome
    static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();

        // Input: Number of elements and the elements themselves
        System.out.print("Enter the number of elements: ");
        int numElements = scanner.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < numElements; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            numbers.add(scanner.nextInt());
        }

        // Menu for choosing the property to count
        while (true) {
            System.out.println("Choose the property to count:");
            System.out.println("1. Even numbers");
            System.out.println("2. Odd numbers");
            System.out.println("3. Prime numbers");
            System.out.println("4. Palindromes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting the program.");
                break;
            }

            // Count and display the number of elements with the chosen property
            int count = count(numbers, choice);
            System.out.println("Number of elements with the chosen property: " + count);
        }

        scanner.close();
    }
}
