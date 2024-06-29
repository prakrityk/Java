import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementSystem {

    public static void main(String[] args) {
       
        JFrame frame = new JFrame("Student Management System");
      
        frame.setSize(400, 300);

        // creating a tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // creating panels for each tab
        JPanel studentInfoPanel = new JPanel();
        JPanel coursesPanel = new JPanel();
        JPanel gradesPanel = new JPanel();

        // Student Information Tab (Tab 1)
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

        //Courses (tab 2)
        coursesPanel.setLayout(new BorderLayout());

        JLabel courseListLabel = new JLabel("Course List", JLabel.CENTER);
        String[] courses = {"Math", "Science", "History", "Art", "Physical Education"};
        JList<String> courseList = new JList<>(courses);

        coursesPanel.add(courseListLabel, BorderLayout.NORTH);
        coursesPanel.add(new JScrollPane(courseList), BorderLayout.CENTER);

        // Grades Tab(tab 3)
        gradesPanel.setLayout(new BorderLayout());

        JLabel enterGradesLabel = new JLabel("Enter Grades", JLabel.CENTER);
        JTextArea gradesArea = new JTextArea(10, 30);
       
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

        //adding panels to the respective tabbed panes
        tabbedPane.addTab("Student Information", studentInfoPanel);
        tabbedPane.addTab("Courses", coursesPanel);
        tabbedPane.addTab("Grades", gradesPanel);

        //adding the tabbed pane to the frame
        frame.add(tabbedPane);

      //frame should be set as visible
        frame.setVisible(true);
    }
}
