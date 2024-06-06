import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Level extends RoundedButton{
    Assets assets = new Assets();

    public static JLabel score_title;

    public Level(String name, int index, int isComplete, String score){
        setRadius(20);
        setBorder(null);
        setFocusable(false);
        setPreferredSize(new Dimension(0, 100));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setHorizontalAlignment(JButton.LEFT);
        setLayout(new BorderLayout());

        JPanel textPanel = new JPanel();
        textPanel.setBackground(null);
        textPanel.setLayout(new BorderLayout());
        textPanel.setBorder(new EmptyBorder(0, 10, 0, 0));
        add(textPanel, BorderLayout.WEST);

        JLabel level_title = new JLabel(name);
        level_title.setFont(assets.getArialBoldTitle());
        textPanel.add(level_title, BorderLayout.NORTH);

        score_title = new JLabel(score);
        score_title.setFont(assets.getArial());
        score_title.setForeground(assets.getMainColorYellowBG());
        textPanel.add(score_title, BorderLayout.CENTER);

        JPanel checkPanel = new JPanel();
        checkPanel.setBackground(null);
        checkPanel.setLayout(new BorderLayout());
        checkPanel.setBorder(new EmptyBorder(0, 0, 0, 20));
        add(checkPanel, BorderLayout.EAST);

        Image iconImage;
        JLabel icon = new JLabel();
        checkPanel.add(icon, BorderLayout.CENTER);

        if (isComplete == 1){
            if (index % 2 == 0){
                iconImage = assets.getCheckIconBlack().getImage();
            }else {
                iconImage = assets.getCheckIconWhite().getImage();
            }
            Image resizeIcon = iconImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon checkIcon = new ImageIcon(resizeIcon);
            icon.setIcon(checkIcon);
        }

        if (index % 2 == 0){
            setBorderColor(assets.getMainColorWhithy());
            setColor(assets.getMainColorWhithy());
            setColorClick(assets.getWhiteColorClick());
            setColorOver(assets.getWhiteColorOver());
            level_title.setForeground(assets.getMainColorBlackTxt());
        }else {
            setBorderColor(assets.getMainColorDarkGreen());
            setColor(assets.getMainColorDarkGreen());
            setColorClick(assets.getDarkGreenColorClick());
            setColorOver(assets.getDarkGreenColorOver());
            level_title.setForeground(assets.getMainColorWhithy());
        }
    }
}
