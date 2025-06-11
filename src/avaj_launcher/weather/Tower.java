package avaj_launcher.weather;
import java.util.ArrayList;
import java.util.List;

import avaj_launcher.aircraft.Flyable;

public class Tower
{
    private List<Flyable> observers = new ArrayList<>(); // new ArrayList<Flyable>(); yapmayınca observers.add(p_flyable); bu satır exception fırlatıyor. Hata türü: java.lang.NullPointerException,  Error: null

    public void register(Flyable p_flyable) {
        if (p_flyable == null)
            throw new IllegalArgumentException("Flyable cannot be null.");
        observers.add(p_flyable);
        // System.out.println("Tower says: " + p_flyable.toString() + " registered to weather tower.");
        for(Flyable car : observers)
        {
            System.out.println("Registered Flyable: " + car.getClass().getSimpleName() + " - " + car.toString());
            System.out.println(observers.size());
        }
    }
    public void unregister(Flyable p_flyable) {
        if (p_flyable == null) {
            throw new IllegalArgumentException("Flyable cannot be null.");
        }
        observers.remove(p_flyable);
    }
    // conditionChanged()
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

