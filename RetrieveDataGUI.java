import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RetrieveDataGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Retrieve Data");
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton retrieveButton = new JButton("Retrieve Data");
        retrieveButton.setBounds(10, 20, 150, 25);
        panel.add(retrieveButton);

        JTable dataTable = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Student Name");
        model.addColumn("Roll Number");
        model.addColumn("Subject");
        model.addColumn("Major");
        model.addColumn("Course Type");
        dataTable.setModel(model);

        JScrollPane scrollPane = new JScrollPane(dataTable);
        scrollPane.setBounds(10, 60, 350, 150);
        panel.add(scrollPane);

        retrieveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Deserialize and retrieve the data
                List<Student> studentList = (List<Student>) DataSerialization.deserializeData("student_data.ser");

                // Populate the JTable with retrieved data
                DefaultTableModel tableModel = (DefaultTableModel) dataTable.getModel();
                tableModel.setRowCount(0); // Clear existing rows

                for (Student student : studentList) {
                    Object[] rowData = {
                            student.getStudentName(),
                            student.getRollNumber(),
                            student.getSubject(),
                            student.getMajor(),
                            student.getCourseType()
                    };
                    tableModel.addRow(rowData);
                }
            }
        });
    }
}
