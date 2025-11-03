package simplesmarthome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Simple Swing GUI to control devices.
 * Run this class (it has main).
 */
public class MainGui {
    private final HomeController controller = new HomeController();
    private final DefaultComboBoxModel<String> deviceModel = new DefaultComboBoxModel<>();
    private final JTextArea outputArea = new JTextArea(10, 40);

    public MainGui() {
        // create demo devices and register them
        controller.addDevice(new Light("L1", "Living Room Light"));
        controller.addDevice(new Thermostat("T1", "Bedroom Thermostat"));
        controller.addDevice(new Camera("C1", "Front Door Camera"));

        // populate device selector
        deviceModel.addElement("L1");
        deviceModel.addElement("T1");
        deviceModel.addElement("C1");
    }

    private void showGui() {
        JFrame frame = new JFrame("Simple Smart Home - GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JComboBox<String> deviceSelector = new JComboBox<>(deviceModel);
        top.add(new JLabel("Device ID:"));
        top.add(deviceSelector);

        JButton onBtn = new JButton("Turn ON");
        JButton offBtn = new JButton("Turn OFF");
        JButton adjustBtn = new JButton("Adjust");
        JButton startRec = new JButton("Start Rec");
        JButton stopRec = new JButton("Stop Rec");
        JButton listBtn = new JButton("List Devices");

        JTextField adjustField = new JTextField(6);
        adjustField.setToolTipText("Enter number (brightness or temperature)");

        top.add(onBtn);
        top.add(offBtn);
        top.add(new JLabel("Value:"));
        top.add(adjustField);
        top.add(adjustBtn);
        top.add(startRec);
        top.add(stopRec);
        top.add(listBtn);

        outputArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(outputArea);

        frame.getContentPane().add(top, BorderLayout.NORTH);
        frame.getContentPane().add(scroll, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Actions
        onBtn.addActionListener(e -> {
            String id = (String) deviceSelector.getSelectedItem();
            controller.turnOn(id);
            appendOutput(controller, id);
        });

        offBtn.addActionListener(e -> {
            String id = (String) deviceSelector.getSelectedItem();
            controller.turnOff(id);
            appendOutput(controller, id);
        });

        adjustBtn.addActionListener(e -> {
            String id = (String) deviceSelector.getSelectedItem();
            String txt = adjustField.getText().trim();
            if (txt.isEmpty()) {
                appendLine("Enter a numeric value to adjust.");
                return;
            }
            try {
                double val = Double.parseDouble(txt);
                controller.adjust(id, val);
            } catch (NumberFormatException ex) {
                appendLine("Invalid number: " + txt);
            }
            appendOutput(controller, id);
        });

        startRec.addActionListener(e -> {
            String id = (String) deviceSelector.getSelectedItem();
            controller.startRecording(id);
            appendOutput(controller, id);
        });

        stopRec.addActionListener(e -> {
            String id = (String) deviceSelector.getSelectedItem();
            controller.stopRecording(id);
            appendOutput(controller, id);
        });

        listBtn.addActionListener(e -> appendLine(controller.listAllStatuses()));
    }

    private void appendOutput(HomeController c, String id) {
        // show status of the selected device
        appendLine("----");
        appendLine(c.listAllStatuses());
    }

    private void appendLine(String s) {
        outputArea.append(s + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGui gui = new MainGui();
            gui.showGui();
        });
    }
}
