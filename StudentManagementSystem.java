import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementSystem {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Student Management System");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create panels for each tab
        JPanel studentInfoPanel = new JPanel();
        JPanel coursesPanel = new JPanel();
        JPanel gradesPanel = new JPanel();

        // --- Student Information Tab ---
        studentInfoPanel.setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String age = ageField.getText();
                JOptionPane.showMessageDialog(frame, "Name: " + name + "\nAge: " + age);
            }
        });

        studentInfoPanel.add(nameLabel);
        studentInfoPanel.add(nameField);
        studentInfoPanel.add(ageLabel);
        studentInfoPanel.add(ageField);
        studentInfoPanel.add(new JLabel()); // Empty cell
        studentInfoPanel.add(saveButton);

        // --- Courses Tab ---
        coursesPanel.setLayout(new BorderLayout());

        JLabel courseListLabel = new JLabel("Course List", JLabel.CENTER);
        String[] courses = {"Math", "Science", "History", "Art", "Physical Education"};
        JList<String> courseList = new JList<>(courses);

        coursesPanel.add(courseListLabel, BorderLayout.NORTH);
        coursesPanel.add(new JScrollPane(courseList), BorderLayout.CENTER);

        // --- Grades Tab ---
        gradesPanel.setLayout(new BorderLayout());

        JLabel enterGradesLabel = new JLabel("Enter Grades", JLabel.CENTER);
        JTextArea gradesArea = new JTextArea(10, 30);
        // gradesArea.setLineWrap(true);
        // gradesArea.setWrapStyleWord(true);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String grades = gradesArea.getText();
                JOptionPane.showMessageDialog(frame, "Entered Grades:\n" + grades);
            }
        });

        gradesPanel.add(enterGradesLabel, BorderLayout.NORTH);
        gradesPanel.add(new JScrollPane(gradesArea), BorderLayout.CENTER);
        gradesPanel.add(submitButton, BorderLayout.SOUTH);

        // Add panels to the tabbed pane
        tabbedPane.addTab("Student Information", studentInfoPanel);
        tabbedPane.addTab("Courses", coursesPanel);
        tabbedPane.addTab("Grades", gradesPanel);

        // Add the tabbed pane to the frame
        frame.add(tabbedPane);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}
