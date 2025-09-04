package avaj_launcher.weather;
// import java.io.IOError;
// import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import avaj_launcher.aircraft.Flyable;
import avaj_launcher.exceptions.OutputWrite;

public class Tower
{
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable)
    {
        if (p_flyable == null)
            throw new IllegalArgumentException("Flyable cannot be null.");
        observers.add(p_flyable);
        OutputWrite.write("Tower says: " + p_flyable.toString() + " registered to weather tower.");
    }
    public void unregister(Flyable p_flyable) {
        if (p_flyable == null) {
            throw new IllegalArgumentException("Flyable cannot be null.");
        }
        observers.remove(p_flyable);
        OutputWrite.write("Tower says: " + p_flyable.toString() + " unregistered from weather tower.");
    }
    protected void conditionChanged() {

        List<Flyable> observersCopy = new ArrayList<>(observers);
        for (Flyable flyable : observersCopy) {
            flyable.updateConditions();
        }
    }
}


// class Tower
// {
// - List<Flyable*> observers
// +void register(Flyable* p_flyable)
// +void unregister(Flyable* p_flyable)
// #void conditionChanged()
// }

// + = public
// - = private
// # = protected
// <<Observer>> = Observer Design Pattern

// Observer tasarım deseni, birden fazla nesneyi, takip ettikleri başka bir nesnede gerçekleşen olaylarla 
// ilgili bilgilendirmeyi sağlayan bir abonelik mekanizması oluşturmayı amaçlar.
