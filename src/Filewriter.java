import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Filewriter extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel model;
    private JButton addButton, deleteButton;
    private List<Person> persons;
    private File file;

    public Filewriter() {
        super("Person List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        persons = new ArrayList<Person>();
        file = new File("persons.xls");

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Address");
        model.addColumn("Age");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        loadPersons();
        updateTable();
    }

    private void loadPersons() {
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    String name = parts[0];
                    String address = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    persons.add(new Person(name, address, age));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void savePersons() {
        try (FileWriter fw = new FileWriter(file)) {
            for (Person person : persons) {
                fw.write(person.getName() + "," + person.getAddress() + "," + person.getAge() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateTable() {
        model.setRowCount(0);
        for (Person person : persons) {
            model.addRow(new Object[] { person.getName(), person.getAddress(), person.getAge() });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            AddPersonDialog dialog = new AddPersonDialog(this);
            dialog.setVisible(true);
            if (dialog.isAddClicked()) {
                String name = dialog.getName();
                String address = dialog.getAddress();
                int age = dialog.getAge();
                persons.add(new Person(name, address, age));
                updateTable();
                savePersons();
            }
        } else if (e.getSource() == deleteButton) {
            int[] selectedRows = table.getSelectedRows();
            Arrays.sort(selectedRows);
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                persons.remove(selectedRows[i]);
            }
            updateTable();
            savePersons();
        }
    }

    public static void main(String[] args) {
        Filewriter frame = new Filewriter();
        frame.setVisible(true);
    }
}

class Person {
    private String name;
    private String address;
    private int age;

    public Person(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }
}

class AddPersonDialog extends JDialog {
    private JTextField nameField, addressField, ageField;
    private JButton addButton, cancelButton;
    private boolean isAddClicked;

    public AddPersonDialog(JFrame parent) {
        super(parent, "Add Person", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Address:"));
        addressField = new JTextField();
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isAddClicked = true;
                dispose();
            }
        });
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public String getName() {
        return nameField.getText();
    }

    public String getAddress() {
        return addressField.getText();
    }

    public int getAge() {
        try {
            return Integer.parseInt(ageField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public boolean isAddClicked() {
        return isAddClicked;
    }
}