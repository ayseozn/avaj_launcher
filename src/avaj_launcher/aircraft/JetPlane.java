package avaj_launcher.aircraft;
import avaj_launcher.weather.Coordinates;

public class JetPlane extends Aircraft {

    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }
    public void updateConditions() {
        // Update the jet plane's conditions based on the weather
        // Implement the logic for updating conditions based on weather
        // For example, increase latitude by 10 in SUN, increase height by 2 in SNOW, etc.
        System.out.println("JetPlane " + name + " is updating conditions based on weather.");
    }
    public String toString() {
        return "JetPlane#" + name + "(" + id + ")";
    }
}


// class JetPlane
// {
// +JetPlane(long p_id, string p_name, Coordinates p_coordinate)
// +void updateConditions()
// }

// aircraft dan miras alacak
// + = public

// ◦ GÜNEŞ - Enlem 10 ile artar, Yükseklik 2 ile artar
// ◦ YAĞMUR - Enlem 5 ile artar
// ◦ FOG - Enlem 1 ile artar
// ◦ KAR - Yükseklik 7 ile azalır