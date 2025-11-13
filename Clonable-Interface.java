| Variante                   | Beschreibung           | Vorteil                      |
| -------------------------- | ---------------------- | ---------------------------- |
| `Cloneable`                | alte Java-Methode      | unflexibel, fehleranfällig   |
| Copy-Konstruktor           | explizit & sicher      | einfache Kontrolle           |
| Factory-Methode (`copy()`) | elegant & erweiterbar  | echtes "Prototype-Pattern"   |
| Interface `Prototype<T>`   | generisch & skalierbar | sauberes Design, erweiterbar |


public class Car implements Cloneable {
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

public class Main {
    public static void main(String[] args) {
        Car original = new Car("Tesla", "Rot");
        Car copy = original.clone();
        copy = new Car("Tesla", "Blau");

        System.out.println(original); // Rot Tesla
        System.out.println(copy);     // Blau Tesla
    }
}


Was passiert hier?
Wir erzeugen zuerst ein Auto – also unseren Prototypen.
Dann klonen wir ihn, um ein neues Auto zu bekommen.
Das neue Objekt ist eine exakte Kopie, aber völlig unabhängig vom Original.