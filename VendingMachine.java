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