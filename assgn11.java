import java.util.Scanner;
// PaymentStrategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete CreditCardPaymentStrategy
class CreditCardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPaymentStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card ending with " + cardNumber.substring(cardNumber.length() - 4));
    }
}

// Concrete PayPalPaymentStrategy
class PayPalPaymentStrategy implements PaymentStrategy {
    private String email;

    public PayPalPaymentStrategy(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal with email: " + email);
    }
}

// Concrete BitCoinPaymentStrategy
class BitCoinPaymentStrategy implements PaymentStrategy {
    private String bitcoinAddress;

    public BitCoinPaymentStrategy(String bitcoinAddress) {
        this.bitcoinAddress = bitcoinAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using BitCoin address: " + bitcoinAddress);
    }
}

// Context class (ShoppingCart)
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Example usage


public class assgn11 {
    public static void main(String[] args) {
        // Create payment strategies
        PaymentStrategy creditCardStrategy = new CreditCardPaymentStrategy("1234-5678-9012-3456");
        PaymentStrategy paypalStrategy = new PayPalPaymentStrategy("nk.kadu@example.com");
        PaymentStrategy bitcoinStrategy = new BitCoinPaymentStrategy("1AbCdEfGhIjKLMnoPQRSTuVwXyZ");

        // Create shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            // Display menu
            System.out.println("Select Payment Method:");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");
            System.out.println("3. BitCoin");
            System.out.println("0. Exit");

            // Get user choice
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            // Process user choice
            switch (choice) {
                case 1:
                    cart.setPaymentStrategy(creditCardStrategy);
                    break;
                case 2:
                    cart.setPaymentStrategy(paypalStrategy);
                    break;
                case 3:
                    cart.setPaymentStrategy(bitcoinStrategy);
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

            // If the user didn't choose to exit, proceed to checkout
            if (choice != 0) {
                System.out.print("Enter the amount to pay: ");
                int amount = scanner.nextInt();
                cart.checkout(amount);
            }

        } while (choice != 0);

        // Close the scanner
        scanner.close();
    }
}

