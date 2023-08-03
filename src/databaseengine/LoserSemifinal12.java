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

public class LoserSemifinal12 extends JFrame {
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
      private  java.util.List<CustomClass> semifinal1winner;
       private  java.util.List<CustomClass> semifinal2winner;
        private  java.util.List<CustomClass> semifinal1loser;
         private  java.util.List<CustomClass> semifinal2loser;
         private  java.util.List<CustomClass> loserinfoqualification4;
     private  java.util.List<CustomClass> cldata2;
     private  java.util.List<CustomClass> cldataresult;
     int count=0;
    public LoserSemifinal12(java.util.List<CustomClass> loserinfoqualification4,java.util.List<CustomClass> semifinal1winner,java.util.List<CustomClass> semifinal1loser,java.util.List<CustomClass> semifinal2winner,java.util.List<CustomClass> semifinal2loser) {
         this.semifinal1winner=semifinal1winner;
        this.semifinal2winner=semifinal2winner;
        this.semifinal1loser=semifinal1loser;
        this.semifinal2loser=semifinal2loser;
        this.loserinfoqualification4=loserinfoqualification4;
        this.numOfPlayers = 4;

        // Set frame properties
        setTitle("Loser Semifinal Phase");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1360, 500);
        setLocationRelativeTo(null); // Center the window on the screen

        // Create components for the first table
        tableModel = new DefaultTableModel(new String[]{"PlayerNumber", "Player Name", "Race1", "Race2", "Race3", "Race4", "Score"}, 0);
        qualificationTable = new JTable(tableModel);
        scrollPane = new JScrollPane(qualificationTable);

        // Create components for the second table
        secondTableModel = new DefaultTableModel(new String[]{"PlayerNumber", "Player Name", "Race1", "Race2","Race3","Race4", "Score2"}, 0);
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
        JLabel firstTableLabel = new JLabel("Table: Loser Semifinal 1");
        JLabel secondTableLabel = new JLabel("Table: Loser Semifinal 2");

        // Set layout and add components to the frame with a vertical BoxLayout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(firstTableLabel);
        add(scrollPane);
        add(secondTableLabel);
        
        
        
        add(secondScrollPane);
        add(buttonPanel);
        System.out.println("semifinal1loser six :"+loserinfoqualification4.size());
        semifinal1loser.forEach(e->{
            if(count==0)
            {
                tableModel.addRow(new Object[]{e.getNumber(),e.getName(), "", "", "", "", Integer.toString(e.getScore())}); 
            }
            else
            {
               secondTableModel.addRow(new Object[]{e.getNumber(),e.getName(), "", "", "", "", Integer.toString(e.getScore())}); 
            }         
          count++;
        });
        
        count=0;
        semifinal2loser.forEach(e->{
            if(count==0)
            {
                tableModel.addRow(new Object[]{e.getNumber(),e.getName(), "", "", "", "", Integer.toString(e.getScore())}); 
            }
            else
            {
               secondTableModel.addRow(new Object[]{e.getNumber(),e.getName(), "", "", "", "", Integer.toString(e.getScore())}); 
            }         
          count++;
        });
        count=0;
        loserinfoqualification4.forEach(e->{
            if(count==0 || count==2)
            {
                tableModel.addRow(new Object[]{e.getNumber(),e.getName(), "", "", "", "", Integer.toString(e.getScore())}); 
            }
            else
            {
               secondTableModel.addRow(new Object[]{e.getNumber(),e.getName(), "", "", "", "", Integer.toString(e.getScore())}); 
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
                
                
                  printTableValueswinner(tableModel);
                 printTableValuesloser(tableModel);
                 
                 printTableValueswinner(secondTableModel);
                 printTableValuesloser(secondTableModel);
                 
                 Losser12LoserRound   Losser8=new   Losser12LoserRound(printTableValueswinner(tableModel),printTableValueswinner(secondTableModel),semifinal1winner,semifinal1loser,semifinal2winner,semifinal2loser);
                   Losser8.setVisible(true);
                   dispose();
                 
               
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
            LoserSemifinal12 qualificationPhaseFrame = new LoserSemifinal12(null,null,null,null,null);
            qualificationPhaseFrame.setVisible(true);
        });
    }
}
//QualificationPhaseFrame