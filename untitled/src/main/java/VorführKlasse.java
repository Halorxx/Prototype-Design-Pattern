

public class VorführKlasse {


    public static class Car implements Cloneable {
        private String brand;
        private String color;

        public Car(String brand, String color) {
            this.brand = brand;
            this.color = color;
        }

        @Override
        protected Car clone() {
            try {
                return (Car) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        @Override
        public String toString() {
            return color + " " + brand;
        }
    }

    public static void main(String[] args) {
        Car original = new Car("Tesla", "Rot");
        Car copy = original.clone();
        copy.color = "Blau";

        System.out.println(original); // Rot Tesla
        System.out.println(copy);     // Blau Tesla
    }
}