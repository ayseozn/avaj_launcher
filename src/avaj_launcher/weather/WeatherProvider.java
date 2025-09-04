package avaj_launcher.weather;

public class WeatherProvider {
    private static WeatherProvider instance = null;
    private String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int index = (p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight()) % weather.length;
        return weather[index];
    }
}


// class WeatherProvider <<Singleton>>
// {
// -string[] weather
// -WeatherProvider()
// +string getCurrentWeather(Coordinates p_coordinates)
// }

// + = public
// - = private
// <<Singleton>> = Singleton Design Pattern
//
// Singleton Design Pattern: Ensures a class has only one instance and provides a global point of access to it.