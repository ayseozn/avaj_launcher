package avaj_launcher.aircraft;
import avaj_launcher.weather.Coordinates;
import avaj_launcher.exceptions.OutputWrite;

public class Baloon extends Aircraft{
    
    public Baloon(long p_id, String p_name, Coordinates p_coordinate)
    {
        super(p_id, p_name, p_coordinate);
    }
    public void updateConditions()
    {
        switch(weatherTower.getWeather(coordinates))
        {
            case "SUN":
                coordinates.setLongitude(coordinates.getLongitude() + 2);
                coordinates.setHeight(coordinates.getHeight() + 4);
                OutputWrite.write("Baloon#" + name + "(" + id + "): It's sunny, let's go higher!");
                break;
            case "RAIN":
                coordinates.setHeight(coordinates.getHeight() - 5);
                OutputWrite.write("Baloon#" + name + "(" + id + "): It's raining, we need to go down!");
                break;
            case "FOG":
                coordinates.setHeight(coordinates.getHeight() - 3);
                OutputWrite.write("Baloon#" + name + "(" + id + "): It's foggy, we need to go down!");
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 15);
                OutputWrite.write("Baloon#" + name + "(" + id + "): It's snowing, we need to go down!");
                break;
        }
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
            OutputWrite.write("Baloon#" + name + "(" + id + ") has landed.");
        }
    }
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