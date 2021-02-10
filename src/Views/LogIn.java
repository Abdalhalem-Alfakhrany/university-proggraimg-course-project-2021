package Views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import Components.Button;
import Components.InputGroup;
import Models.UsersModel;

public class LogIn extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    InputGroup userNameG, passwordG;
    Button login, regieter;
    View view;

    public LogIn() {
        setLayout(new GridLayout(3, 1));

        userNameG = new InputGroup("User Name:", false);
        passwordG = new InputGroup("Pass Word:", true);

        JPanel actions = new JPanel(new GridBagLayout());

        login = new Button("Log In", new Color(0x28A745), login());
        regieter = new Button("Register", new Color(0x343A40), register());

        actions.add(login);
        actions.add(regieter);

        add(userNameG);
        add(passwordG);
        add(actions);
        view = new View(this);
    }

    Runnable register() {
        return new Runnable() {
            @Override
            public void run() {
                view.setVisible(false);
                new Register();
            }
        };
    }

    Runnable login() {
        return new Runnable() {
            @Override
            public void run() {
                String username, password;

                username = userNameG.inputvalue();
                password = passwordG.inputvalue();

                if (new UsersModel().isExist(username, password)) {
                    view.setVisible(false);
                    new Index();
                }
            }
        };
    }
}