import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveDataGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Save Data");
        frame.setSize(300, 250);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(10, 20, 100, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(120, 20, 165, 25);
        panel.add(nameText);

        JLabel rollLabel = new JLabel("Roll Number:");
        rollLabel.setBounds(10, 50, 100, 25);
        panel.add(rollLabel);

        JTextField rollText = new JTextField(20);
        rollText.setBounds(120, 50, 165, 25);
        panel.add(rollText);

        JLabel subjectLabel = new JLabel("Subject:");
        subjectLabel.setBounds(10, 80, 80, 25);
        panel.add(subjectLabel);

        JTextField subjectText = new JTextField(20);
        subjectText.setBounds(120, 80, 165, 25);
        panel.add(subjectText);

        JLabel majorLabel = new JLabel("Major:");
        majorLabel.setBounds(10, 110, 80, 25);
        panel.add(majorLabel);

        JTextField majorText = new JTextField(20);
        majorText.setBounds(120, 110, 165, 25);
        panel.add(majorText);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(10, 150, 80, 25);
        panel.add(saveButton);

        // Assuming CourseType is imported or fully qualified
        Student.CourseType defaultCourseType = Student.CourseType.MAJOR;

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get data from the GUI components
                String studentName = nameText.getText();
                String rollNumber = rollText.getText();
                String subject = subjectText.getText();
                String major = majorText.getText();

                // Create a Student object
                Student student = new Student(studentName, rollNumber, subject, major, defaultCourseType);

                // Serialize and save the data
                DataSerialization.serializeData("student_data.ser", student);
            }
        });
    }
}
