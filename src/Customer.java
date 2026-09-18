public class Customer {

    private String customerId;
    private String name;
    private String phoneNumber;

    public Customer(String customerId, String name, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void displayCustomer() {
        System.out.println("Customer ID : " + customerId);
        System.out.println("Name        : " + name);
        System.out.println("Phone       : " + phoneNumber);
    }
}