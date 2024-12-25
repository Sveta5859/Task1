import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Scene extends JPanel {
    private final List<Drawable> drawables = new ArrayList<>();

    private boolean drawTrees = false;
    private boolean drawClouds = false;
    private boolean drawRabbit = false;

    private final Cloud cloud;
    private final Rabbit rabbit;

    public Scene() {
        cloud = new Cloud(50); // Исправлено: убрали лишний параметр
        rabbit = new Rabbit(50);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        drawSky(g2d);
        drawGrass(g2d);

        if (drawTrees) {
            for (Drawable drawable : drawables) {
                if(drawable instanceof Tree)
                    drawable.draw(g2d, getHeight());
            }
        }

        if (drawClouds) {
            cloud.draw(g2d, getHeight());
        }

        if (drawRabbit) {
            rabbit.draw(g2d, getHeight());
        }
    }

    private void drawSky(Graphics2D g2d) {
        g2d.setColor(new Color(128, 172, 213)); // Голубой
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    private void drawGrass(Graphics2D g2d) {
        g2d.setColor(new Color(34, 139, 34)); // Зеленый
        g2d.fillRect(0, getHeight() - 100, getWidth(), 100);
    }


    public void update() {
        if(drawClouds)
            cloud.move(getWidth());
        if(drawRabbit)
            rabbit.move(getWidth());
        repaint();
    }



    public void addDrawable(Drawable drawable) {
        drawables.add(drawable);
    }

    public void removeDrawable(Drawable drawable) {
        drawables.remove(drawable);
    }


    public void setDrawTrees(boolean drawTrees) {
        this.drawTrees = drawTrees;
    }

    public void setDrawClouds(boolean drawClouds) {
        this.drawClouds = drawClouds;
    }

    public void setDrawRabbit(boolean drawRabbit) {
        this.drawRabbit = drawRabbit;
    }


    public boolean getDrawTrees() {
        return drawTrees;
    }

    public boolean getDrawClouds() {
        return drawClouds;
    }

    public boolean getDrawRabbit() {
        return drawRabbit;
    }
    public void clearTrees(){
        drawables.clear();
        repaint();
    }
}