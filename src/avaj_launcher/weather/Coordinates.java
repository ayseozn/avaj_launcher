package avaj_launcher.weather;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height)
    {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }
    public int getLongitude()
    {
        return longitude;
    }
    public int getLatitude()
    {
        return latitude;
    }
    public int getHeight()
    {
        return height;
    }
}


// class Coordinates
// {
// -int longitude
// -int latitute
// -int height
// ~Coordinates(int p_longitude, int p_latitude, int p_height)
// +int getLongitude()
// +int getLatitude()
// +int getHeight()
// }

// + = public
// - = private
// ~ = package-private erişim belirteci olmaması