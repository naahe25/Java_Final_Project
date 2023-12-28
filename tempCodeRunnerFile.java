import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveDataGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Save Data");
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(10, 80, 80, 25);
        panel.add(saveButton);

        // Assuming CourseType is imported or fully qualified
        Student.CourseType defaultCourseType = Student.CourseType.MAJOR;

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get data from the GUI components
                String studentName = nameText.getText();

                // Create a Student object
                Student student = new Student();
                student.setStudentName(studentName);
                student.setCourseType(defaultCourseType);  // Use the appropriate value

                // Serialize and save the data
                DataSerialization.serializeData("student_data.ser", student);
            }
        });
    }
}
