package Components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Button extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public JButton button;

    public Button(String lable, Color color, Runnable callback) {

        button = new JButton(lable);

        button.setFont(new Font("Hack", Font.TYPE1_FONT, 25));
        button.setBackground(color);
        button.setForeground(Color.WHITE);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callback.run();
            }
        });

        add(button);
    }
}
