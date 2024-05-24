import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {
    Assets assets = new Assets();

    public DashboardFrame(){
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("WikaWisdom");
        setLocationRelativeTo(null);
        setIconImage(assets.getWikaLogo().getImage());
        setResizable(false);

        JPanel mainBackground = new JPanel();
        mainBackground.setBackground(assets.getMainColorDarkGreen());
        this.add(mainBackground);

        setVisible(true);
    }
}
