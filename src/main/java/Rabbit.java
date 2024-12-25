import java.awt.*;

public class Rabbit implements Drawable {
    private int x; // Позиция по оси X

    public Rabbit(int startX) {
        this.x = startX;
    }

    public void move(int panelWidth) {
        x += 5;
        if (x > panelWidth) {
            x = -150; // Перемещаем зайца обратно, когда он выходит за пределы
        }
    }

    @Override
    public void draw(Graphics2D g2d, int panelHeight) {
        g2d.setColor(new Color(255, 255, 255));
        g2d.fillOval(x - 10, panelHeight - 140, 20, 20); // Хвост

        g2d.setColor(new Color(255, 152, 250));
        g2d.fillOval(x, panelHeight - 160, 70, 60); // Тело
        g2d.fillOval(x + 25, panelHeight - 200, 60, 50); // Голова
        g2d.fillOval(x + 28, panelHeight - 235, 20, 40); // Левое ухо
        g2d.fillOval(x + 48, panelHeight - 235, 20, 40); // Правое ухо
        g2d.fillOval(x + 60, panelHeight - 140, 20, 20); // Верхняя лапа
        g2d.fillOval(x + 35, panelHeight - 110, 45, 20); // Нижняя лапа

        // Рисуем глаз и нос
        g2d.setColor(new Color(0, 0, 0));
        g2d.fillOval(x + 65, panelHeight - 190, 7, 7); // Глаз
        g2d.setColor(new Color(171, 96, 166));
        g2d.fillOval(x + 80, panelHeight - 190, 9, 9); // Нос
    }
}