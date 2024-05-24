import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountPanel extends RoundedButton {
    Assets assets = new Assets();
    public AccountPanel(String name){
        setText(name);
        setFocusable(false);
        Image iconImage = assets.getProfileIcon().getImage();
        Image resizeIcon = iconImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon ProfileIcon = new ImageIcon(resizeIcon);
        setIcon(ProfileIcon);
        setFont(assets.getArialBold());
        setForeground(assets.getMainColorWhiteBG());
        setColor(assets.getMainColorYellowBG());
        setRadius(10);
        setColorClick(assets.getYellowColorClick());
        setBorderColor(assets.getMainColorYellowBG());
        setColorOver(assets.getYellowColorOver());
        setHorizontalAlignment(RoundedButton.LEFT);
        setBorder(new EmptyBorder(10, 10, 10, 10));
    }
}
