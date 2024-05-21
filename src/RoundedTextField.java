import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedTextField extends JTextField {
    private Shape shape;
    private int radiusSize;
    private Color borderColor;
    public RoundedTextField(int radiusSize) {
        this.radiusSize = radiusSize;
        setOpaque(false);
    }
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, radiusSize, radiusSize);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(getBorderColor());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radiusSize, radiusSize);
    }
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, radiusSize, radiusSize);
        }
        return shape.contains(x, y);
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
}