import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseSelection {

    public static void main(String[] args) {
        //  main frame
        JFrame frame = new JFrame("Course Selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // panel to hold the JList and button
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // list of courses
        String[] courses = {"Java", "Numerical Methods", "Data Communications and Network", "Financial Management", "Principles of Marketing", "Database Management System"};

        // Creating a JList with the courses array
        JList<String> courseList = new JList<>(courses);
        courseList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        courseList.setVisibleRowCount(8);

        // Adding the JList to a scroll pane
        JScrollPane scrollPane = new JScrollPane(courseList);
        panel.add(scrollPane, BorderLayout.CENTER);

        //  button to show selected courses
        JButton showSelectedButton = new JButton("Show Selected Courses");
        showSelectedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<String> selectedCourses = courseList.getSelectedValuesList();
                if (selectedCourses.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "No courses selected.");
                } else {
                    String message = "Selected Courses:\n" + String.join(", ", selectedCourses);
                    JOptionPane.showMessageDialog(frame, message);
                }
            }
        });

        // Adding the button to the panel and then panel to the frame
        panel.add(showSelectedButton, BorderLayout.SOUTH);

      
        frame.add(panel);

        // Setting the frame to be visible
        frame.setVisible(true);
    }
}
