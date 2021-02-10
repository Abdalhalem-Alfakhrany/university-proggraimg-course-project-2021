package Views;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.json.simple.JSONObject;

import java.awt.GridBagConstraints;

import Components.Button;
import Components.Task;

import Models.TaskModel;

public class Index extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    GridBagConstraints Constraints = new GridBagConstraints();
    View view;

    public Index() {

        setLayout(new GridBagLayout());

        Constraints.gridheight = GridBagConstraints.RELATIVE;
        Constraints.gridwidth = GridBagConstraints.RELATIVE;

        setConstraint(0, 0, 0, 0, GridBagConstraints.HORIZONTAL);

        JPanel newtaskPanel = new JPanel(new FlowLayout());
        newtaskPanel.add(new Button("Add New Task", new Color(0x343A40), AddNewTask()));
        add(newtaskPanel, Constraints);

        setConstraint(0, 1, 1, 1, GridBagConstraints.BOTH);
        add(allTasks(), Constraints);

        view = new View(this);
    }

    Runnable AddNewTask() {
        return new Runnable() {
            @Override
            public void run() {
                view.setVisible(false);
                new CreateTask();
            }
        };
    }

    void setConstraint(int gridx, int gridy, int weightx, int weighty, int fillOption) {
        Constraints.gridx = gridx;
        Constraints.gridy = gridy;
        Constraints.weightx = weightx;
        Constraints.weighty = weighty;
        Constraints.fill = fillOption;
    }

    JPanel allTasks() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ArrayList<JSONObject> alltasks = new TaskModel().getAllData();

        for (int i = 0; i < alltasks.size(); i++) {
            String title = (String) alltasks.get(i).get("title");
            panel.add(new Task(title, i));
        }

        return panel;
    }

}
