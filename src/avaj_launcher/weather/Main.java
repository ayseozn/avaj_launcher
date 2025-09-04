package avaj_launcher.weather;

import java.util.List;

import avaj_launcher.aircraft.Flyable;
import avaj_launcher.simulator.AircraftFactory;
import avaj_launcher.exceptions.OutputWrite;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String args[])
    {
        try {
            if (args.length != 1) {
                System.out.println("Usage: java avaj_launcher.Main <simulation_file>");
                throw new IllegalArgumentException("Invalid number of arguments. Expected 1 argument.");
            }
            String simulationFile = args[0];
            
            List<String> lines = readFile(simulationFile);
            // if (lines.isEmpty())
            // {// exception fırlatılacak.
            // } içi boşsa sıfırıncı satır olmayacağı için lines.get(0) de exception fırlatacak sanki buna gerek yok
            
            int firstLine = Integer.parseInt(lines.get(0));
            if (firstLine < 0)
                throw new IllegalArgumentException("First line must be a positive integer.");
            
            WeatherTower weatherTower = new WeatherTower();
            OutputWrite.init("simulation.txt");

            for(String line : lines) {
                if (line.isEmpty() || line == lines.get(0))
                    continue;
                String[] parts = line.split(" ");
                if (parts.length != 5) 
                    throw new IllegalArgumentException("Each line must contain at least three parts: type, name, and coordinates.");

                String type = parts[0];
                String name = parts[1];
                int longitude = Integer.parseInt(parts[2]);
                int latitude = Integer.parseInt(parts[3]);
                int height = Integer.parseInt(parts[4]);
                if (height < 0)
                    continue;
                
                Flyable aircraft = AircraftFactory.getInstance().newAircraft(type, name, new Coordinates(longitude, latitude, height));

                aircraft.registerTower(weatherTower);
            }

            for(int i = 1; i <= firstLine; i++)
            {
                weatherTower.changeWeather();
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            try {
                OutputWrite.close();
            } catch (IOException e) {
                System.out.println("Error closing output file: " + e.getMessage());
            }
        }
    }

    public static List<String> readFile(String fileName) throws IOException
    {
        List<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
}