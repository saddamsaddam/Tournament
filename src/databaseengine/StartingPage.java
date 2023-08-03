package databaseengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartingPage extends JFrame {
    static String playernumber = "8";
    static String mod = "8";
    static StartingPage frame = new StartingPage();

    public StartingPage() {
        // Labels for ComboBoxes
        JLabel label1 = new JLabel("Number of Players:");
        JLabel label2 = new JLabel("Tournament Mode:");

        // First ComboBox
        String[] items1 = {"8", "12", "16", "Add New"};
        JComboBox<String> comboBox1 = new JComboBox<>(items1);

        // Custom renderer for comboBox1
        comboBox1.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                return component;
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = (String) comboBox1.getSelectedItem();
                if ("Add New".equals(selectedValue)) {
                    String newItem = JOptionPane.showInputDialog(null, "Enter Player Number:", "Add Player Number", JOptionPane.PLAIN_MESSAGE);
                    if (newItem != null && !newItem.trim().isEmpty()) {
                        comboBox1.insertItemAt(newItem, comboBox1.getItemCount() - 1);
                        comboBox1.setSelectedItem(newItem);
                        selectedValue = newItem;
                    } else {
                        return; // Do not print anything if the user cancels the "Add New" dialog.
                    }
                }
                System.out.println("Selected (ComboBox1): " + selectedValue);
                playernumber = selectedValue;
            }
        });

        // Second ComboBox
        String[] items2 = {"8", "12", "16"};
        JComboBox<String> comboBox2 = new JComboBox<>(items2);

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = (String) comboBox2.getSelectedItem();
                System.out.println("Selected (ComboBox2): " + selectedValue);
                mod = selectedValue;
            }
        });

        // Start Tournament Button
        JButton startButton = new JButton("Start Tournament");
        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your logic for starting the tournament here
                System.out.println("Tournament started! " + mod);
                PlayerNameInputFrame pf = new PlayerNameInputFrame(Integer.parseInt(playernumber), Integer.parseInt(mod));
                pf.setVisible(true);
                frame.dispose();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END; // Align labels to the right
        gbc.insets = new Insets(10, 10, 0, 10); // Add some padding
        panel.add(label1, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 0, 10); // Add some padding
        panel.add(label2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 0, 0); // Add some top margin
        panel.add(comboBox1, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0); // Add some top margin
        panel.add(comboBox2, gbc);

        // Create a separate panel for the Start Tournament button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(startButton);

        // Add the Start Tournament button panel to the main panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 0, 0); // Add some top margin
        panel.add(buttonPanel, gbc);

        add(panel, BorderLayout.CENTER);

        pack();
        setSize(800, 500); // Set the initial size of the frame to 800x500 pixels
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        new StartingPage();
    }
}
