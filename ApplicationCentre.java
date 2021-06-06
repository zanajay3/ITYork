import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ApplicationCentre extends JApplet implements ActionListener {
	private JButton inputButton;
	private JButton displayAllButton;
	private JButton searchButton;
	private JButton[] controls;
	private Container mainContainer;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel inputPanel;
	private Student[] students;
	private int numberOfStudentEntered;
	private CardLayout cardManager;
	private JTextArea studentsJTextArea;
	private static final int NUMBER_OF_STUDENT_ALLOWED = 100;

	public void init() {
		students = new Student[NUMBER_OF_STUDENT_ALLOWED];
		numberOfStudentEntered = 0;
		// setTitle("ApplicationCentre");
		// width = 700 pixels and the height = 500 pixels
		setSize(new Dimension(700, 500));
		mainContainer = getContentPane();
		mainContainer.setLayout(new BorderLayout());
		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(3, 1, 2, 2));
		rightPanel = new JPanel();
		cardManager = new CardLayout(2, 2);
		rightPanel.setLayout(cardManager);

		controls = new JButton[3];
		inputButton = new JButton("Input");
		controls[0] = inputButton;
		displayAllButton = new JButton("Display All");
		controls[1] = displayAllButton;
		searchButton = new JButton("Search");
		controls[2] = searchButton;
		leftPanel.add(inputButton);
		leftPanel.add(displayAllButton);
		leftPanel.add(searchButton);

		inputPanel = new InputPanel(new GridBagLayout());
		rightPanel.add(inputPanel, "input");
		rightPanel.add(createDisplayPanel(), "displayAll");
		rightPanel.add(getSearchPanel(), "search");
		inputButton.addActionListener(this);
		displayAllButton.addActionListener(this);
		searchButton.addActionListener(this);
		mainContainer.add(leftPanel, BorderLayout.WEST);
		mainContainer.add(rightPanel, BorderLayout.CENTER);
	}

	private class InputPanel extends JPanel implements ActionListener {
		private JList<String> universitiesJList;
		private JButton submitButton;
		private JLabel numberOfStudentsLabel;
		private String[] universities = new String[] { "Toronto", "York", "Brock", "Guelph", "Waterloo", "McGill",
				"Concordia", "Laval", "Macmaster", "Western" };
		private int[] universitiesAverages = new int[] { 90, 84, 75, 76, 88, 90, 76, 78, 82, 80 };
		private JTextField studentNameTextField;
		private JTextField averageMarkTextField;

		public InputPanel(LayoutManager layout) {
			super(layout);
			// setPreferredSize(new Dimension(100, 500));
			JLabel studentNameLabel = new JLabel("Enter student's name:");
			studentNameTextField = new JTextField();
			JLabel averageMarkLabel = new JLabel("Enter average mark:");
			averageMarkTextField = new JTextField();
			JLabel universitySelect = new JLabel("From the List below choose 3 universities");
			String[] data = universities;
			universitiesJList = new JList<>(data); // data has type Object[]
			universitiesJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			universitiesJList.setLayoutOrientation(JList.VERTICAL_WRAP);
			universitiesJList.setVisibleRowCount(-1);
			JScrollPane listScroller = new JScrollPane(universitiesJList);
			listScroller.setPreferredSize(new Dimension(400, 200));
			submitButton = new JButton("Submit");
			submitButton.addActionListener(this);
			numberOfStudentsLabel = new JLabel();
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.insets = new Insets(0, 0, 0, 0);
			gbc.weightx = 1;
			gbc.weighty = 0.5;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			this.add(studentNameLabel, gbc);
			this.add(studentNameTextField, gbc);
			this.add(averageMarkLabel, gbc);
			this.add(averageMarkTextField, gbc);
			this.add(universitySelect, gbc);
			gbc.weighty = 1;
			this.add(listScroller, gbc);
			this.add(submitButton, gbc);
			this.add(numberOfStudentsLabel, gbc);
			displayNumberOfStudents();
		}

		private void displayNumberOfStudents() {
			numberOfStudentsLabel.setText("student " + numberOfStudentEntered + " out of " + NUMBER_OF_STUDENT_ALLOWED);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == submitButton) {
				String name = studentNameTextField.getText().trim();
				String averageStr = averageMarkTextField.getText().trim();
				List<String> universities = universitiesJList.getSelectedValuesList();
				int[] universitiesIndices = universitiesJList.getSelectedIndices();
				double average = 0;
				boolean hasError = false;
				// validate name
				if (name.length() == 0) {
					JOptionPane.showMessageDialog(this, "Enter name");
				} else {
					// validate average
					try {
						average = Double.parseDouble(averageStr);
						if (average < 0) {
							hasError = true;
						}
					} catch (NumberFormatException ee) {
						hasError = true;
					}
					if (hasError) {
						JOptionPane.showMessageDialog(this, "Enter a valid average");
					} else if (universities.size() != 3) {
						JOptionPane.showMessageDialog(this, "Select at least three universities");
						hasError = true;
					} else {
						for (int i = 0; i < universitiesIndices.length; i++) {
							if (average < universitiesAverages[i]) {
								JOptionPane.showMessageDialog(this, "Student does not qualify for admission in "
										+ universities.get(i) + " university");
								hasError = true;
							}
						}
					}
				}
				if (!hasError) {
					String[] selected = new String[3];
					for (int i = 0; i < universities.size(); i++) {
						selected[i] = universities.get(i);
					}
					students[numberOfStudentEntered] = new Student(name, average, selected);
					numberOfStudentEntered++;
					displayNumberOfStudents();
					universitiesJList.clearSelection();
					studentNameTextField.setText("");
					averageMarkTextField.setText("");
				}
			}
		}
	}

	/**
	 * This method creates and displays Display JPanel
	 * 
	 * @return a new JPanel
	 */
	private JPanel createDisplayPanel() {
		JPanel displayJPanel = new JPanel();
		displayJPanel.setLayout(new BorderLayout());
		studentsJTextArea = new JTextArea();
		studentsJTextArea.setEditable(false);
		// Serif style font in Italic and 12-point size
		studentsJTextArea.setFont(new Font(Font.SERIF, Font.ITALIC, 12));
		displayJPanel.add(studentsJTextArea);
		return displayJPanel;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// show first card
		if (event.getSource() == controls[0]) {
			cardManager.show(rightPanel, "input");
		}
		// show next card
		else if (event.getSource() == controls[1]) {
			cardManager.show(rightPanel, "displayAll");
			sortAndDisplayStudents();
		}
		// show last card
		else if (event.getSource() == controls[2]) {
			cardManager.show(rightPanel, "search");
		}
	}

	/**
	 * This method sorts and displays the students already added
	 */
	private void sortAndDisplayStudents() {
		// sort the students
		sortStudents();
		// display the students information
		String results = "";
		for (int i = 0; i < numberOfStudentEntered; i++) {
			Student current = students[i];
			results = results + current + "\n";
		}
		System.out.println(results);
		studentsJTextArea.setText(results);
	}

	/**
	 * This method creates the search JPanel
	 * 
	 * @return a new JPanel
	 */
	private JPanel getSearchPanel() {
		JLabel studentNameLabel = new JLabel("Enter student’s name");
		JTextField studentNameField = new JTextField("");
		JPanel searchCard = new JPanel(new GridLayout(3, 1));
		JTextArea searchTextArea = new JTextArea();
		searchTextArea.setPreferredSize(new Dimension(200, 50));
		searchTextArea.setEditable(false);
		// Arial style font in Plain and 14-point size
		searchTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
		searchCard.add(studentNameLabel);
		searchCard.add(studentNameField);
		searchCard.add(searchTextArea);
		studentNameField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				searchAddDisplay(studentNameField.getText(), searchTextArea);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				searchAddDisplay(studentNameField.getText(), searchTextArea);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				System.out.println("changedUpdate");
			}
		});
		return searchCard;
	}

	/**
	 * This method searches the student with the name passed and displays it in the
	 * TextArea if found
	 * 
	 * @param name           the name of the student
	 * @param searchTextArea TextArea to display the student
	 */
	private void searchAddDisplay(String name, JTextArea searchTextArea) {
		boolean found = false;
		for (int i = 0; i < numberOfStudentEntered; i++) {
			Student current = students[i];
			if (current.getStudentName().equalsIgnoreCase(name)) {
				searchTextArea.setText(current.toString());
				found = true;
			}
		}
		if (!found) {// not found
			searchTextArea.setText("Student not found");
		}
	}

	/**
	 * This method sorts the array of student in ascending order of the names
	 */
	private void sortStudents() {
		int n = numberOfStudentEntered;
		Student temp;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				// compare students using the names
				if (students[j - 1].getStudentName().compareTo(students[j].getStudentName()) > 0) {
					// swap the students
					temp = students[j - 1];
					students[j - 1] = students[j];
					students[j] = temp;
				}

			}
		}
	}
}