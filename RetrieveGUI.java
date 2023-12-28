import javax.swing.*;
import java.awt.*;

public class RetrieveGUI {
    public static void main(String[] args) {
        // Retrieve and deserialize the data
        Object obj = DataSerialization.deserializeData("student_data.txt");

        if (obj instanceof Student) {
            Student student = (Student) obj;

            // Create and configure the GUI frame
            JFrame frame = new JFrame("Retrieve Data");
            frame.setSize(300, 250);

            JPanel panel = new JPanel();
            frame.add(panel);
            placeComponents(panel, student);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } else {
            // Handle the case where deserialization fails or the object is not a Student
            JOptionPane.showMessageDialog(null, "Error: Unable to retrieve student data");
        }
    }

    private static void placeComponents(JPanel panel, Student student) {
        panel.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Student Name:");
        JTextField nameText = new JTextField(student.getStudentName());
        nameText.setEditable(false);

        JLabel rollLabel = new JLabel("Roll Number:");
        JTextField rollText = new JTextField(student.getRollNumber());
        rollText.setEditable(false);

        JLabel subjectLabel = new JLabel("Subject:");
        JTextField subjectText = new JTextField(student.getSubject());
        subjectText.setEditable(false);

        JLabel majorLabel = new JLabel("Major:");
        JTextField majorText = new JTextField(student.getMajor());
        majorText.setEditable(false);

        JLabel courseTypeLabel = new JLabel("Course Type:");
        JTextField courseTypeText = new JTextField(student.getCourseType().toString());
        courseTypeText.setEditable(false);

        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(rollLabel);
        panel.add(rollText);
        panel.add(subjectLabel);
        panel.add(subjectText);
        panel.add(majorLabel);
        panel.add(majorText);
        panel.add(courseTypeLabel);
        panel.add(courseTypeText);
    }
}
