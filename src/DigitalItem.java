public abstract class DigitalItem {
    private String title;
    private double price;
   private boolean rented; 

public DigitalItem(String title, double price) {
        this.title = title;
        this.price = price;
        this.rented = false;
    }

   public String getTitle() {

        return title; 
   }
    
    public double getPrice() {
          return price; 
    }
    public boolean isRented() {
          return rented;
    }

    public void setTitle(String title){

        this.title = title;

    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    } 
     public void rentItem (){ 

        if (!this.rented){

            this.rented = false;
            
        }

     } 

     public void returnItem (){ 

        if (this.rented){

            this.rented = true;
            
        }

     }

     public abstract double calculateRentalPrice();


    @Override 
    public String toString() {
        
    }
    
    @Override 
    public boolean equals(Object otherItem) {
        if (this == otherItem) {
            return true;
        }
        if (otherItem == null || getClass() != otherItem.getClass()) {
            return false;
        }
        
    }
        DigitalItem item = (DigitalItem) otherItem;
        return this.title.equalsIgnoreCase(item.title);
}
