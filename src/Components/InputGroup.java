package Components;

import java.awt.GridBagLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InputGroup extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public JTextField InputField;
    public JLabel Label;

    public InputGroup(String labelstr, boolean passOrNot) {
        setLayout(new GridBagLayout());

        InputField = (passOrNot) ? new JPasswordField() : new JTextField();
        InputField.setColumns(20);
        InputField.setFont(new Font("Hack", Font.TYPE1_FONT, 25));

        Label = new JLabel(labelstr);
        Label.setFont(new Font("Hack", Font.TYPE1_FONT, 25));

        add(Label);
        add(InputField);
    }

    public String inputvalue() {
        return this.InputField.getText();
    }
}
