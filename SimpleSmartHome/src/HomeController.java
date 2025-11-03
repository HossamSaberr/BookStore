package simplesmarthome;

import java.util.ArrayList;
import java.util.List;

public class HomeController {
    private final List<Device> devices = new ArrayList<>();

    public HomeController() { }

    public void addDevice(Device d) {
        devices.add(d);
        System.out.println("Added: " + d.getStatus());
    }

    private Device findById(String id) {
        for (Device d : devices) {
            if (d.id.equals(id)) return d;
        }
        return null;
    }

    public void turnOn(String id) {
        Device d = findById(id);
        if (d == null) {
            System.out.println("No device with id " + id);
            return;
        }
        d.turnOn();
    }

    public void turnOff(String id) {
        Device d = findById(id);
        if (d == null) {
            System.out.println("No device with id " + id);
            return;
        }
        d.turnOff();
    }

    public void adjust(String id, double value) {
        Device d = findById(id);
        if (d == null) {
            System.out.println("No device with id " + id);
            return;
        }
        if (d instanceof Adjustable) {
            Adjustable a = (Adjustable) d;
            a.adjust(value);
        } else {
            System.out.println(d.name + " does not support adjustment.");
        }
    }

    public void startRecording(String id) {
        Device d = findById(id);
        if (d == null) {
            System.out.println("No device with id " + id);
            return;
        }
        if (d instanceof Recordable) {
            Recordable r = (Recordable) d;
            r.startRecording();
        } else {
            System.out.println(d.name + " cannot record.");
        }
    }

    public void stopRecording(String id) {
        Device d = findById(id);
        if (d == null) {
            System.out.println("No device with id " + id);
            return;
        }
        if (d instanceof Recordable) {
            Recordable r = (Recordable) d;
            r.stopRecording();
        } else {
            System.out.println(d.name + " cannot record.");
        }
    }

    public String listAllStatuses() {
        StringBuilder sb = new StringBuilder();
        for (Device d : devices) {
            sb.append(d.getStatus()).append("\n");
        }
        return sb.toString();
    }
}
