import javax.swing.*;

public class LandscapeApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Landscape");
        Land land = new Land();
        frame.add(land);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        AnimationTimer timer = new AnimationTimer(land.getScene());
        timer.start();
    }
}