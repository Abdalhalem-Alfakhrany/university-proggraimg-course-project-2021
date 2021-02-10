package Views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import Components.Button;
import Components.InputGroup;
import Models.UsersModel;

public class Register extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    InputGroup userNameG, NameG, passWordG;
    Button submit;
    View view;

    public Register() {

        setLayout(new GridLayout(5, 1));

        userNameG = new InputGroup("name", false);
        NameG = new InputGroup("user name", false);
        passWordG = new InputGroup("pass word", true);
        submit = new Button("submit", new Color(0x28A745), register());

        add(userNameG);
        add(NameG);
        add(passWordG);
        add(submit);

        view = new View(this);
    }

    Runnable register() {
        return new Runnable() {
            @Override
            public void run() {
                String name, userName, passWord;

                name = NameG.inputvalue();
                userName = userNameG.inputvalue();
                passWord = passWordG.inputvalue();

                UsersModel newuser = new UsersModel(name, userName, passWord);
                if (newuser.save()) {
                    view.setVisible(false);
                    new Index();
                }
            }
        };
    }
}
