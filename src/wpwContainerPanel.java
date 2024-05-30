import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class wpwContainerPanel extends RoundedButton{
    Assets assets = new Assets();

    // JLabel
    private static JLabel fil;
    private static JLabel eng;

    public wpwContainerPanel(String filWord, String engWord){
        setRadius(15);
        setLayout(new GridLayout(1, 3));
        setFocusable(false);
        setBorder(null);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setColor(assets.getMainColorDarkGreen());
        setColorOver(assets.getDarkGreenColorOver());
        setColorClick(assets.getDarkGreenColorClick());
        setBorderColor(assets.getMainColorDarkGreen());

        RoundedPanel filPanel = new RoundedPanel(10, 10, 10, 10);
        filPanel.setBackground(assets.getMainColorWhiteBG());
        add(filPanel);

        fil = new JLabel(filWord);
        fil.setFont(assets.getArialBold());
        fil.setForeground(assets.getMainColorBlackTxt());
        filPanel.add(fil);

        JLabel equalSign = new JLabel("=");
        equalSign.setForeground(assets.getMainColorWhithy());
        equalSign.setFont(assets.getArialBold());
        equalSign.setHorizontalAlignment(JLabel.CENTER);
        add(equalSign);

        RoundedPanel engPanel = new RoundedPanel(10, 10, 10, 10);
        engPanel.setBackground(assets.getMainColorWhiteBG());
        add(engPanel);

        eng = new JLabel(engWord);
        eng.setFont(assets.getArialBold());
        eng.setForeground(assets.getMainColorBlackTxt());
        engPanel.add(eng);

    }
}
