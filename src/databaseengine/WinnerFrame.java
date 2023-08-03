package databaseengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;

public class WinnerFrame extends JFrame {

    public WinnerFrame(String name, int number, int score) {
        // Set JFrame properties
        setTitle("Winner Frame");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the first panel with four text labels vertically
        JPanel firstPanel = new JPanel();
        firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.Y_AXIS));

        JLabel label2 = new JLabel("Driver Number: "+number);
        JLabel label3 = new JLabel("Driver Name: "+name);
        JLabel label4 = new JLabel("Score: "+score);
        // Add empty border with top padding (10 pixels) to each label
        label2.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        label3.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        label4.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        // Center-align the text in the labels
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setHorizontalAlignment(SwingConstants.CENTER);

        firstPanel.add(label2);
        firstPanel.add(label3);
        firstPanel.add(label4);

        // Create the second panel with two text labels horizontally
        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new FlowLayout());

        JButton label5 = new JButton("Home");
        JButton label6 = new JButton("Close");

        secondPanel.add(label5);
        secondPanel.add(label6);
        
        label5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartingPage StartingPage=new StartingPage();
                StartingPage.setVisible(true);
                dispose();
                // Add your code here for handling the "Back" button action
                // For example, you can go back to the previous frame or state.
            }
        });
        label6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0); 
                // Add your code here for handling the "Back" button action
                // For example, you can go back to the previous frame or state.
            }
        });

        // Create the container panel to hold both firstPanel and secondPanel
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());

        // Add firstPanel to the CENTER and secondPanel to the SOUTH of the containerPanel
        containerPanel.add(firstPanel, BorderLayout.CENTER);
        containerPanel.add(secondPanel, BorderLayout.SOUTH);

        // Add an outside border to the containerPanel
        containerPanel.setBorder(BorderFactory.createTitledBorder("Winner Details"));

        // Center the containerPanel within the JFrame using GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.CENTER;
        add(containerPanel, gbc);

        // Center the JFrame on the screen
        setLocationRelativeTo(null);

        // Show the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WinnerFrame(null,0,0));
    }
}
