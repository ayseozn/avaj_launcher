package avaj_launcher.aircraft;
import avaj_launcher.weather.WeatherTower;

public abstract class Flyable
{
    protected WeatherTower weatherTower;

    public abstract void updateConditions();

    public void registerTower(WeatherTower p_tower){
        weatherTower = p_tower;
        p_tower.register(this);
    }
}


// abstract Flyable
// {
// #WeatherTower weatherTower
// +abstract void updateConditions()
// +registerTower(WeatherTower* p_tower)
// }

// + = public
// # = protected