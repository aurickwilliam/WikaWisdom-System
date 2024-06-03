import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FlashCardCategory extends RoundedButton{
    Assets assets = new Assets();

    public FlashCardCategory(String category_name){
        setRadius(15);
        setBorder(null);
        setFocusable(false);
        setText(category_name);
        setPreferredSize(new Dimension(100, 75));
        setHorizontalAlignment(JButton.LEFT);
        setBorderColor(assets.getMainColorDarkGreen());
        setColor(assets.getMainColorDarkGreen());
        setColorClick(assets.getDarkGreenColorClick());
        setColorOver(assets.getDarkGreenColorOver());
        setFont(assets.getArialBold());
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setForeground(assets.getMainColorWhithy());
    }
}
