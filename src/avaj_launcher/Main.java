package avaj_launcher;

import java.util.List;

import avaj_launcher.aircraft.Flyable;
import avaj_launcher.simulator.AircraftFactory;
import avaj_launcher.weather.Coordinates;
// import avaj_launcher.weather.Tower;
import avaj_launcher.weather.WeatherTower;
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
                // buradaki throw uygun mu bilmiyorum bak unutma
            }
            String simulationFile = args[0];
            
            List<String> lines = readFile(simulationFile);
            // if (lines.isEmpty())
            // {// exception fırlatılacak.
            // } içi boşsa sıfırıncı satır olmayacağı için lines.get(0) de exception fırlatacak sanki buna gerek yok
            
            int firtLine = Integer.parseInt(lines.get(0));
            // satır sayı değilse exception fırlatılacak.(IllegalArgumentException)
            // get(0) indexi yoksa exception fırlatılacak.(IndexOutOfBoundsException)(şimdilik özel catch açmadım genel olana gidiyo)
            if (firtLine < 0) // ilk satır negatif sayı ise exception fırlatılacak. çünkü simülasyonun tekrar sayısı
                throw new IllegalArgumentException("First line must be a positive integer.");
            
            
            WeatherTower weatherTower = new WeatherTower();
            OutputWrite.init("simulation.txt"); // çıktı dosyasını başlatma

            //for  Tüm satırları dolaşacak ilk satır ve boş satırları atlayacak satırları parslayacak type name ve kordinatlara göre yeni uçak oluşturacak bu uçağı kuleye kaydedecek ve bunu bilgidicek
            for(String line : lines) {
                if (line.isEmpty() || line == lines.get(0))
                {
                    continue; // boş satırları ve ilk satırı atla
                }
                
                String[] parts = line.split(" ");
                if (parts.length != 5) 
                    throw new IllegalArgumentException("Each line must contain at least three parts: type, name, and coordinates.");

                String type = parts[0];
                String name = parts[1];
                int longitude = Integer.parseInt(parts[2]);
                int latitude = Integer.parseInt(parts[3]);
                int height = Integer.parseInt(parts[4]);
                if (height < 0) // height negatif ise exception fırlatılacak
                {
                    System.out.println("yükseklik 0 atandığı için uçak atla");
                    continue;
                    // throw new IllegalArgumentException("Height cannot be negative.");
                }
                
                // AircraftFactory sınıfından yeni bir uçak oluşturma
                Flyable aircraft = AircraftFactory.getInstance().newAircraft(type, name, new Coordinates(longitude, latitude, height));
                if (aircraft == null){
                    // bilemedim ya gereksiz hissettirdi doğru exception türümü oda şaibeli
                    throw new IllegalArgumentException("Invalid aircraft type: " + type);
                }

                // uçağı hava kulesine kaydet ve kayıt mesajını atmak için
                aircraft.registerTower(weatherTower);
            }

            for(int i = 1; i <= firtLine; i++)
            {
                // ilk satırdaki sayıya göre döngü çalışacak işlemlerin kaç defa tekrarlayacağını belirleyecek
                // şahsen
                // hava durumu belirlenecek
                // hava durumuna göre uçaklar koordinat güncellemesi yapacak
                weatherTower.changeWeather();
            }
            // System.out.println(Runtime.getRuntime().freeMemory()); // JVM'nin boş bellek miktarını kontrol etme (isteğe bağlı)
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (Exception e) // lines.get(0) satırı bulamazsa
        {
            System.out.println("Error Type: " + e.getClass().getName());
            System.out.println("Error: " + e.getMessage());
            // System.out.println("Error:: " + e.getClass().getName() + " - " + e.getMessage());
        }
        finally {
            try {
                OutputWrite.close(); // çıktı dosyasını kapatma
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
                //System.out.println(line);
            }
        }
        return lines;
    }
}


// - = private
// + = public
// ~ = package
// # = protected