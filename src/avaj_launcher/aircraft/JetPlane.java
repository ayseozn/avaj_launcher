package avaj_launcher.aircraft;
import avaj_launcher.weather.Coordinates;
import avaj_launcher.exceptions.OutputWrite;

public class JetPlane extends Aircraft {

    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }
    public void updateConditions() {
        switch(weatherTower.getWeather(coordinates)) {
            case "SUN":
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                OutputWrite.write("JetPlane#" + name + "(" + id + "): It's sunny, let's fly high!");
                break;
            case "RAIN":
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                OutputWrite.write("JetPlane#" + name + "(" + id + "): It's raining, we need to be careful!");
                break;
            case "FOG":
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                OutputWrite.write("JetPlane#" + name + "(" + id + "): It's foggy, we need to be cautious!");
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 7);
                OutputWrite.write("JetPlane#" + name + "(" + id + "): It's snowing, we need to go down!");
                break;
        }
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
            OutputWrite.write("JetPlane#" + name + "(" + id + ") has landed.");
        }
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