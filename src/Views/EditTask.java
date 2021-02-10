package Views;

import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Components.Button;
import Components.InputGroup;
import Models.TaskModel;

public class EditTask extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    InputGroup TitleG, DeadLineG;
    JPanel DescriptionG;
    JTextArea descriptiontTextArea = new JTextArea(10, 50);
    Button submit;
    View view;

    public EditTask(int Id) {
        setLayout(new GridLayout(4, 1));

        TitleG = new InputGroup("title", false);
        DeadLineG = new InputGroup("dead line", false);
        DescriptionG = descriptionG();

        submit = new Button("submit", new Color(0x28A745), edittask(Id));

        setValues(Id);

        add(TitleG);
        add(DeadLineG);
        add(DescriptionG);
        add(submit);

        view = new View(this);
    }

    void setValues(int Id) {
        TaskModel data = new TaskModel(Id);

        TitleG.InputField.setText(data.getTitle());
        DeadLineG.InputField.setText(data.getDeadline());
        descriptiontTextArea.setText(data.getDescription());
    }

    JPanel descriptionG() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));

        JLabel descriptionLabel = new JLabel("description");
        descriptionLabel.setFont(new Font("Hack", Font.TYPE1_FONT, 25));
        JScrollPane scrollPane = new JScrollPane();
        descriptiontTextArea = new JTextArea(10, 50);
        descriptiontTextArea.setFont(new Font("Hack", Font.TYPE1_FONT, 20));
        scrollPane.setViewportView(descriptiontTextArea);

        GridBagConstraints Constraints = new GridBagConstraints();

        panel.add(descriptionLabel, Constraints);
        panel.add(scrollPane, Constraints);

        return panel;
    }

    Runnable edittask(int Id) {
        return new Runnable() {
            @Override
            public void run() {

                String title, deadline, description;

                title = TitleG.inputvalue();
                deadline = DeadLineG.inputvalue();
                description = descriptiontTextArea.getText();

                TaskModel task = new TaskModel(Id);

                task.setTitle(title);
                task.setDeadline(deadline);
                task.setDescription(description);

                if (task.save()) {
                    view.setVisible(false);
                    new Index();
                }
            }
        };
    }
}
