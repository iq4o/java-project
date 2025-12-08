import java.util.Scanner; 
 
public class DigitalRentalSystem { 
    private static DigitalItem[] items = new DigitalItem[4]; 
 
    public static enum RentStatus { 
        AVAILABLE, RENTED, ALL 
    } 
 
    public static void main(String[] args) { 
        preloadItems(); 
        Scanner input = new Scanner(System.in); 
        System.out.println("Welcome to Digital Rental Store"); 
 
        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. View All Items");
            System.out.println("2. View Available Items");
            System.out.println("3. View Rented Items");
            System.out.println("4. Rent an Item");
            System.out.println("5. Return an Item");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
 
            try {
                String choice = input.nextLine().trim();
                if (!choice.matches("\\d+")) {
                    System.out.println("!!! Numbers only !!!"); 
                    continue;             
                }
                int choiceNum = Integer.parseInt(choice);
                
                switch (choiceNum) {
                    case 1: 
                        displayItems(RentStatus.ALL);
                        break;
                    case 2:
                        displayItems(RentStatus.AVAILABLE);
                        break;
                    case 3:
                        displayItems(RentStatus.RENTED);
                        break;
                    case 4:
                        System.out.print("Enter the title of the item to rent: ");
                        String rentTitle = input.nextLine().trim();
                        boolean rented = false;
                        for (DigitalItem item : items) {
                            if (item != null && item.getTitle().equalsIgnoreCase(rentTitle)) {
                                if (!item.isRented()) {
                                    item.rentItem();
                                    System.out.println("You have rented: " + item.getTitle());
                                    rented = true;
                                } else {
                                    System.out.println("Item is already rented.");
                                }
                                break;
                            }
                        }
                        if (!rented) {
                            System.out.println("Item not found.");
                        }
                        break;
                    case 5:
                        System.out.print("Enter the title of the item to return: ");
                        String returnTitle = input.nextLine().trim();
                        boolean returned = false;
                        for (DigitalItem item : items) {
                            if (item != null && item.getTitle().equalsIgnoreCase(returnTitle)) {
                                if (item.isRented()) {
                                    item.returnItem();
                                    System.out.println("You have returned: " + item.getTitle());
                                    returned = true;
                                } else {
                                    System.out.println("Item was not rented.");
                                }
                                break;
                            }
                        }
                        if (!returned) {
                            System.out.println("Item not found.");
                        }
                        break;
                    case 6:
                        running = false;
                        System.out.println("Thank you for using Digital Rental Store!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("!!! Invalid input, please try again !!!");
            }
        }
        input.close();
    }
 
    private static void displayItems(RentStatus status) {
        System.out.println("\n--- Items ---");
        for (DigitalItem item : items) {
            if (item != null) {
                if (status == RentStatus.ALL || 
                    (status == RentStatus.AVAILABLE && !item.isRented()) ||
                    (status == RentStatus.RENTED && item.isRented())) {
                    System.out.println(item);
                }
            }
        }
    }
 
    private static void preloadItems() { 
        items[0] = new EBook("Java Basics", 5.0); 
        items[1] = new Movie("Inception", 10.0); 
        items[2] = new EBook("Python Essentials", 6.0); 
        items[3] = new Movie("Interstellar", 12.0); 
        items[1].rentItem(); 
    }
}
