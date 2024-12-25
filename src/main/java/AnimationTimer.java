import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationTimer {
    private final Timer timer;

    public AnimationTimer(Scene scene) {
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scene.update();
            }
        });
    }

    public void start() {
        timer.start();
    }
}