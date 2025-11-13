| Variante                   | Beschreibung           | Vorteil                      |
| -------------------------- | ---------------------- | ---------------------------- |
| `Cloneable`                | alte Java-Methode      | unflexibel, fehleranfällig   |
| Copy-Konstruktor           | explizit & sicher      | einfache Kontrolle           |
| Factory-Methode (`copy()`) | elegant & erweiterbar  | echtes "Prototype-Pattern"   |
| Interface `Prototype<T>`   | generisch & skalierbar | sauberes Design, erweiterbar |


🔹 6. Deep Copy vs. Shallow Copy

Wenn dein Objekt Referenzen auf andere Objekte enthält, musst du diese manuell klonen, um eine tiefe Kopie zu erstellen.

Beispiel:

public class Engine implements Cloneable {
    private String type;

    public Engine(String type) { this.type = type; }
    public void setType(String type) { this.type = type; }

    @Override
    protected Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

public class Car implements Cloneable {
    private String brand;
    private Engine engine;

    public Car(String brand, Engine engine) {
        this.brand = brand;
        this.engine = engine;
    }

    @Override
    protected Car clone() {
        try {
            Car cloned = (Car) super.clone();
            cloned.engine = engine.clone(); // Deep Copy
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

🔹 7. Vorteile

✅ Objekterstellung ist schneller (kein neuer Konstruktor-Aufruf)
✅ Geringe Kopplung zwischen Klassen
✅ Gut für komplexe Objektstrukturen

🔹 8. Nachteile

❌ Cloneable-Mechanismus in Java ist etwas unübersichtlich
❌ Deep Copies müssen manuell implementiert werden
❌ Nicht threadsicher, wenn viele Klone gleichzeitig erstellt werden