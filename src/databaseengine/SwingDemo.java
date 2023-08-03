package databaseengine;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDemo {
    public static void main(String[] argv) throws Exception {
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("Languages");
        tableModel.addColumn("Value"); // Add the "Value" column

        // Insert rows with data for the "Languages" column only
        tableModel.insertRow(0, new Object[]{"CSS", ""});
        tableModel.insertRow(0, new Object[]{"HTML5", ""});
        tableModel.insertRow(0, new Object[]{"JavaScript", ""});
        tableModel.insertRow(0, new Object[]{"jQuery", ""});
        tableModel.insertRow(0, new Object[]{"AngularJS", ""});
        tableModel.insertRow(tableModel.getRowCount(), new Object[]{"ExpressJS", ""});

        JFrame f = new JFrame();
        f.setSize(600, 400); // Increased the width to accommodate the additional column
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        // Create and add a button to the bottom left corner
        JButton button = new JButton("Click Me");
        panel.add(button, BorderLayout.SOUTH);

        // Add ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve and print all values from the JTable
                int rowCount = tableModel.getRowCount();
                int columnCount = tableModel.getColumnCount();
                for (int row = 0; row < rowCount; row++) {
                    for (int col = 0; col < columnCount; col++) {
                        System.out.print(tableModel.getValueAt(row, col) + " ");
                    }
                    System.out.println();
                }
            }
        });

        f.add(panel);
        f.setVisible(true);
    }
}
