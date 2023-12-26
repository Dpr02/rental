import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem{
    private List<Car> cars;

    private List<Customer> customers;

    private List<Rental> rentals;

    public  CarRentalSystem(){
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();

    }

    public void addCar(Car car){
        cars.add(car);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void rentCar(Car car,Customer customer,int days){
        if (car.isavailable()){
            car.rent();
            rentals.add(new Rental(car, customer, days));
        } else{
            System.out.println("car is not available for rent");
        }

    }
    public void returnCar(Car car){
        car.returncar();
        Rental rentalToRemove = null;
        for (Rental rental: rentals){
            if(rental.getCar()==car){
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove!=null){
            rentals.remove(rentalToRemove);
            System.out.println("Car returned successfully.");
        }
        else{
            System.out.println("Car was not returned");
        }
    }
    public void menu(){
        Scanner scanner=new Scanner(System.in);

        while (true){
            System.out.println("======= Car Rental System ===== ");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return A Car");
            System.out.println("Exit");
            System.out.println("Enter Your Choice");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice==1){
                System.out.println("\n == Rent a Car==\n");
                System.out.println("Enter your Name: ");
                String customerName = scanner.nextLine();

                System.out.println("\n Available Cars:");
                for (Car car : cars){
                    if (car.isavailable()){
                        System.out.println(car.getId() + " "+ car.getBrand() +" " + car.getModel());

                    }
                }

                System.out.println("\n Enter the car ID you want to rent:");
                String ID = scanner.nextLine();

                System.out.println(" \n Enter the Number of Days you Want to Rent");
                int rentalDays = scanner.nextInt();
                scanner.nextLine();

                Customer newCustomer = new Customer("CUS" + (customers.size() + 1),customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for (Car car: cars){
                    if (car.getId().equals(ID)&& car.isavailable()){
                        selectedCar = car;
                        break;
                    }
                }
                if (selectedCar !=null){
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("== Rental Information==\n");
                    System.out.println("Customer ID:" + newCustomer.getCustomerid());
                    System.out.println("Customer Name:" + newCustomer.getName());
                    System.out.println("Car: " +selectedCar.getBrand()+" " + selectedCar.getModel());
                    System.out.println("Rental Days:" + rentalDays);
                    System.out.printf("Total Price: $%.2f%n", totalPrice);

                    System.out.print("\n Confirm Rental (Y/N):");
                    String confirm = scanner.nextLine();

                    if(confirm.equalsIgnoreCase("Y"));{
                        rentCar(selectedCar, newCustomer ,rentalDays);
                        System.out.println("\n Car rented Successfully.");

                    }

                    {
                        System.out.println("\n Rental Canceled");
                    }

                } else{
                    System.out.println("\n Invalid car selection or car not available for rent");

                }

            } else if (choice==2) {
                System.out.println("\n Return a car");
                System.out.println("Enter the CAr ID you want to rent:");
                String id= scanner.nextLine();

                Car carToReturn= null;
                for (Car car : cars){
                    if (car.getId().equals(id)&& !car.isavailable()){
                        carToReturn = car;
                        break;
                    }
                }

                if (carToReturn!=null){
                    returnCar(carToReturn);
                    Customer customer = null;
                    for (Rental rental: rentals){
                        if (rental.getCar() == carToReturn){
                            customer = rental.getCustomer();
                            break;
                        }
                    }

                    if (customer != null){
                        returnCar(carToReturn);
                        System.out.println("Car returned successfully" + customer.getName());
                    } else {
                        System.out.println("Car was not rented or rental information is missing.");
                    }
                } else{
                    System.out.println("Invalid car id or car is not rented.");

                }
            } else if (choice==3) {
                break;

            }else{
                System.out.println("Invalid choice. Please enter valid options.");
            }
        }
        System.out.println("\n Thank you for using Car Rental System");
    }
}

