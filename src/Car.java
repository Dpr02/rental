public class Car {
    private String id;
    private String model;

    private String brand;

    private double baseprice;

    private boolean isavailable;

    public Car(String id, String model, String brand, double baseprice) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.baseprice = baseprice;
        this.isavailable = true;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public double calculatePrice(int rentalDays) {
        return baseprice * rentalDays;
    }

    public boolean isavailable() {
        return isavailable;
    }

    public void rent() {
        isavailable = false;
    }

    public void returncar() {
        isavailable = true;
    }
}