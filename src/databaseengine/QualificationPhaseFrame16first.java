package databaseengine;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QualificationPhaseFrame16first extends JFrame {
    int count=0;
      CustomClass CustomClass;
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
    private  java.util.List<CustomClass> cldata;
     private  java.util.List<CustomClass> cldata2;
      private  java.util.List<CustomClass> cldataresult;
    public QualificationPhaseFrame16first( java.util.List<CustomClass> cl) {
        System.out.println("saddam");
        this.cldata=cl;
        //this.playerNames = playerNames;
        this.numOfPlayers = cl.size();

        // Set frame properties
        setTitle("Qualification 12 Phase ");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1360, 500);
        setLocationRelativeTo(null); // Center the window on the screen

        // Create components for the first table
        tableModel = new DefaultTableModel(new String[]{"PlayerNumber", "Player Name", "Round1", "Round2", "Round3", "Round4", "Score"}, 0);
        qualificationTable = new JTable(tableModel);
        scrollPane = new JScrollPane(qualificationTable);

        // Create components for the second table
        secondTableModel = new DefaultTableModel(new String[]{"PlayerNumber", "Player Name", "Round1", "Round2", "Round3", "Round4", "Score2"}, 0);
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
        JLabel firstTableLabel = new JLabel("Table: Race 1");
        JLabel secondTableLabel = new JLabel("Table: Race 2");

        // Set layout and add components to the frame with a vertical BoxLayout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(firstTableLabel);
        add(scrollPane);
        add(secondTableLabel);
        add(secondScrollPane);
        add(buttonPanel);
        
        
        cldata.forEach(e->{
           System.out.println(e.getName());
          tableModel.addRow(new Object[]{e.getNumber(),e.getName(), "", "", "", "", ""});
          secondTableModel.addRow(new Object[]{e.getNumber(),e.getName(), "", "", "", "", ""});
        });
        
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
        for (int i = 2; i <= 5; i++) {
            secondQualificationTable.getColumnModel().getColumn(i).setPreferredWidth((int) (secondColumnWidth * 0.1));
        }
        secondQualificationTable.getColumnModel().getColumn(6).setPreferredWidth((int) (secondColumnWidth * 0.1));

        // Define the race names (you can use the same ones for both tables if needed)
        String[] raceNames = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "15"};

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
            secondQualificationTable.getColumnModel().getColumn(columnIdx).setCellRenderer(raceRoundRenderer);
            secondQualificationTable.getColumnModel().getColumn(columnIdx).setCellEditor(raceRoundEditor);
        }
       
        
// Set the selected index of the JComboBox model for both tables to 0 (first item)
        for (int columnIdx : new int[]{2, 3, 4, 5}) {
            JComboBox<String> comboBox = new JComboBox<>(raceNames);
            comboBox.setSelectedIndex(0); // Set the first item as selected initially
            DefaultCellEditor raceRoundEditor = new DefaultCellEditor(comboBox);
            qualificationTable.getColumnModel().getColumn(columnIdx).setCellEditor(raceRoundEditor);
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
              
                // Print the values of both tables
                  printTableValues(tableModel,secondTableModel);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartingPage StartingPage=new StartingPage();
                StartingPage.setVisible(true);
                dispose();
                // Add your code here for handling the "Back" button action
                // For example, you can go back to the previous frame or state.
            }
        });
    }
            private void printTableValues( DefaultTableModel model,DefaultTableModel secondTableModel) {
                 
                 cldata=new ArrayList<CustomClass> ();
                 cldataresult=new ArrayList<CustomClass> ();
                for (int i = 0; i < numOfPlayers; i++) {                   
                    CustomClass= new CustomClass();
                    CustomClass.setNumber((int) model.getValueAt(i, 0));
                    CustomClass.setName((String) model.getValueAt(i, 1));
                    CustomClass.setRound1(convertStringToInt((String) model.getValueAt(i, 2))+convertStringToInt((String) secondTableModel.getValueAt(i, 2)));
                    CustomClass.setRound2(convertStringToInt((String) model.getValueAt(i, 3))+convertStringToInt((String) secondTableModel.getValueAt(i, 3)));
                    CustomClass.setRound3(convertStringToInt((String) model.getValueAt(i, 4))+convertStringToInt((String) secondTableModel.getValueAt(i, 4)));
                    CustomClass.setRound4(convertStringToInt((String) model.getValueAt(i, 5))+convertStringToInt((String) secondTableModel.getValueAt(i, 5)));
                    CustomClass.setScore(
                            convertStringToInt((String) model.getValueAt(i, 2))+convertStringToInt((String) secondTableModel.getValueAt(i, 2))+
                            convertStringToInt((String) model.getValueAt(i, 3))+convertStringToInt((String) secondTableModel.getValueAt(i, 3))+
                            convertStringToInt((String) model.getValueAt(i, 4))+convertStringToInt((String) secondTableModel.getValueAt(i, 4))+
                            convertStringToInt((String) model.getValueAt(i, 5))+convertStringToInt((String) secondTableModel.getValueAt(i, 5))
                            );
                    
                    cldata.add(CustomClass);
                }                
                      cldata2=cldata;
                      CustomClass= new CustomClass();
                      
                      
                      for(int i=0;i<16;i++)
                      {
                       count=0;
                      int index=CustomClass.indexcount(cldata2);
                     // System.out.println("Index Value: "+index);
                      cldata2.forEach(e->{
                          if(index==count)
                          {
                            cldataresult.add(e);
                          }
                      count++;
                      });
                      cldata2.remove(index);  
                      }
                      
                      cldataresult.forEach(e->{
                      System.out.println("Name Value: "+e.getName());
                      });
                      
                      QualificationPhaseFrame16second Semefinal8=new QualificationPhaseFrame16second( cldataresult);
                      Semefinal8.setVisible(true);
                      dispose();
                
            }

    
    // Method to finish the qualification phase and proceed to the next phase
    private void finishQualificationPhase() {
        // Add your code here to proceed to the next phase (e.g., top8-10-12 phase) or display the winner frame.
    }
    
    public int convertStringToInt(String input) {
    try {
        // Attempt to parse the string to an int
        // If the input is empty, this will throw a NumberFormatException
        return Integer.parseInt(input);
    } catch (NumberFormatException e) {
        // Handle the case when the input is not a valid int (empty string or non-numeric characters)
        // You can decide how to handle this situation based on your requirements
        // For example, you can return a default value or show an error message.
        return 0; // Return 0 as a default value (you can choose another default if needed)
    }
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String[] playerNames = {"Player 1", "Player 2", "Player 3", "Player 4", "Player 5", "Player 6", "Player 7", "Player 8"};
            QualificationPhaseFrame16first qualificationPhaseFrame = new QualificationPhaseFrame16first( null);
            qualificationPhaseFrame.setVisible(true);
        });
    }
}
//QualificationPhaseFrame