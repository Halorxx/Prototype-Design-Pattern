public class PrototypeInterfaceVorführklasse {
    public interface Prototype<T> {
        T copy();
    }

    public class Car implements Prototype<Car> {
        protected String model;
        protected String color;

        public Car(String model, String color) {
            this.model = model;
            this.color = color;
        }

        @Override
        public Car copy() {
            return new Car(this.model, this.color);
        }

        @Override
        public String toString() {
            return "Car{" + "model='" + model + '\'' + ", color='" + color + '\'' + '}';
        }
    }

    public class SuperCar extends Car implements Prototype<SuperCar> {
        private int tempo;

        public SuperCar(String model, String color, int tempo) {
            super(model, color);
            this.tempo = tempo;
        }

        @Override
        public SuperCar copy() {
            return new SuperCar(this.model, this.color, this.tempo);
        }

        @Override
        public String toString() {
            return "Car{" + "model='" + model + '\'' + ", color='" + color + '\'' + ", tempo='" + tempo + '\'' + '}';
        }
    }

    public class PrototypeDemo {
        public static void main(String[] args) {
            Car original = new Car("Tesla Model 3", "Blue");
            Car copy = original.copy();
            System.out.println(original); // Car{model='Tesla Model 3', color='Blue'}
            System.out.println(copy);     // Car{model='Tesla Model 3', color='Blue'}

            SuperCar originalSupercar = new SuperCar("Tesla Roadster", "Rot", 300);
            SuperCar copySupercar = originalSupercar.copy();
            System.out.println(copySupercar);
        }
    }
}