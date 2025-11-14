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

void main() {
    Car original = new Car("Tesla", "Rot");
    Car copy = original.clone();
    copy.color = "Blau";

    IO.println(original); // Rot Tesla
    IO.println(copy);     // Blau Tesla
}