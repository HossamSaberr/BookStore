package simplesmarthome;

public class Light extends Device implements Adjustable {
    private double brightness;

    public Light(String id, String name) {
        super(id, name);
        this.brightness = 0;
    }

    public void adjust(double value) {
        if (value < 0 || value > 100) {
            System.out.println(name + ": brightness must be 0..100.");
            return;
        }
        brightness = value;
        System.out.println(name + ": brightness set to " + (int)brightness + "%.");
    }

    public double getSetting() { return brightness; }

    public String getStatus() {
        return name + " [Light] - power: " + (isOn ? "ON" : "OFF") + ", brightness: " + (int)brightness + "%";
    }
}
