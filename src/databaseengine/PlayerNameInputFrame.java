package databaseengine;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;

public class PlayerNameInputFrame extends JFrame {
    private int numOfPlayers,mod;
    private JButton continueButton;
    private JButton backButton; // New back button
    private JTable playerTable;
    private DefaultTableModel tableModel;
    CustomClass CustomClass;

    public PlayerNameInputFrame(int numOfPlayers,int mod) {
        this.numOfPlayers = numOfPlayers;
        this.mod=mod;
        // Set frame properties
        setTitle("Player Name Input");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null); // Center the window on the screen

        // Create components
        tableModel = new DefaultTableModel(new String[]{"Player Number", "Player Name"}, 0);
        playerTable = new JTable(tableModel) {
            @Override
            public Class<?> getColumnClass(int column) {
                return (column == 0) ? Integer.class : String.class;
            }

            @Override
            public boolean getScrollableTracksViewportHeight() {
                // Set the table to fit within the available height
                return getPreferredSize().height < getParent().getHeight();
            }
        };

        // Use custom renderer for the "Player Number" column
        playerTable.getColumnModel().getColumn(0).setCellRenderer(new PlayerNumberRenderer());

        // Set the column widths
        playerTable.getColumnModel().getColumn(0).setPreferredWidth(100); // "Player Number" column width
        playerTable.getColumnModel().getColumn(1).setPreferredWidth(300); // "Player Name" column width

        // Reduce the row height
        playerTable.setRowHeight(30); // Set the desired row height (e.g., 30 pixels)

        JScrollPane scrollPane = new JScrollPane(playerTable);

        continueButton = new JButton("Continue");
        backButton = new JButton("Back"); // New back button

        // Set the preferred size for both buttons
        continueButton.setPreferredSize(new Dimension(150, 30)); // Set the desired width and height (e.g., 150x30 pixels)
        backButton.setPreferredSize(new Dimension(150, 30)); // Set the desired width and height (e.g., 150x30 pixels)

        // Add action listener to the continueButton
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve the player names and numbers from the table and proceed with the tournament
                String[] playerNames = new String[numOfPlayers];
                int[] playerNumbers = new int[numOfPlayers];
                 List<CustomClass> cl = new ArrayList<>();
                for (int i = 0; i < numOfPlayers; i++) {
                    CustomClass= new CustomClass();
                    CustomClass.setNumber((int) tableModel.getValueAt(i, 0));
                    CustomClass.setName((String) tableModel.getValueAt(i, 1));
                    cl.add(CustomClass);
                }
               
                startTournament(cl);
                
                
            }
        });


        // Add action listener to the backButton
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartingPage StartingPage=new StartingPage();
                StartingPage.setVisible(true);
                dispose();
                // Add functionality to go back to the previous screen or action
            }
        });

        // Create a wrapper panel for the continueButton and backButton
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(backButton);
        buttonPanel.add(continueButton);

        // Create a panel for the table and the buttons
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Set layout and add components to the frame
        setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);

        // Add rows to the table equal to the number of players
        for (int i = 1; i <= numOfPlayers; i++) {
            tableModel.addRow(new Object[]{i, ""});
        }
    }

    // Method to handle the start of the tournament with player names
    private void startTournament(  List<CustomClass> cl) {
        if(mod==8)
        {
            QualificationPhaseFrame QualificationPhaseFrame=new QualificationPhaseFrame(cl);
            QualificationPhaseFrame.setVisible(true);
            dispose();
        }
        else if(mod==12)
        {
           QualificationPhaseFrame12 QualificationPhaseFrame=new QualificationPhaseFrame12(cl);
            QualificationPhaseFrame.setVisible(true);
            dispose(); 
        }
        else
        {
           QualificationPhaseFrame16first QualificationPhaseFrame=new QualificationPhaseFrame16first(cl);
            QualificationPhaseFrame.setVisible(true);
            dispose();  
        }
    }

    // Custom renderer for the "Player Number" column
    private static class PlayerNumberRenderer extends DefaultTableCellRenderer {
        public PlayerNumberRenderer() {
            setHorizontalAlignment(SwingConstants.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            int playerNumber = (Integer) value;
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, playerNumber, isSelected, hasFocus, row, column);
            label.setText("Player " + playerNumber);
            return label;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            int numOfPlayers = 8; // Set the number of players here (e.g., 8, 10, 12)
            PlayerNameInputFrame playerNameInputFrame = new PlayerNameInputFrame(0,0);
            playerNameInputFrame.setVisible(true);
        });
    }
}
