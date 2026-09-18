public class RegularCustomer extends Customer {

    private int loyaltyPoints;

    public RegularCustomer(String customerId, String name, String phoneNumber, int loyaltyPoints) {
        super(customerId, name, phoneNumber);
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addLoyaltyPoints(int points) {
        loyaltyPoints += points;
    }

    @Override
    public void displayCustomer() {
        System.out.println("Customer Type: Regular Customer");
        System.out.println("Customer ID  : " + getCustomerId());
        System.out.println("Name         : " + getName());
        System.out.println("Phone        : " + getPhoneNumber());
        System.out.println("Loyalty Points: " + loyaltyPoints);
    }
}