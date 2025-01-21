import java.util.Scanner;

/**
 * Represents a vending machine with a menu-driven interface.
 */
public class VendingMachine {
    private static final int ROWS = 3;  // Number of rows in the vending machine
    private static final int COLS = 3;  // Number of columns in the vending machine
    private Product[][] products = new Product[ROWS][COLS];  // 2D array to store products
    private static double totalSales = 0;  // Static variable to track total sales
    private static final String WELCOME_MESSAGE = "Welcome to the Vending Machine!";  // Constant welcome message

    /**
     * Constructor to initialize the vending machine.
     */
    public VendingMachine() {
        initializeProducts();
    }

    /**
     * Initializes the vending machine with default products.
     */
    private void initializeProducts() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                products[i][j] = new Product("Item" + (i * COLS + j + 1), (i + 1) * 1.5);
            }
        }
    }

    /**
     * Displays the main menu to the user.
     */
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

    /**
     * Handles product purchase by the user.
     *
     * @param scanner Scanner object to read user input.
     */
    private void buyProduct(Scanner scanner) {
        System.out.print("Enter row (0-2): ");
        int row = scanner.nextInt();
        System.out.print("Enter col (0-2): ");
        int col = scanner.nextInt();

        if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
            Product product = products[row][col];
            System.out.println("You bought: " + product.getName() + " for $" + product.getPrice());
            totalSales += product.getPrice();
        } else {
            System.out.println("Invalid selection.");
        }
    }

    /**
     * Restocks a specific product in the vending machine.
     * @param scanner Scanner object to read user input.
     */
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

}