import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


  class Car{
      private String id;
      private String model;

      private String brand;

      private double baseprice;

      private boolean isavailable;

      public Car(String id,String model,String brand, double baseprice ,boolean isavailable) {
          this.id = id;
          this.model=model;
          this.brand=brand;
          this.baseprice=baseprice;
          this.isavailable=true;
      }
  }
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}