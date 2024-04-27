import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantReservationSystem {
    private JFrame frame;
    private JTextField nameField;
    private JTextField numOfGuestsField;
    private JTextField dateField;
    private JTextField timeField;
    private JTextArea reservationDetailsArea;

    public RestaurantReservationSystem() {
        frame = new JFrame("Restaurant Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2));

        frame.add(new JLabel("Name:"));
        nameField = new JTextField();
        frame.add(nameField);

        frame.add(new JLabel("Number of Guests:"));
        numOfGuestsField = new JTextField();
        frame.add(numOfGuestsField);

        frame.add(new JLabel("Date (MM/DD/YYYY):"));
        dateField = new JTextField();
        frame.add(dateField);

        frame.add(new JLabel("Time (HH:MM AM/PM):"));
        timeField = new JTextField();
        frame.add(timeField);

        JButton reserveButton = new JButton("Reserve");
        frame.add(reserveButton);

        reservationDetailsArea = new JTextArea();
        reservationDetailsArea.setEditable(false);
        frame.add(reservationDetailsArea);

        reserveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reserve();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private void reserve() {
        String name = nameField.getText();
        int numOfGuests = Integer.parseInt(numOfGuestsField.getText());
        String date = dateField.getText();
        String time = timeField.getText();

        if (numOfGuests > 15) {
            reservationDetailsArea.setText("Sorry for the inconvenience, the capacity for one booking is of 15 members only");
        } else {
            String reservationDetails = "Reservation Details:\n" +
                    "Name: " + name + "\n" +
                    "Number of Guests: " + numOfGuests + "\n" +
                    "Date: " + date + "\n" +
                    "Time: " + time + "\n" +
                    "Thank you for reserving!";
            reservationDetailsArea.setText(reservationDetails);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RestaurantReservationSystem();
            }
        });
    }
}