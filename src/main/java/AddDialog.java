import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDialog extends JDialog {
    private final Scene scene;
    private final JCheckBox addTreesCheckBox;
    private final JCheckBox addCloudsCheckBox;
    private final JCheckBox addRabbitCheckBox;

    public AddDialog(JFrame owner, Scene scene) {
        super(owner, "Добавить элементы", true);
        this.scene = scene;
        setSize(300, 200);
        setLocationRelativeTo(owner);
        setLayout(new FlowLayout());

        addTreesCheckBox = new JCheckBox("Деревья");
        addCloudsCheckBox = new JCheckBox("Облака");
        addRabbitCheckBox = new JCheckBox("Заяц");

        JButton addButton = new JButton("Добавить");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addTreesCheckBox.isSelected()) {
                    if (!scene.getDrawTrees()){
                        int treeSpacing = 300;
                        for (int i = 0; i < 1000; i += treeSpacing) {
                            scene.addDrawable(new Tree(100 + i, 150));
                        }
                    }
                    scene.setDrawTrees(true);
                }
                if (addCloudsCheckBox.isSelected()) {
                    scene.setDrawClouds(true);
                }
                if (addRabbitCheckBox.isSelected()) {
                    scene.setDrawRabbit(true);
                }
                scene.repaint();
                dispose();
            }
        });

        add(addTreesCheckBox);
        add(addCloudsCheckBox);
        add(addRabbitCheckBox);
        add(addButton);

        setVisible(true);
    }
}