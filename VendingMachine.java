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

}
