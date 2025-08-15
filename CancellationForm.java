import javax.swing.*;
import java.sql.*;

public class CancellationForm extends JFrame {
    JTextField pnrField;

    public CancellationForm() {
        setTitle("Cancel Ticket");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        pnrField = new JTextField(10);
        JButton cancelBtn = new JButton("Cancel Ticket");

        JPanel panel = new JPanel();
        panel.add(new JLabel("PNR:"));
        panel.add(pnrField);
        panel.add(cancelBtn);
        add(panel);

        cancelBtn.addActionListener(e -> cancelTicket());
        setVisible(true);
    }

    private void cancelTicket() {
        String pnr = pnrField.getText();

        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE reservations SET status='CANCELLED' WHERE pnr=?");
            stmt.setString(1, pnr);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Ticket Cancelled");
            } else {
                JOptionPane.showMessageDialog(this, "PNR not found");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}