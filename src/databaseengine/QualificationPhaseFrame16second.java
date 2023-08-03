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

public class QualificationPhaseFrame16second extends JFrame {
    CustomClass CustomClass;
 private  java.util.List<CustomClass> cldata2;
 private  java.util.List<CustomClass> cldata;
     private  java.util.List<CustomClass> cldataresult;
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
    private JTable thirdQualificationTable;
    private DefaultTableModel thirdTableModel;
    private JScrollPane thirdScrollPane;
    private JTable fourthQualificationTable;
    private DefaultTableModel fourthTableModel;
    private JScrollPane fourthScrollPane;
    int count;
private  java.util.List<CustomClass> qualificationdata16;
    public QualificationPhaseFrame16second(java.util.List<CustomClass> qualificationdata16) {
        this.qualificationdata16=qualificationdata16;
        this.numOfPlayers = 4;

        // Set frame properties
        setTitle("Qualification Phase 12 Quarter");
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

        // Create components for the third table
        thirdTableModel = new DefaultTableModel(new String[]{"PlayerNumber", "Player Name", "Round1", "Round2", "Round3", "Round4", "Score3"}, 0);
        thirdQualificationTable = new JTable(thirdTableModel);
        thirdScrollPane = new JScrollPane(thirdQualificationTable);

        // Create components for the fourth table
        fourthTableModel = new DefaultTableModel(new String[]{"PlayerNumber", "Player Name", "Round1", "Round2", "Round3", "Round4", "Score4"}, 0);
        fourthQualificationTable = new JTable(fourthTableModel);
        fourthScrollPane = new JScrollPane(fourthQualificationTable);

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
        JLabel firstTableLabel = new JLabel("Table: QuarterFinal 1");
        JLabel secondTableLabel = new JLabel("Table: QuarterFinal 2");
        JLabel thirdTableLabel = new JLabel("Table: QuarterFinal 3");
        JLabel fourthTableLabel = new JLabel("Table: QuarterFinal 4");

        // Set layout and add components to the frame with a vertical BoxLayout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(firstTableLabel);
        add(scrollPane);
        add(secondTableLabel);
        add(secondScrollPane);
        add(thirdTableLabel);
        add(thirdScrollPane);
        add(fourthTableLabel);
        add(fourthScrollPane);
        add(buttonPanel);
        count=0;
        qualificationdata16.forEach(e->{
        if(count<4)
        {
          tableModel.addRow(new Object[]{e.getNumber(),e.getName(), "", "", "", "", Integer.toString(e.getScore())}); 

        }
        else if(count<8)
        {
          secondTableModel.addRow(new Object[]{e.getNumber(),e.getName(), "", "", "", "", Integer.toString(e.getScore())}); 
    
        }
        else if(count<12)
        {
           thirdTableModel.addRow(new Object[]{e.getNumber(),e.getName(), "", "", "", "", Integer.toString(e.getScore())}); 
  
        }
        else
        {
            fourthTableModel.addRow(new Object[]{e.getNumber(),e.getName(), "", "", "", "", Integer.toString(e.getScore())}); 
 
        }
        count++;
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

        // Set preferred column widths for the third table (similar to the original table)
        int thirdTableWidth = thirdScrollPane.getPreferredSize().width;
        int thirdColumnWidth = thirdTableWidth / (thirdTableModel.getColumnCount() - 4); // Exclude 3 columns
        thirdQualificationTable.getColumnModel().getColumn(0).setPreferredWidth((int) (thirdColumnWidth * 0.1));
        thirdQualificationTable.getColumnModel().getColumn(1).setPreferredWidth((int) (thirdColumnWidth * 0.4));
        for (int i = 2; i <= 5; i++) {
            thirdQualificationTable.getColumnModel().getColumn(i).setPreferredWidth((int) (thirdColumnWidth * 0.1));
        }
        thirdQualificationTable.getColumnModel().getColumn(6).setPreferredWidth((int) (thirdColumnWidth * 0.1));

        // Set preferred column widths for the fourth table (similar to the original table)
        int fourthTableWidth = fourthScrollPane.getPreferredSize().width;
        int fourthColumnWidth = fourthTableWidth / (fourthTableModel.getColumnCount() - 4); // Exclude 3 columns
        fourthQualificationTable.getColumnModel().getColumn(0).setPreferredWidth((int) (fourthColumnWidth * 0.1));
        fourthQualificationTable.getColumnModel().getColumn(1).setPreferredWidth((int) (fourthColumnWidth * 0.4));
        for (int i = 2; i <= 5; i++) {
            fourthQualificationTable.getColumnModel().getColumn(i).setPreferredWidth((int) (fourthColumnWidth * 0.1));
        }
        fourthQualificationTable.getColumnModel().getColumn(6).setPreferredWidth((int) (fourthColumnWidth * 0.1));

        // Define the race names (you can use the same ones for all tables if needed)
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

        // Loop to add custom cell renderer and editor for the specified columns for the third table
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
            thirdQualificationTable.getColumnModel().getColumn(columnIdx).setCellRenderer(raceRoundRenderer);
            thirdQualificationTable.getColumnModel().getColumn(columnIdx).setCellEditor(raceRoundEditor);
        }

        // Loop to add custom cell renderer and editor for the specified columns for the fourth table
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
            fourthQualificationTable.getColumnModel().getColumn(columnIdx).setCellRenderer(raceRoundRenderer);
            fourthQualificationTable.getColumnModel().getColumn(columnIdx).setCellEditor(raceRoundEditor);
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

        // Set the custom cell renderer for all columns of the third table except the Score3 column
        for (int i = 0; i < thirdQualificationTable.getColumnCount() - 1; i++) {
            thirdQualificationTable.getColumnModel().getColumn(i).setCellRenderer(new CustomTableCellRenderer());
        }

        // Set the custom cell renderer for all columns of the fourth table except the Score4 column
        for (int i = 0; i < fourthQualificationTable.getColumnCount() - 1; i++) {
            fourthQualificationTable.getColumnModel().getColumn(i).setCellRenderer(new CustomTableCellRenderer());
        }

        // Add action listeners to the buttons
        nextRoundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printTableValueswinner(tableModel);
                printTableValuesloser(tableModel);
                printTableValueswinner(secondTableModel);
                printTableValuesloser(secondTableModel);
                printTableValueswinner(thirdTableModel);
                printTableValuesloser(thirdTableModel);
                printTableValueswinner(fourthTableModel);
                printTableValuesloser(fourthTableModel);
                LoserQuarter16 LoserQuarter16=new LoserQuarter16(
                printTableValueswinner(tableModel),
                printTableValuesloser(tableModel),
                printTableValueswinner(secondTableModel),
                printTableValuesloser(secondTableModel),
                printTableValueswinner(thirdTableModel),
                printTableValuesloser(thirdTableModel),
                printTableValueswinner(fourthTableModel),
                printTableValuesloser(fourthTableModel)
               );
               LoserQuarter16.setVisible(true);
               dispose();
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

    private java.util.List<CustomClass> printTableValuesloser( DefaultTableModel model) {
                 
                 cldata=new ArrayList<CustomClass> ();
                 cldataresult=new ArrayList<CustomClass> ();
                for (int i = 0; i < numOfPlayers; i++) {                   
                    CustomClass= new CustomClass();
                    CustomClass.setNumber((int) model.getValueAt(i, 0));
                    CustomClass.setName((String) model.getValueAt(i, 1));
                    CustomClass.setRound1(convertStringToInt((String) model.getValueAt(i, 2)));
                    CustomClass.setRound2(convertStringToInt((String) model.getValueAt(i, 3)));
                    CustomClass.setRound3(convertStringToInt((String) model.getValueAt(i, 4)));
                    CustomClass.setRound4(convertStringToInt((String) model.getValueAt(i, 5)));
                    CustomClass.setScore(
                            convertStringToInt((String) model.getValueAt(i, 2))+
                            convertStringToInt((String) model.getValueAt(i, 3))+
                            convertStringToInt((String) model.getValueAt(i, 4))+
                            convertStringToInt((String) model.getValueAt(i, 5))
                            );
                    
                    cldata.add(CustomClass);
                }                  
                      cldata2=cldata;
                      CustomClass= new CustomClass();
                      
                      
                      for(int i=0;i<2;i++)
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
                      
                      cldata2.forEach(e->{
                      System.out.println("Name Value: "+e.getName());
                      });
                      
                      //Semefinal8 Semefinal8=new Semefinal8( cldataresult);
                      //Semefinal8.setVisible(true);
                      //dispose();
                return cldata2;
            }


      private java.util.List<CustomClass> printTableValueswinner( DefaultTableModel model) {
                 
                 cldata=new ArrayList<CustomClass> ();
                 cldataresult=new ArrayList<CustomClass> ();
                for (int i = 0; i < numOfPlayers; i++) {                   
                    CustomClass= new CustomClass();
                    CustomClass.setNumber((int) model.getValueAt(i, 0));
                    CustomClass.setName((String) model.getValueAt(i, 1));
                    CustomClass.setRound1(convertStringToInt((String) model.getValueAt(i, 2)));
                    CustomClass.setRound2(convertStringToInt((String) model.getValueAt(i, 3)));
                    CustomClass.setRound3(convertStringToInt((String) model.getValueAt(i, 4)));
                    CustomClass.setRound4(convertStringToInt((String) model.getValueAt(i, 5)));
                    CustomClass.setScore(
                            convertStringToInt((String) model.getValueAt(i, 2))+
                            convertStringToInt((String) model.getValueAt(i, 3))+
                            convertStringToInt((String) model.getValueAt(i, 4))+
                            convertStringToInt((String) model.getValueAt(i, 5))
                            );
                    
                    cldata.add(CustomClass);
                }                
                      cldata2=cldata;
                      CustomClass= new CustomClass();
                      
                      
                      for(int i=0;i<2;i++)
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
                      
                      //Semefinal8 Semefinal8=new Semefinal8( cldataresult);
                      //Semefinal8.setVisible(true);
                      //dispose();
                      return cldataresult;
                
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
            QualificationPhaseFrame16second qualificationPhaseFrame = new QualificationPhaseFrame16second(null);
            qualificationPhaseFrame.setVisible(true);
        });
    }
}
//QualificationPhaseFrame