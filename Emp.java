import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class Emp extends JFrame {
    //declaring components variables
    JLabel employeeIdentification;
    JTextField employeeIdentificationJTextField;
    JLabel employeeNumber;
    JTextField employeeNumberJTextField;
    JLabel employeeName;
    JTextField employeeNameJTextField;
    JLabel employeeYearsOfWork;
    JTextField employeeYearsOfWorkJTextField;
    JButton deleteButton;
    JButton insertButton;
    JButton displayButton;
    JTextArea resultsJTextArea;
    //keep track of the previously read line
    private int targetLine;
    //array of a maximum of 2000 Records
    private Queue<Record> records;

    public Emp() {
        setSize(new Dimension(400, 400));
        JLabel titleLabel = new JLabel("Update Program");
        Container container = getContentPane();
        //add the labels, buttons, and text fields
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        targetLine = 0;
        records = new LinkedList<>();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        container.setLayout(gridBagLayout);
        employeeIdentification = new JLabel("Employee Identification");
        employeeIdentificationJTextField = new JTextField();
        employeeNumber = new JLabel("Telephone Number");
        employeeNumberJTextField = new JTextField();
        employeeName = new JLabel("Employee Name");
        employeeNameJTextField = new JTextField();
        employeeYearsOfWork = new JLabel("Years of Work");
        employeeYearsOfWorkJTextField = new JTextField();
        deleteButton = new JButton("Delete");
        insertButton = new JButton("Insert Data");
        displayButton = new JButton("Display");
        resultsJTextArea = new JTextArea();
        gbc.weightx = 0.0;
        gbc.gridwidth = 3;
        container.add(titleLabel, gbc);
        gbc.weightx = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy++;
        container.add(employeeIdentification, gbc);
        gbc.gridx = 1;
        container.add(employeeIdentificationJTextField, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        container.add(employeeNumber, gbc);
        gbc.gridx = 1;
        container.add(employeeNumberJTextField, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        container.add(employeeName, gbc);
        gbc.gridx = 1;
        container.add(employeeNameJTextField, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        container.add(employeeYearsOfWork, gbc);
        gbc.gridx = 1;
        container.add(employeeYearsOfWorkJTextField, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        container.add(insertButton, gbc);
        gbc.gridx = 1;
        container.add(deleteButton, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        container.add(displayButton, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.weightx = 0.0;
        gbc.gridwidth = 3;
        gbc.ipady = 60;
        container.add(resultsJTextArea, gbc);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!records.isEmpty()) {
                    Record record = records.remove();
                }
            }
        });
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRecord();
            }
        });
        //display the employees records
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String results = "";
//                for (int i = 0; i < 2000; i++) {
//                    Record record = records[i];
//                    if (record != null) {
//                        results = results + record + "\n";
//                    }
//                }
                resultsJTextArea.setText(records.toString());
            }
        });
    }

    public static void main(String[] args) {
        Emp updateEmp = new Emp();
        updateEmp.setVisible(true);
    }

    /**
     * Update the current record and add it to the array
     */
    private void updateRecord() {
        int empId = -1;
        boolean hasError = false;
        try {
            empId = Integer.parseInt(employeeYearsOfWorkJTextField.getText());
        } catch (NumberFormatException e) {
            hasError = true;
            JOptionPane.showMessageDialog(this, "Employee id must be integer");
        }
        String telephone = employeeNumberJTextField.getText();
        String name = employeeNameJTextField.getText();
        int years = -1;
        try {
            years = Integer.parseInt(employeeYearsOfWorkJTextField.getText());
        } catch (NumberFormatException e) {
            hasError = true;
            JOptionPane.showMessageDialog(this, "Years of works must be an integer");
        }
        if (!hasError) {
            records.add(new Record(empId,  telephone, name, years));
        }
    }
    public class Record {
        private int empId;
        private String telephone;
        private String name;
        private int years;
        public Record() {

        }
        public Record(int e, String t, String n, int y) {
            empId = e;
            telephone = t;
            name = n;
            years = y;
        }

        public void setEmpId(int empId) {
            this.empId = empId;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public void setYears(int years) {
            this.years = years;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getEmpId() {
            return empId;
        }

        public String getTelephone() {
            return telephone;
        }

        public int getYears() {
            return years;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "empId = " + empId +
                    " telephone = " + telephone +
                    " name = " + name +
                    " years = " + years;
        }
    }

}
