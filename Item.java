/**
 * Base class representing an item with a name and price.
 */
class Item {
    protected String name;
    protected double price;

    /**
     * Constructor to initialize item with name and price.
     * @param name The name of the item.
     * @param price The price of the item.
     */
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Get the name of the item.
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the price of the item.
     * @return The price of the item.
     */
    public double getPrice() {
        return price;
    }
}

/**
 * Derived class from Item to represent products in the vending machine.
 */
class Product extends Item {
    /**
     * Constructor to create a product with name and price.
     * @param name The name of the product.
     * @param price The price of the product.
     */
    public Product(String name, double price) {
        super(name, price);
    }
}
