import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveDialog extends JDialog {
    private final Scene scene;
    private final JCheckBox removeTreesCheckBox;
    private final JCheckBox removeCloudsCheckBox;
    private final JCheckBox removeRabbitCheckBox;

    public RemoveDialog(JFrame owner, Scene scene) {
        super(owner, "Удалить элементы", true);
        this.scene = scene;
        setSize(300, 200);
        setLocationRelativeTo(owner);
        setLayout(new FlowLayout());

        removeTreesCheckBox = new JCheckBox("Деревья");
        removeCloudsCheckBox = new JCheckBox("Облака");
        removeRabbitCheckBox = new JCheckBox("Заяц");


        JButton removeButton = new JButton("Удалить");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(removeTreesCheckBox.isSelected()){
                    scene.clearTrees();
                    scene.setDrawTrees(false);
                }
                if (removeCloudsCheckBox.isSelected()) {
                    scene.setDrawClouds(false);
                }
                if (removeRabbitCheckBox.isSelected()) {
                    scene.setDrawRabbit(false);
                }
                scene.repaint();
                dispose();
            }
        });
        add(removeTreesCheckBox);
        add(removeCloudsCheckBox);
        add(removeRabbitCheckBox);
        add(removeButton);

        setVisible(true);
    }
}