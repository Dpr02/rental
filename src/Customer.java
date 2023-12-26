public class Customer{
    private String customerid;
    private String name;

    public Customer(String customerid, String name) {
        this.customerid = customerid;
        this.name = name;
    }

    public String getCustomerid() {
        return customerid;
    }

    public String getName() {
        return name;
    }
}
