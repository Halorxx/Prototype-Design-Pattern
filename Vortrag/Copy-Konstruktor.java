💡 Variante 1: Copy-Konstruktor

Hier nutzt du einfach einen Konstruktor, der ein anderes Objekt derselben Klasse übernimmt und dessen Werte kopiert.

class Car {
    private String model;
    private String color;

    // normaler Konstruktor
    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    // Copy-Konstruktor (Kopie vom Prototyp)
    public Car(Car prototype) {
        this.model = prototype.model;
        this.color = prototype.color;
    }

    @Override
    public String toString() {
        return "Car{" + "model='" + model + "', color='" + color + "'}";
    }
}

public class PrototypeDemo {
    public static void main(String[] args) {
        Car original = new Car("Tesla Model S", "Red");
        Car copy = new Car(original); // statt clone()

        System.out.println(original);
        System.out.println(copy);
    }
}


🔹 Vorteil:

Keine Ausnahmebehandlung (CloneNotSupportedException)

Voll kontrollierbar: du entscheidest, ob du deep oder shallow copy willst

Sauber, klar, und idiomatisch für modernes Java

🔹 Nachteil:
Etwas mehr Boilerplate-Code (Konstruktor muss definiert werden)

| Variante                   | Beschreibung           | Vorteil                      |
| -------------------------- | ---------------------- | ---------------------------- |
| `Cloneable`                | alte Java-Methode      | unflexibel, fehleranfällig   |
| Copy-Konstruktor           | explizit & sicher      | einfache Kontrolle           |
| Factory-Methode (`copy()`) | elegant & erweiterbar  | echtes "Prototype-Pattern"   |
| Interface `Prototype<T>`   | generisch & skalierbar | sauberes Design, erweiterbar |

