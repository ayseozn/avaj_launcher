package avaj_launcher.aircraft;
import avaj_launcher.weather.Coordinates;


public abstract class Aircraft extends Flyable{
    
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate)
    {
        id = p_id;
        name = p_name;
        coordinates = p_coordinate;
    }

}



// class Aircraft
// {
// #long id
// #string name
// #Coordinate coordinates
// #Aircraft(long p_id, string p_name, Coordinates p_coordinate)
// }

// # = protected