package avaj_launcher.weather;


public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height)
    {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        setHeight(p_height);
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

    public void setHeight(int height) {
        if (height < 0) {
            this.height = 0; // Height cannot be negative
        }
        else if (height > 100) {
            this.height = 100; // Maximum height is 100
        } 
        else {
            this.height = height;
        }
    }
    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
    public void setLatitude(int latitude) {
        this.latitude = latitude;
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