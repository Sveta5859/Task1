import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Land extends JPanel implements ActionListener {
    private final Scene scene;
    private final Timer timer;

    private final JButton addButton;
    private final JButton removeButton;


    public Land() {
        scene = new Scene();
        setLayout(new BorderLayout());

        timer = new Timer(50, this);
        timer.start();

        // Создание кнопок
        addButton = new JButton("Добавить элементы");
        removeButton = new JButton("Удалить элементы");
        // Настройка кнопок
        addButton.addActionListener(this);
        removeButton.addActionListener(this);



        // Панель для кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        // Размещаем кнопки в нижней части окна
        add(scene, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            scene.update();
            return;
        }

        if (e.getSource() == addButton) {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            new AddDialog(frame,scene);

        }
        else if (e.getSource() == removeButton) {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            new RemoveDialog(frame, scene);
        }
    }

    public Scene getScene(){
        return scene;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Landscape");
        Land panel = new Land();
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}