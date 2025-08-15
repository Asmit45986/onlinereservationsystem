import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ReservationForm extends JFrame {
    JTextField trainNoField, dateField, fromField, toField, classField;

    public ReservationForm() {
        setTitle("Reservation");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        trainNoField = new JTextField(10);
        classField = new JTextField(10);
        dateField = new JTextField(10);
        fromField = new JTextField(10);
        toField = new JTextField(10);
        JButton reserveBtn = new JButton("Reserve");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Train No:"));
        panel.add(trainNoField);
        panel.add(new JLabel("Class:"));
        panel.add(classField);
        panel.add(new JLabel("Date:"));
        panel.add(dateField);
        panel.add(new JLabel("From:"));
        panel.add(fromField);
        panel.add(new JLabel("To:"));
        panel.add(toField);
        panel.add(reserveBtn);
        add(panel);

        reserveBtn.addActionListener(e -> reserve());
        setVisible(true);
    }

    private void reserve() {
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO reservations (train_no, class, date, source, destination, status) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, trainNoField.getText());
            stmt.setString(2, classField.getText());
            stmt.setString(3, dateField.getText());
            stmt.setString(4, fromField.getText());
            stmt.setString(5, toField.getText());
            stmt.setString(6, "BOOKED");

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Reservation successful");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}