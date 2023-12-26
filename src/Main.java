
public class Main {
    public static void main(String[]args){



        Car car1= new Car("A01","M5","BMW",120);
        CarRentalSystem rentalSystem = new CarRentalSystem();

        rentalSystem.addCar(car1);

        rentalSystem.menu();
    }
}







