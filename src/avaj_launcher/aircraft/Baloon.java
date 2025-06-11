package avaj_launcher.aircraft;
import avaj_launcher.weather.Coordinates;

public class Baloon extends Aircraft
{
    public Baloon(long p_id, String p_name, Coordinates p_coordinate)
    {
        super(p_id, p_name, p_coordinate);
    }
    public void updateConditions()
    {}
    public String toString() {
        return "Baloon#" + name + "(" + id + ")";
    }
}


// class Baloon
// {
// +Baloon(long p_id, string p_name, Coordinates p_coordinate)
// +void updateConditions()
// }

// aircraft dan miras alacak
// + = public

// ◦ GÜNEŞ - Boylam 2 ile artar, Yükseklik 4 ile artar
// ◦ YAĞMUR - Yükseklik 5 ile azalır
// ◦ FOG - Yükseklik 3 ile azalır
// ◦ KAR - Yükseklik 15 ile azalır