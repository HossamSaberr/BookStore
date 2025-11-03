package simplesmarthome;

public class Thermostat extends Device implements Adjustable {
    private double temperature;

    public Thermostat(String id, String name) {
        super(id, name);
        this.temperature = 20.0;
    }

    public void adjust(double value) {
        if (value < 5 || value > 30) {
            System.out.println(name + ": temperature must be 5..30°C.");
            return;
        }
        temperature = value;
        System.out.println(name + ": temperature set to " + temperature + "°C.");
    }

    public double getSetting() { return temperature; }

    public String getStatus() {
        return name + " [Thermostat] - power: " + (isOn ? "ON" : "OFF") + ", temp: " + temperature + "°C";
    }
}
