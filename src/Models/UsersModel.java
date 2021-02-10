package Models;

import java.io.File;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import javax.swing.JOptionPane;

public class UsersModel extends Model {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String Name, UserName, PassWord;
    private static File file = new File("src", "res/users.json");
    private JSONObject user;

    public UsersModel() {
        super(file);
    }

    public UsersModel(String name, String userName, String password) {
        super(file);

        setName(name);
        setPassword(password);
        setUserName(userName);

        setUser();
    }

    public boolean save() {
        String Name, UserName, PassWord;
        Name = getName();
        UserName = getUserName();
        PassWord = getPassWord();

        if (Name.equals("") || UserName.equals("") || PassWord.equals("")) {
            JOptionPane.showMessageDialog(null, "pleas insert valuble data");
            return false;
        }
        addObject(getUser());
        return true;
    }

    public Boolean isExist(String username, String password) {

        ArrayList<JSONObject> allusers = getAllData();

        for (JSONObject user : allusers) {
            if (user.get("userName").equals(username))
                if (user.get("password").equals(password))
                    return true;
                else
                    JOptionPane.showMessageDialog(null, "password is wrong try another one correct");
            else
                JOptionPane.showMessageDialog(null, "user name is wrong try another one correct");
        }
        return false;
    }

    public JSONObject getUser() {
        return user;
    }

    public void setUser() {
        this.user = new JSONObject();
        this.user.put("name", getName());
        this.user.put("userName", getUserName());
        this.user.put("password", getPassWord());
    }

    public String getPassWord() {
        return PassWord;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public void setPassword(String password) {
        this.PassWord = password;
    }

}
