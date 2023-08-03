package databaseengine;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinnerGrand10 extends JFrame {
    private String[] playerNames;
    private int numOfPlayers;
    private int currentRound = 1;
    private JButton nextRoundButton;
    private JButton backButton;
    private JTable qualificationTable;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JTable secondQualificationTable;
    private DefaultTableModel secondTableModel;
    private JScrollPane secondScrollPane;

    public WinnerGrand10(String[] playerNames) {
        this.playerNames = playerNames;
        this.numOfPlayers = playerNames.length;

        // Set frame properties
        setTitle("Winners Phase 10");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1360, 500);
        setLocationRelativeTo(null); // Center the window on the screen

        // Create components for the first table
        tableModel = new DefaultTableModel(new String[]{"PlayerNumber", "Player Name", "Race1", "Race2", "Race3", "Race4", "Score"}, 0);
        qualificationTable = new JTable(tableModel);
        scrollPane = new JScrollPane(qualificationTable);

        // Create components for the second table
        secondTableModel = new DefaultTableModel(new String[]{"PlayerNumber", "Player Name", "Race1", "Race2","Race3","Race4","Race5","Race6", "Score"}, 0);
        secondQualificationTable = new JTable(secondTableModel);
        secondScrollPane = new JScrollPane(secondQualificationTable);

        nextRoundButton = new JButton("Next Round");
        nextRoundButton.setSize(80, 25); // Set the button size directly

        backButton = new JButton("Back");
        backButton.setSize(80, 25); // Set the button size directly

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // 10-pixel gaps between components

        // Add the buttons to the buttonPanel
        buttonPanel.add(backButton);
        buttonPanel.add(nextRoundButton);

      // Create labels for each table
        JLabel firstTableLabel = new JLabel("Table: Winners Final");
        JLabel secondTableLabel = new JLabel("Table: Grand Final");

        // Set layout and add components to the frame with a vertical BoxLayout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(firstTableLabel);
        add(scrollPane);
        add(secondTableLabel);
        add(secondScrollPane);
        add(buttonPanel);

        // Add rows to the first table for each player with their names and empty score fields
        for (int i = 0; i < numOfPlayers; i++) {
            // Add the new columns with empty values to the tableModel
            tableModel.addRow(new Object[]{i + 1, playerNames[i], "", "", "", "", ""});
        }

        // Add rows to the second table for each player with their names and empty score fields
        for (int i = 0; i < numOfPlayers; i++) {
            // Add the new columns with empty values to the secondTableModel
            secondTableModel.addRow(new Object[]{i + 1, playerNames[i], "", "", ""});
        }

        // Set preferred column widths for the first table (similar to the original table)
        int tableWidth = scrollPane.getPreferredSize().width;
        int columnWidth = tableWidth / (tableModel.getColumnCount() - 4); // Exclude 4 columns
        qualificationTable.getColumnModel().getColumn(0).setPreferredWidth((int) (columnWidth * 0.1));
        qualificationTable.getColumnModel().getColumn(1).setPreferredWidth((int) (columnWidth * 0.4));
        for (int i = 2; i <= 5; i++) {
            qualificationTable.getColumnModel().getColumn(i).setPreferredWidth((int) (columnWidth * 0.1));
        }
        qualificationTable.getColumnModel().getColumn(6).setPreferredWidth((int) (columnWidth * 0.1));

        // Set preferred column widths for the second table (similar to the original table)
        int secondTableWidth = secondScrollPane.getPreferredSize().width;
        int secondColumnWidth = secondTableWidth / (secondTableModel.getColumnCount() - 4); // Exclude 3 columns
        secondQualificationTable.getColumnModel().getColumn(0).setPreferredWidth((int) (secondColumnWidth * 0.1));
        secondQualificationTable.getColumnModel().getColumn(1).setPreferredWidth((int) (secondColumnWidth * 0.4));
        for (int i = 2; i <= 7; i++) {
            secondQualificationTable.getColumnModel().getColumn(i).setPreferredWidth((int) (secondColumnWidth * 0.1));
        }
        secondQualificationTable.getColumnModel().getColumn(8).setPreferredWidth((int) (secondColumnWidth * 0.1));

        // Define the race names (you can use the same ones for both tables if needed)
        String[] raceNames = {"0", "1", "2", "3", "5"};

        // Custom cell renderer for the JComboBox with increased height
        class CustomComboBoxRenderer extends DefaultListCellRenderer {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JComponent) {
                    JComponent jc = (JComponent) renderer;
                    jc.setPreferredSize(new Dimension(jc.getPreferredSize().width, 60)); // Set the desired height (e.g., 40 pixels)
                }
                return renderer;
            }
        }

        // Loop to add custom cell renderer and editor for the specified columns for the first table
        for (int columnIdx : new int[]{2, 3, 4, 5}) {
            TableCellRenderer raceRoundRenderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JComboBox<String> comboBox = new JComboBox<>(raceNames);
                    comboBox.setSelectedItem(value); // Set the selected item based on the cell's value
                    comboBox.setRenderer(new CustomComboBoxRenderer()); // Set the custom renderer for the JComboBox
                    return comboBox;
                }
            };

            TableCellEditor raceRoundEditor = new DefaultCellEditor(new JComboBox<>(raceNames));
            qualificationTable.getColumnModel().getColumn(columnIdx).setCellRenderer(raceRoundRenderer);
            qualificationTable.getColumnModel().getColumn(columnIdx).setCellEditor(raceRoundEditor);
        }

        // Loop to add custom cell renderer and editor for the specified columns for the second table
        for (int columnIdx : new int[]{2, 3, 4, 5,6,7}) {
            TableCellRenderer raceRoundRenderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JComboBox<String> comboBox = new JComboBox<>(raceNames);
                    comboBox.setSelectedItem(value); // Set the selected item based on the cell's value
                    comboBox.setRenderer(new CustomComboBoxRenderer()); // Set the custom renderer for the JComboBox
                    return comboBox;
                }
            };

            TableCellEditor raceRoundEditor = new DefaultCellEditor(new JComboBox<>(raceNames));
            secondQualificationTable.getColumnModel().getColumn(columnIdx).setCellRenderer(raceRoundRenderer);
            secondQualificationTable.getColumnModel().getColumn(columnIdx).setCellEditor(raceRoundEditor);
        }

        // Custom cell renderer for the table cells with increased cell height
        class CustomTableCellRenderer extends DefaultTableCellRenderer {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (renderer instanceof JComponent) {
                    JComponent jc = (JComponent) renderer;
                    jc.setPreferredSize(new Dimension(jc.getPreferredSize().width, 60)); // Set the desired cell height (e.g., 60 pixels)
                }
                return renderer;
            }
        }

        // Set the custom cell renderer for all columns of the first table except the Score column
        for (int i = 0; i < qualificationTable.getColumnCount() - 1; i++) {
            qualificationTable.getColumnModel().getColumn(i).setCellRenderer(new CustomTableCellRenderer());
        }

        // Set the custom cell renderer for all columns of the second table except the Score2 column
        for (int i = 0; i < secondQualificationTable.getColumnCount() - 1; i++) {
            secondQualificationTable.getColumnModel().getColumn(i).setCellRenderer(new CustomTableCellRenderer());
        }

        // Add action listeners to the buttons
        nextRoundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the first table with scores for the current round
                updateTableWithScores();

                // Update the second table with scores for the current round
                updateSecondTableWithScores();

                // Increase the current round and update the frame title
                currentRound++;
                setTitle("Qualification Phase - Round " + currentRound);

                // Clear the scores for the next round for both tables
                clearScoresForNextRound();

                // Check if all rounds are completed, if yes, proceed to the next phase
                if (currentRound > 3) { // Change 3 to the total number of rounds in the qualification phase
                    finishQualificationPhase();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your code here for handling the "Back" button action
                // For example, you can go back to the previous frame or state.
            }
        });
    }

    // Method to update the first table with scores for the current round
    private void updateTableWithScores() {
        // Retrieve scores for the current round and update the table accordingly.
        // For illustration purposes, let's assume you have an array of scores for each player for the current round:
        int[] scoresForRound = {10, 15, 8, 12, 20, 13, 18};
        String[] racesForRound1 = {"0", "1", "2", "3", "5"};
        String[] racesForRound2 = {"0", "1", "2", "3", "5"};
        String[] racesForRound3 = {"0", "1", "2", "3", "5"};
        String[] racesForRound4 = {"0", "1", "2", "3", "5"};

        // Update the "Score" column, "Race1->Round1" column, and "Race1->Round2" column
        for (int i = 0; i < numOfPlayers; i++) {
            tableModel.setValueAt(scoresForRound[i], i, 6); // Update the Score column
            tableModel.setValueAt(racesForRound1[i], i, 2); // Update the Race1->Round1 column
            tableModel.setValueAt(racesForRound2[i], i, 3); // Update the Race1->Round2 column
            tableModel.setValueAt(racesForRound3[i], i, 4); // Update the Race1->Round3 column
            tableModel.setValueAt(racesForRound4[i], i, 5); // Update the Race1->Round4 column
            // You can similarly update the other "Race2->RoundX" columns if needed.
        }

        // For illustration purposes, let's assume you have an array of scores for "Score1" for the current round:
        int[] scoresForScore1 = {5, 8, 6, 3, 10, 9, 7};

        // Update the "Score1" column
        for (int i = 0; i < numOfPlayers; i++) {
            tableModel.setValueAt(scoresForScore1[i], i, 7);
        }
    }

    // Method to update the second table with scores for the current round
    private void updateSecondTableWithScores() {
        // Retrieve scores for the current round and update the table accordingly.
        // For illustration purposes, let's assume you have an array of scores for each player for the current round:
        int[] scoresForRound = {10, 15, 8, 12, 20, 13, 18};
        String[] racesForRound1 = {"0", "1", "2", "3", "5"};
        String[] racesForRound2 = {"0", "1", "2", "3", "5"};
        String[] racesForRound3 = {"0", "1", "2", "3", "5"};
        String[] racesForRound4 = {"0", "1", "2", "3", "5"};

        // Update the "Score" column, "Race1->Round1" column, and "Race1->Round2" column
        for (int i = 0; i < numOfPlayers; i++) {
            secondTableModel.setValueAt(scoresForRound[i], i, 6); // Update the Score column
            secondTableModel.setValueAt(racesForRound1[i], i, 2); // Update the Race1->Round1 column
            secondTableModel.setValueAt(racesForRound2[i], i, 3); // Update the Race1->Round2 column
            secondTableModel.setValueAt(racesForRound3[i], i, 4); // Update the Race1->Round3 column
            secondTableModel.setValueAt(racesForRound4[i], i, 5); // Update the Race1->Round4 column
            // You can similarly update the other "Race2->RoundX" columns if needed.
        }

        // For illustration purposes, let's assume you have an array of scores for "Score1" for the current round:
        int[] scoresForScore1 = {5, 8, 6, 3, 10, 9, 7};

        // Update the "Score1" column
        for (int i = 0; i < numOfPlayers; i++) {
            secondTableModel.setValueAt(scoresForScore1[i], i, 7);
        }
        // Retrieve scores for the current round and update the table accordingly.
        // For illustration purposes, let's assume you have an array of scores for each player for the current round:
        
    }

    // Method to clear scores for the next round for both tables
    private void clearScoresForNextRound() {
        for (int i = 0; i < numOfPlayers; i++) {
            tableModel.setValueAt(i + 1, i, 0);
            tableModel.setValueAt("", i, 2);
            tableModel.setValueAt("", i, 3);
            tableModel.setValueAt("", i, 4);
            tableModel.setValueAt("", i, 5);
            tableModel.setValueAt("", i, 6);
            tableModel.setValueAt("", i, 7);
            
            secondTableModel.setValueAt(i + 1, i, 0);
            secondTableModel.setValueAt("", i, 2);
            secondTableModel.setValueAt("", i, 3);
            secondTableModel.setValueAt("", i, 4);
            secondTableModel.setValueAt("", i, 5);
            secondTableModel.setValueAt("", i, 6);
            secondTableModel.setValueAt("", i, 7);

            
        }
    }

    // Method to finish the qualification phase and proceed to the next phase
    private void finishQualificationPhase() {
        // Add your code here to proceed to the next phase (e.g., top8-10-12 phase) or display the winner frame.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String[] playerNames = {"Player 1", "Player 2", "Player 3", "Player 4"};
            WinnerGrand10 qualificationPhaseFrame = new WinnerGrand10(playerNames);
            qualificationPhaseFrame.setVisible(true);
        });
    }
}
//QualificationPhaseFrame