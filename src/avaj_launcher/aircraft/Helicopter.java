package avaj_launcher.aircraft;

import avaj_launcher.weather.Coordinates;
import avaj_launcher.exceptions.OutputWrite;

public class Helicopter extends Aircraft {
    // Helicopter sınıfı Aircraft sınıfından miras alır
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate){
        super(p_id, p_name, p_coordinate);
    }
    public void updateConditions() 
    {
        switch (weatherTower.getWeather(coordinates)) {
            case "SUN":
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                OutputWrite.write("Helicopter#" + name + "(" + id + "): It's sunny, let's fly higher!");
                break;
            case "RAIN":
                coordinates.setLongitude(coordinates.getLongitude() + 5);
                OutputWrite.write("Helicopter#" + name + "(" + id + "): It's raining, we need to be careful!");
                break;
            case "FOG":
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                OutputWrite.write("Helicopter#" + name + "(" + id + "): It's foggy, we need to be cautious!");
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 12);
                OutputWrite.write("Helicopter#" + name + "(" + id + "): It's snowing, we need to go down!");
                break;
        }
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
            OutputWrite.write("Helicopter#" + name + "(" + id + ") has landed.");
        }
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