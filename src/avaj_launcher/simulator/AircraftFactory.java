package avaj_launcher.simulator;
import avaj_launcher.aircraft.Baloon;
import avaj_launcher.aircraft.Flyable;
import avaj_launcher.aircraft.Helicopter;
import avaj_launcher.aircraft.JetPlane;
import avaj_launcher.weather.Coordinates;

public class AircraftFactory {
    private static AircraftFactory instance = null;
    private static long p_id = 0;

    private AircraftFactory() {
    }

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }
    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws IllegalArgumentException
    {
        Flyable aircraft = null;
        
        p_id++;
        switch (p_type.toLowerCase())
        {
            case "baloon":
                aircraft = new Baloon(p_id ,p_name, p_coordinates);
                break;
            case "helicopter":
                aircraft = new Helicopter(p_id, p_name, p_coordinates);
                break;
            case "jetplane":
                aircraft = new JetPlane(p_id, p_name, p_coordinates);
                break;
            default:
                throw new IllegalArgumentException("Unknown aircraft type: " + p_type);
        }
        return aircraft;
    }
}


// class AircraftFactory <<Singleton>>
// {
// +Flyable* newAircraft(string p_type, string p_name, Coordinates p_coordinates)
// }

// + = public
// <<Singleton>> = Singleton Design Pattern

// JetPlane -[hidden]- AircraftFactory


// Bir class’ın singleton tasarım örüntüsüne uygun olması için temelde üç adım vardır;

// Constructor private olmalı. Bu yapılan işlem new ile nesne oluşturulmasını engeller.
// Class ile aynı türde static bir member oluşturulur.
// Örneğin;
// class SingletonExample {
// private static SingletonExample instance;
// }
// Static member’a ulaşmak için static bir metot oluşturulmalıdır.
// Örneğin;
// public static Singleton getInstance() { … return instance; }

// Factory Method Design Pattern
// Kelime anlamı “Fabrika Metodu” olan Factory Method, üst sınıfta nesneler oluşturmak için bir arabirim sağlayan, 
// ancak alt sınıfların oluşturulacak bu nesne türünü değiştirmesine izin veren bir yaratımsal desen (creational pattern) türüdür.