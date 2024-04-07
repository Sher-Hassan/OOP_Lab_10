package application;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistrationForm extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameField, idField, emailField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JCheckBox termsCheckBox;
    private DefaultTableModel tableModel;

    public StudentRegistrationForm() {
        setTitle("Student Registration Form");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE); // Setting background color

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(6, 1));
        formPanel.setBackground(Color.WHITE); // Setting background color

        formPanel.add(createLabel("Name:", Color.BLACK)); // Setting label color
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(createLabel("ID:", Color.BLACK)); // Setting label color
        idField = new JTextField();
        formPanel.add(idField);

        formPanel.add(createLabel("Email:", Color.BLACK)); // Setting label color
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(createLabel("Gender:", Color.BLACK)); // Setting label color
        JPanel genderPanel = new JPanel();
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        genderPanel.setBackground(Color.WHITE); // Setting background color
        formPanel.add(genderPanel);

        formPanel.add(createLabel("Agree to Terms:", Color.BLACK)); // Setting label color
        termsCheckBox = new JCheckBox("I agree");
        termsCheckBox.setBackground(Color.WHITE); // Setting background color
        formPanel.add(termsCheckBox);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudentToTable();
            }
        });
        formPanel.add(submitButton);

        add(formPanel, BorderLayout.NORTH);

        // Table Panel
        tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("Name");
        tableModel.addColumn("ID");
        tableModel.addColumn("Email");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Agreed to Terms");

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBackground(Color.WHITE); // Setting background color
        add(tableScrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private JLabel createLabel(String text, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 14)); // Setting font
        label.setForeground(color); // Setting text color
        return label;
    }

    private void addStudentToTable() {
        String name = nameField.getText();
        String id = idField.getText();
        String email = emailField.getText();
        String gender = maleRadioButton.isSelected() ? "Male" : "Female";
        String agreedToTerms = termsCheckBox.isSelected() ? "Yes" : "No";
        Object[] rowData = {name, id, email, gender, agreedToTerms};
        tableModel.addRow(rowData);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentRegistrationForm();
            }
        });
    }
}
