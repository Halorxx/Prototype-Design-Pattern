💡 Variante 2: Factory-Methode

Hier definierst du eine Methode wie copy() oder clonePrototype(), die intern ein neues Objekt auf Basis des aktuellen erstellt.

class Car {
    private String model;
    private String color;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    // Factory-Methode für Kopie
    public Car copy() {
        return new Car(this.model, this.color);
    }

    @Override
    public String toString() {
        return "Car{" + "model='" + model + "', color='" + color + "'}";
    }
}

public class PrototypeDemo {
    public static void main(String[] args) {
        Car prototype = new Car("Tesla Model 3", "Blue");

        // Objektkopie über Factory-Methode
        Car copy = prototype.copy();

        System.out.println(prototype);
        System.out.println(copy);
    }
}

✅ Fazit

✔️ Ja, das Interface Prototype<T> repräsentiert das Prototype Design Pattern in moderner, idiomatischer Form.
Es ist konzeptionell identisch, nur technisch sauberer und typensicher umgesetzt als das alte Cloneable.

// 🔹 Vorteil:

// Gleiche Idee wie beim echten Prototype Pattern

// Der Client ruft nur prototype.copy() auf, ohne die Implementierung zu kennen

// Du kannst Unterklassen überschreiben lassen, um spezialisierte Kopien zu erzeugen

// 💡 Variante 3: Interface-basierte Lösung (modernes "Prototype-Interface")

// Wenn du mehrere Klassen mit Kopierlogik hast, kannst du dir ein eigenes Interface definieren: