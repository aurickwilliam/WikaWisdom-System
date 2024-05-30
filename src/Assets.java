import javax.swing.*;
import java.awt.*;

public class Assets {
    // Images
    private final ImageIcon WikaLogo = new ImageIcon("src/img/WikaLogo.png");
    private final ImageIcon WikaLogoTrans = new ImageIcon("src/img/WikaLogoTrans.png");
    private final ImageIcon ProfileIcon = new ImageIcon("src/img/ProfileIcon.png");
    private final ImageIcon WhiteProfileIcon = new ImageIcon("src/img/WhiteProfileIcon.png");
    private final ImageIcon BookIcon = new ImageIcon("src/img/BookIcon.png");
    private final ImageIcon FlashCardIcon = new ImageIcon("src/img/BrainIcon.png");
    private final ImageIcon LevelIcon = new ImageIcon("src/img/ProgressIcon.png");
    private final ImageIcon backBtn = new ImageIcon("src/img/back_button.png");

    // Colors
    private final Color mainColorDarkGreen = new Color(0x004e64);
    private final Color mainColorWhiteBG = new Color(0xF3F3F3);
    private final Color mainColorBlackTxt = new Color(0x3B3B3B);
    private final Color mainColorYellowBG = new Color(0xF5C529);
    private final Color YellowColorClick = new Color(0xD9BD64);
    private final Color YellowColorOver = new Color(0xB68F10);
    private final Color mainColorWhithy = new Color(0xFFFFFF);
    private final Color DarkGreenColorOver = new Color(0x006783);
    private final Color DarkGreenColorClick = new Color(0x2B5D6B);

    // Fonts
    private final Font ArialTitle = new Font("Arial Black", Font.PLAIN, 24);
    private final Font ArialBold = new Font("Arial", Font.BOLD, 20);
    private final Font Arial = new Font("Arial", Font.PLAIN, 16);
    private final Font ArialBoldTitle = new Font("Arial", Font.BOLD, 30);
    private final Font Arial_desc = new Font("Arial", Font.PLAIN, 14);

    // File Path for Users File
    private final String usersFilePath = "src/textfiles/users.txt";
    private final String alphabetFilePath = "src/textfiles/alphabet.txt";
    private final String wpwFilePath = "src/textfiles/wordPerword.txt";


    public ImageIcon getWikaLogo() {
        return WikaLogo;
    }

    public ImageIcon getWikaLogoTrans() {
        return WikaLogoTrans;
    }

    public Color getMainColorDarkGreen() {
        return mainColorDarkGreen;
    }

    public Color getMainColorWhiteBG() {
        return mainColorWhiteBG;
    }

    public Color getMainColorBlackTxt() {
        return mainColorBlackTxt;
    }

    public Color getMainColorYellowBG() {
        return mainColorYellowBG;
    }

    public Color getYellowColorClick() {
        return YellowColorClick;
    }

    public Color getYellowColorOver() {
        return YellowColorOver;
    }

    public Color getMainColorWhithy() {
        return mainColorWhithy;
    }

    public Font getArialTitle() {
        return ArialTitle;
    }

    public Font getArialBold() {
        return ArialBold;
    }

    public Font getArial() {
        return Arial;
    }

    public String getUsersFilePath() {
        return usersFilePath;
    }

    public ImageIcon getProfileIcon() {
        return ProfileIcon;
    }

    public ImageIcon getWhiteProfileIcon() {
        return WhiteProfileIcon;
    }

    public Color getDarkGreenColorOver() {
        return DarkGreenColorOver;
    }

    public Color getDarkGreenColorClick() {
        return DarkGreenColorClick;
    }

    public ImageIcon getBookIcon() {
        return BookIcon;
    }

    public ImageIcon getFlashCardIcon() {
        return FlashCardIcon;
    }

    public ImageIcon getLevelIcon() {
        return LevelIcon;
    }

    public Font getArialBoldTitle() {
        return ArialBoldTitle;
    }

    public Font getArial_desc() {
        return Arial_desc;
    }

    public ImageIcon getBackBtn() {
        return backBtn;
    }

    public String getAlphabetFilePath() {
        return alphabetFilePath;
    }

    public String getWpwFilePath() {
        return wpwFilePath;
    }
}
