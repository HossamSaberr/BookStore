package simplesmarthome;

public class Camera extends Device implements Recordable {
    private boolean recording;

    public Camera(String id, String name) {
        super(id, name);
        recording = false;
    }

    public void startRecording() {
        if (!isOn) {
            System.out.println(name + ": turn the camera ON before recording.");
            return;
        }
        if (!recording) {
            recording = true;
            System.out.println(name + " started recording.");
        } else {
            System.out.println(name + " is already recording.");
        }
    }

    public void stopRecording() {
        if (recording) {
            recording = false;
            System.out.println(name + " stopped recording.");
        } else {
            System.out.println(name + " was not recording.");
        }
    }

    public boolean isRecording() { return recording; }

    public String getStatus() {
        return name + " [Camera] - power: " + (isOn ? "ON" : "OFF") + ", recording: " + (recording ? "YES" : "NO");
    }
}
