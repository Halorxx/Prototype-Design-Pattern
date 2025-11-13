// 1️⃣ Prototype Interface
interface Prototype extends Cloneable {
    Prototype clone();
}

// 2️⃣ Concrete Prototype
class Car implements Prototype {
    private String model;
    private String color;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone(); // shallow copy
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Car{" + "model='" + model + '\'' + ", color='" + color + '\'' + '}';
    }
}


// 3️⃣ Client Code
public class Prototype-Interface {
    public static void main(String[] args) {
        Car original = new Car("Tesla Model S", "Red");
        Car copy = original.clone();

        System.out.println(original); // Car{model='Tesla Model S', color='Red'}
        System.out.println(copy);     // Car{model='Tesla Model S', color='Red'}
    }
}

⚖️ Vergleich mit dem klassischen Pattern
| Aspekt           | Klassisch (GoF 1994)         | Modern in Java                      |
| ---------------- | ---------------------------- | ----------------------------------- |
| Interface        | `clone()` aus `Cloneable`    | eigenes `Prototype<T>` mit `copy()` |
| Fehlerbehandlung | `CloneNotSupportedException` | keine                               |
| Kopierart        | meist shallow                | du entscheidest selbst              |
| Erweiterbarkeit  | begrenzt                     | stark erweiterbar                   |
| Lesbarkeit       | kryptisch (`super.clone()`)  | klar (`new Car(this)`)              |

✅ Fazit
✔️ Ja, das Interface Prototype<T> repräsentiert das Prototype Design Pattern in moderner, idiomatischer Form.
Es ist konzeptionell identisch, nur technisch sauberer und typensicher umgesetzt als das alte Cloneable.
// 🔹 Vorteil
// Gleiche Idee wie beim echten Prototype Pattern
// Der Client ruft nur prototype.copy() auf, ohne die Implementierung zu kennen
// Du kannst Unterklassen überschreiben lassen, um spezialisierte Kopien zu erzeugen
// 💡 Variante 3: Interface-basierte Lösung (modernes "Prototype-Interface"
// Wenn du mehrere Klassen mit Kopierlogik hast, kannst du dir ein eigenes Interface definieren:
interface Prototype<T> {
    T copy();
}
class Car implements Prototype<Car> {
    private String model;
    private String color;
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
public class PrototypeDemo {
    public static void main(String[] args) {
        Car original = new Car("Tesla Model 3", "Blue");
        Car copy = original.copy();
        System.out.println(original); // Car{model='Tesla Model 3', color='Blue'}
        System.out.println(copy);     // Car{model='Tesla Model 3', color='Blue'}
    }
}
| Variante                   | Beschreibung           | Vorteil                      |
| -------------------------- | ---------------------- | ---------------------------- |
| `Cloneable`                | alte Java-Methode      | unflexibel, fehleranfällig   |
| Copy-Konstruktor           | explizit & sicher      | einfache Kontrolle           |
| Factory-Methode (`copy()`) | elegant & erweiterbar  | echtes "Prototype-Pattern"   |
| Interface `Prototype<T>`   | generisch & skalierbar | sauberes Design, erweiterbar |

