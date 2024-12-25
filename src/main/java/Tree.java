import java.awt.*;

public class Tree implements Drawable {
    private final int x; // Позиция дерева
    private final int height; // Высота дерева

    public Tree(int x, int height) {
        this.x = x;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g2d, int panelHeight) {
        // Рисуем ствол
        g2d.setColor(new Color(140, 66, 26)); // Коричневый
        g2d.fillRect(x + 5, panelHeight - height, 30, 50);

        // Рисуем крону
        g2d.setColor(new Color(23, 96, 23)); // Темно-зеленый
        int[] xPoints = {x - 30, x + 65, x + 20};
        int[] yPoints = {panelHeight - height, panelHeight - height, panelHeight - height - 150};
        g2d.fillPolygon(xPoints, yPoints, 3);
    }
}