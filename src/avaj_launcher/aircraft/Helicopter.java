package avaj_launcher.aircraft;

import avaj_launcher.weather.Coordinates;

public class Helicopter extends Aircraft {
    // Helicopter sınıfı Aircraft sınıfından miras alır
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate){
        super(p_id, p_name, p_coordinate);
    }
    public void updateConditions() {
        // Update the helicopter's conditions based on the weather
        // Implement the logic for updating conditions based on weather
        // For example, increase longitude by 10 in SUN, decrease height by 12 in SNOW, etc.
    }
    public String toString()
    {
        return "Helicopter#" + name + "(" + id + ")";
    }
}


// class Helicopter
// {
// +Helicopter(long p_id, string p_name, Coordinates p_coordinate)
// +void updateConditions()
// }

// aircraft dan miras alacak
// + = public

// ◦ GÜNEŞ - Boylam 10 ile artar, Yükseklik 2 ile artar
// ◦ YAĞMUR - Boylam 5 ile artar
// ◦ FOG - Boylam 1 ile artar
// ◦ KAR - Yükseklik 12 ile azalır