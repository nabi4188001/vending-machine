import java.util.Scanner;
/**
 * Represents a vending machine with a menu-driven interface.
 */
public class VendingMachine {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private Product[][] products = new Product[ROWS][COLS];
    private static double totalSales = 0;
    private static final String WELCOME_MESSAGE = "Welcome to the Vending Machine!";

    public VendingMachine() {
        initializeProducts();
    }

    private void initializeProducts() {
        String[] productNames = {"Chocolate", "Chips", "Soda", "Water", "Juice", "Candy", "Cookies", "Gum", "Granola Bar"};
        double[] productPrices = {1.5, 2.0, 1.75, 1.0, 2.5, 1.25, 1.75, 0.75, 2.0};
        int index = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                products[i][j] = new Product(productNames[index], productPrices[index]);
                index++;
            }
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(WELCOME_MESSAGE);
        while (true) {
            System.out.println("\nVending Machine Menu:");
            System.out.println("1. Buy a product");
            System.out.println("2. Restock the machine");
            System.out.println("3. Display available products");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    buyProduct(scanner);
                    break;
                case 2:
                    restockMachine(scanner);
                    break;
                case 3:
                    displayProducts();
                    break;
                case 4:
                    System.out.println("Total sales: $" + totalSales);
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void buyProduct(Scanner scanner) {
        displayGraphicalInterface();
        System.out.print("Enter the product code (1-9): ");
        int productCode = scanner.nextInt();

        // Validate the product code
        if (productCode >= 1 && productCode <= 9) {
            int row = (productCode - 1) / COLS;  // Calculate row from the code
            int col = (productCode - 1) % COLS;  // Calculate column from the code

            Product product = products[row][col];
            System.out.println("You selected: " + product.getName() + " for $" + product.getPrice());
            System.out.println("Choose payment method: 1. Cash 2. Credit Card 3. Mobile Payment");
            int paymentChoice = scanner.nextInt();
            String paymentMethod = getPaymentMethod(paymentChoice);
            System.out.println("Paid using: " + paymentMethod);
            totalSales += product.getPrice();
        } else {
            System.out.println("Invalid product code.");
        }
    }


    private String getPaymentMethod(int choice) {
        switch (choice) {
            case 1:
                return "Cash / Coins";
            case 2:
                return "Credit Card";
            case 3:
                return "Mobile Payment";
            default:
                return "Unknown";
        }
    }

    private void restockMachine(Scanner scanner) {
        System.out.print("Enter row (0-2): ");
        int row = scanner.nextInt();
        System.out.print("Enter col (0-2): ");
        int col = scanner.nextInt();
        System.out.print("Enter new product name: ");
        String name = scanner.next();
        System.out.print("Enter new product price: ");
        double price = scanner.nextDouble();

        if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
            products[row][col] = new Product(name, price);
            System.out.println("Product restocked.");
        } else {
            System.out.println("Invalid position.");
        }
    }

    private void displayProducts() {
        displayGraphicalInterface();
    }

    private void displayGraphicalInterface() {
        System.out.println("\nVending Machine Layout:");
        // Print header row
        System.out.printf("%-5s %-20s %-10s %-10s %-10s\n", "Code", "Item", "Price", "Code", "Price");

        int code = 1; // Start product codes from 1
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                Product product = products[i][j];
                // Display the code, item name, and price
                System.out.printf("[ %-4d %-15s $%-8.2f ] ", code, product.getName(), product.getPrice());
                code++;
            }
            System.out.println(); // New line after each row
        }
    }


    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        vm.displayMenu();
    }
}