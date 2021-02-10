package Components;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Models.TaskModel;
import Views.EditTask;

import javax.swing.BorderFactory;

public class Task extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JPanel taskTitle, taskDoneButton, taskEditButton;
    int TaskId;

    public Task(String TaskTitle, int TaskId) {
        this.TaskId = TaskId;
        setLayout(new GridLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        taskTitle = new JPanel();
        taskEditButton = new JPanel();
        taskDoneButton = new JPanel();

        taskTitle.setLayout(new GridBagLayout());
        taskEditButton.setLayout(new GridBagLayout());
        taskDoneButton.setLayout(new GridBagLayout());

        JLabel Title = new JLabel(TaskTitle);
        Title.setFont(new Font("Hack", Font.TYPE1_FONT, 25));
        taskTitle.add(Title);

        taskDoneButton.add(new Button("Done", new Color(0xDC3545), removeTask(TaskId)));

        taskEditButton.add(new Button("Edit", new Color(0xFFC107), editTask(TaskId)));

        add(taskTitle);
        add(taskDoneButton);
        add(taskEditButton);
    }

    private Runnable editTask(int taskId) {
        return new Runnable() {
            @Override
            public void run() {
                new EditTask(TaskId);
            }
        };
    }

    private Runnable removeTask(int taskId) {
        return new Runnable() {
            @Override
            public void run() {
                new TaskModel(taskId).destroy();
            }
        };
    }
}