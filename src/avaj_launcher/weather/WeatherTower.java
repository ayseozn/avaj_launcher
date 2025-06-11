package avaj_launcher.weather;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates p_coordinates) 
    {
        // verilen koordinatlara göre hava durumunu döndürür
        return "SUN"; // Example weather condition
    }
    
    public void changeWeather() 
    {
        // sistemdeki hava durumunu değiştirir
    }
}


// class WeatherTower
// {
// +string getWeather(Coordinates p_coordinates)
// +void changeWeather()
// }

// WeatherTower, Tower'dan miras alacak
// +getWeather(Coordinates p_coordinates) metodu, koordinatlara göre hava durumunu döndürecek
// +changeWeather() metodu, hava durumunu değiştirecek ve tüm gözlemcileri bilgilendirecek

// + = public