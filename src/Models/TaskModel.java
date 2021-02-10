package Models;

import java.io.File;

import javax.swing.JOptionPane;

import org.json.simple.JSONObject;

public class TaskModel extends Model {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String Title, Description, Deadline;
    private static File file = new File("src", "res/tasks-list.json");
    private JSONObject task;
    private boolean isExist = false;
    private int Id;

    public TaskModel() {
        super(file);
    }

    public TaskModel(int Id) {
        super(file);
        this.Id = Id;
        isExist = true;
        this.task = getTask(Id);
        setTitle((String) getTask().get("title"));
        setDescription((String) getTask().get("description"));
        setDeadline((String) getTask().get("deadline"));
    }

    public TaskModel(String title, String description, String deadline) {
        super(file);

        setTitle(title);
        setDescription(description);
        setDeadline(deadline);

        setTask();
    }

    public boolean save() {

        String title = getTitle(), description = getDescription(), deadline = getDeadline();

        if (title.equals("") || description.equals("") || deadline.equals("")) {
            JOptionPane.showMessageDialog(null, "pleas insert a valuable data");
            return false;
        }

        if (isExist)
            removeTask(Id);
        setTask();
        addObject(getTask());
        return true;
    }

    public JSONObject getTask() {
        return task;
    }

    public void setTask() {
        this.task = new JSONObject();
        this.task.put("title", getTitle());
        this.task.put("description", getDescription());
        this.task.put("deadline", getDeadline());
    }

    public void removeTask(int Id) {
        removeObject(Id);
    }

    public boolean destroy() {
        try {
            removeObject(Id);
            JOptionPane.showMessageDialog(null, "task removed succsesfly");
            return true;
        } catch (Exception e) {

        }
        return true;
    }

    public JSONObject getTask(int Id) {
        return (JSONObject) getAllData().get(Id);
    }

    public String getDeadline() {
        return (Deadline);
    }

    public void setDeadline(String deadline) {
        this.Deadline = deadline;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

}
