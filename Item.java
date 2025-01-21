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
