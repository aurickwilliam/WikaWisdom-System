import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CategoryPanel extends RoundedButton{
    Assets assets = new Assets();

    public CategoryPanel(String category_name){
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
        Image iconImage = getIcon(category_name);
        Image resizeIcon = iconImage.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(resizeIcon);
        setIcon(icon);
        setIconTextGap(15);
    }

    public Image getIcon(String name){
        Image image = null;
        if (name.equals("Order Food")){
            image = assets.getOrderIcon().getImage();
        }else if (name.equals("Describe People")){
            image = assets.getPeopleIcon().getImage();
        }else if (name.equals("Introduce Yourself")){
            image = assets.getSelfIcon().getImage();
        }else if (name.equals("Ask for Directions")){
            image = assets.getMapIcon().getImage();
        }else if (name.equals("Describe Belongings")){
            image = assets.getBagIcon().getImage();
        }else if (name.equals("Market Shopping")){
            image = assets.getShopIcon().getImage();
        }else if (name.equals("Daily Activities")){
            image = assets.getDailyIcon().getImage();
        }else if (name.equals("Transportation")){
            image = assets.getJeepIcon().getImage();
        }else if (name.equals("Weather and Seasons")){
            image = assets.getWeatherIcon().getImage();
        }else if (name.equals("Festivals and Celebrations")){
            image = assets.getPartyIcon().getImage();
        }
        return image;
    }
}
