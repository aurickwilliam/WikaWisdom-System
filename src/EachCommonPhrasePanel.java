import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EachCommonPhrasePanel extends RoundedButton{
    Assets assets = new Assets();
    public EachCommonPhrasePanel(String phrase){
        setRadius(15);
        setColor(assets.getMainColorDarkGreen());
        setBorder(null);
        setText(phrase);
        setFocusable(false);
        setColorClick(assets.getDarkGreenColorClick());
        setColorOver(assets.getDarkGreenColorOver());
        setBorderColor(assets.getMainColorDarkGreen());
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setFont(assets.getArial());
        setForeground(assets.getMainColorWhithy());
        setHorizontalAlignment(JButton.LEFT);
    }
}
