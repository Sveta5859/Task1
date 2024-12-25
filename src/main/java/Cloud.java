import java.awt.*;

public class Cloud implements Drawable{
    private int x; // Позиция облака по оси X
    private final int y = 100; // Позиция облака по оси Y (фиксированная)

    public Cloud(int startX) {
        this.x = startX;
    }

    // Метод для обновления позиции облака
    public void move(int panelWidth) {
        x += 2; // Скорость движения облака
        if (x > panelWidth) {
            x = -150; // Перемещаем облако обратно за левый край панели
        }
    }

    // Метод для отрисовки облака
    @Override
    public void draw(Graphics2D g2d, int panelHeight) {
        g2d.setColor(new Color(255, 255, 255)); // Цвет облака

        // Основные эллипсы для облака
        g2d.fillOval(x, y - 20, 60, 40); // Центральная часть
        g2d.fillOval(x - 30, y, 50, 30); // Левая часть
        g2d.fillOval(x + 40, y, 50, 30); // Правая часть
        g2d.fillOval(x + 10, y - 30, 50, 40); // Верхняя часть
    }
}