public class EBook extends DigitalItem {
    
    public EBook(String title, double price) {
        super(title, price);
    }

    @Override
    public double calculateRentalPrice() {
        return getPrice() * 1.15; 
    }
    
    @Override 
    public String toString() {
        double finalPrice = calculateRentalPrice();
        String status = isRented() ? "Rented" : "Available";
        return String.format("[EBook] title: %-20s | rental price: %6.2f | status: %-10s", getTitle(), finalPrice, status);
    } 
}
