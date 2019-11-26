import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontGateView {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel lblRegistration = new JLabel("Registration");
    JTextField txtRegistration = new JTextField(20);
    JButton btnSearch = new JButton("Search");
    JButton btnClear = new JButton("Clear");
    JLabel lblProgress = new JLabel("Progress");
    JTextArea txtProgress = new JTextArea(10, 10);
    ParkingDB db = new ParkingDB();
    BarrierProcess bp = new BarrierProcess(db);

    public FrontGateView() {

        // Set up the panel
        panel.setLayout(new MigLayout());
        panel.setPreferredSize(new Dimension(700, 300));
        panel.add(lblRegistration);
        panel.add(txtRegistration, "wrap, pushx, growx");
        panel.add(btnSearch, "skip, split2");
        panel.add(btnClear, "wrap");
        panel.add(lblProgress, "top");
        panel.add(new JScrollPane(txtProgress), "push, grow");

        // Handle frame operation
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Create a new event handler
        TheHandler handler = new TheHandler();
        btnSearch.addActionListener(handler);
        btnClear.addActionListener(handler);
    }

    /*
     * TheHandler: handles key presses
     */
    private class TheHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnSearch) {
                int regNum = Integer.parseInt(txtRegistration.getText());
                boolean result = bp.scanPlate(regNum);
                if (result == true) {
                    txtProgress.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
                    txtProgress.setForeground(Color.black);
                    txtProgress.setBackground(Color.green);
                    txtProgress.setText("Match found. Barrier opening.");
                }
                else if (result == false) {
                    txtProgress.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
                    txtProgress.setForeground(Color.white);
                    txtProgress.setBackground(Color.red);
                    txtProgress.setText("No match found. Contract traffic department.");
                }
            }
            if (e.getSource() == btnClear) {
                txtRegistration.setText("");
                txtProgress.setForeground(Color.black);
                txtProgress.setBackground(Color.white);
                txtProgress.setText("");
            }
        }
    }
}
