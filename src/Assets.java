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
    private final ImageIcon OrderIcon = new ImageIcon("src/img/OrderIcon.png");
    private final ImageIcon PeopleIcon = new ImageIcon("src/img/PeopleIcon.png");
    private final ImageIcon SelfIcon = new ImageIcon("src/img/SelfIcon.png");
    private final ImageIcon MapIcon = new ImageIcon("src/img/MapIcon.png");
    private final ImageIcon BagIcon = new ImageIcon("src/img/BagIcon.png");
    private final ImageIcon ShopIcon = new ImageIcon("src/img/ShopIcon.png");
    private final ImageIcon DailyIcon = new ImageIcon("src/img/DailyIcon.png");
    private final ImageIcon JeepIcon = new ImageIcon("src/img/JeepIcon.png");
    private final ImageIcon WeatherIcon = new ImageIcon("src/img/WeatherIcon.png");
    private final ImageIcon PartyIcon = new ImageIcon("src/img/PartyIcon.png");
    private final ImageIcon leftIcon = new ImageIcon("src/img/btn_left.png");
    private final ImageIcon rightIcon = new ImageIcon("src/img/btn_right.png");
    private final ImageIcon checkIconWhite = new ImageIcon("src/img/CheckIconWhite.png");
    private final ImageIcon checkIconBlack = new ImageIcon("src/img/CheckIconBlack.png");

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
    private final Color mainColorWhiteDesc = new Color(0xF1F1F1);
    private final Color WhiteColorOver = new Color(0xEBEBEB);
    private final Color WhiteColorClick = new Color(0xCECECE);

    // Fonts
    private final Font ArialTitle = new Font("Arial Black", Font.PLAIN, 24);
    private final Font ArialBold = new Font("Arial", Font.BOLD, 20);
    private final Font Arial = new Font("Arial", Font.PLAIN, 16);
    private final Font ArialBoldTitle = new Font("Arial", Font.BOLD, 30);
    private final Font ArialScore = new Font("Arial", Font.BOLD, 50);
    private final Font Arial_desc = new Font("Arial", Font.PLAIN, 14);

    // File Path for Users File
    private final String usersFilePath = "src/textfiles/users.txt";
    private final String alphabetFilePath = "src/textfiles/alphabet.txt";
    private final String wpwFilePath = "src/textfiles/wordPerword.txt";
    private final String categoryNamesFilePath = "src/textfiles/CategoryNames.txt";
    private final String OrderFoodFilePath = "src/textfiles/OrderFood.txt";
    private final String DescribePeopleFilePath = "src/textfiles/DescribePeople.txt";
    private final String IntroduceYourselfFilePath = "src/textfiles/IntroduceYourself.txt";
    private final String AskForDirectionsFilePath = "src/textfiles/AskForDirections.txt";
    private final String DescribeBelongingsFilePath = "src/textfiles/DescribeBelongings.txt";
    private final String MarketShoppingFilePath = "src/textfiles/MarketShopping.txt";
    private final String DailyActivitiesFilePath = "src/textfiles/DailyActivities.txt";
    private final String TransportationFilePath = "src/textfiles/Transportation.txt";
    private final String WeatherSeasonsFilePath = "src/textfiles/WeatherSeasons.txt";
    private final String FestivalsCelebrationFilePath = "src/textfiles/FestivalsCelebrations.txt";
    private final String FlashCardCategories = "src/textfiles/FlashCardCategories.txt";
    private final String Foods_FC = "src/textfiles/Food_FC.txt";
    private final String Numbers_FC = "src/textfiles/Numbers_FC.txt";
    private final String Transportation_FC = "src/textfiles/Transportation_FC.txt";
    private final String Money_FC = "src/textfiles/Money_FC.txt";
    private final String Greetings_FC = "src/textfiles/Greetings_FC.txt";
    private final String DescPeople_FC = "src/textfiles/DescribePeople_FC.txt";
    private final String level_names = "src/textfiles/LevelInfo.txt";
    private final String Novice_Quiz = "src/textfiles/Quiz/Novice_Quiz.txt";
    private final String Beginner_Quiz = "src/textfiles/Quiz/Beginner_Quiz.txt";
    private final String Apprentice_Quiz = "src/textfiles/Quiz/Apprentice_Quiz.txt";
    private final String Intermediate_Quiz = "src/textfiles/Quiz/Intermediate_Quiz.txt";
    private final String Adept_Quiz = "src/textfiles/Quiz/Adept_Quiz.txt";
    private final String Skilled_Quiz = "src/textfiles/Quiz/Skilled_Quiz.txt";
    private final String Advanced_Quiz = "src/textfiles/Quiz/Advanced_Quiz.txt";
    private final String Expert_Quiz = "src/textfiles/Quiz/Expert_Quiz.txt";
    private final String Master_Quiz = "src/textfiles/Quiz/Master_Quiz.txt";
    private final String Natural_Filpino_Quiz = "src/textfiles/Quiz/Natural_Filipino_Quiz.txt";


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

    public String getCategoryNamesFilePath() {
        return categoryNamesFilePath;
    }

    public ImageIcon getOrderIcon() {
        return OrderIcon;
    }

    public ImageIcon getPeopleIcon() {
        return PeopleIcon;
    }

    public ImageIcon getSelfIcon() {
        return SelfIcon;
    }

    public ImageIcon getMapIcon() {
        return MapIcon;
    }

    public ImageIcon getBagIcon() {
        return BagIcon;
    }

    public ImageIcon getShopIcon() {
        return ShopIcon;
    }

    public ImageIcon getDailyIcon() {
        return DailyIcon;
    }

    public ImageIcon getJeepIcon() {
        return JeepIcon;
    }

    public ImageIcon getWeatherIcon() {
        return WeatherIcon;
    }

    public ImageIcon getPartyIcon() {
        return PartyIcon;
    }

    public Color getMainColorWhiteDesc() {
        return mainColorWhiteDesc;
    }

    public String getOrderFoodFilePath() {
        return OrderFoodFilePath;
    }

    public String getDescribePeopleFilePath() {
        return DescribePeopleFilePath;
    }

    public String getIntroduceYourselfFilePath() {
        return IntroduceYourselfFilePath;
    }

    public String getAskForDirectionsFilePath() {
        return AskForDirectionsFilePath;
    }

    public String getDescribeBelongingsFilePath() {
        return DescribeBelongingsFilePath;
    }

    public String getMarketShoppingFilePath() {
        return MarketShoppingFilePath;
    }

    public String getDailyActivitiesFilePath() {
        return DailyActivitiesFilePath;
    }

    public String getTransportationFilePath() {
        return TransportationFilePath;
    }

    public String getWeatherSeasonsFilePath() {
        return WeatherSeasonsFilePath;
    }

    public String getFestivalsCelebrationFilePath() {
        return FestivalsCelebrationFilePath;
    }

    public String getFlashCardCategories() {
        return FlashCardCategories;
    }

    public ImageIcon getLeftIcon() {
        return leftIcon;
    }

    public ImageIcon getRightIcon() {
        return rightIcon;
    }

    public String getFoods_FC() {
        return Foods_FC;
    }

    public String getNumbers_FC() {
        return Numbers_FC;
    }

    public String getTransportation_FC() {
        return Transportation_FC;
    }

    public String getMoney_FC() {
        return Money_FC;
    }

    public String getGreetings_FC() {
        return Greetings_FC;
    }

    public String getDescPeople_FC() {
        return DescPeople_FC;
    }

    public String getLevel_names() {
        return level_names;
    }

    public Color getWhiteColorOver() {
        return WhiteColorOver;
    }

    public Color getWhiteColorClick() {
        return WhiteColorClick;
    }

    public ImageIcon getCheckIconWhite() {
        return checkIconWhite;
    }

    public ImageIcon getCheckIconBlack() {
        return checkIconBlack;
    }

    public String getNovice_Quiz() {
        return Novice_Quiz;
    }

    public String getBeginner_Quiz() {
        return Beginner_Quiz;
    }

    public String getApprentice_Quiz() {
        return Apprentice_Quiz;
    }

    public String getIntermediate_Quiz() {
        return Intermediate_Quiz;
    }

    public String getAdept_Quiz() {
        return Adept_Quiz;
    }

    public String getSkilled_Quiz() {
        return Skilled_Quiz;
    }

    public String getAdvanced_Quiz() {
        return Advanced_Quiz;
    }

    public String getExpert_Quiz() {
        return Expert_Quiz;
    }

    public String getMaster_Quiz() {
        return Master_Quiz;
    }

    public String getNatural_Filpino_Quiz() {
        return Natural_Filpino_Quiz;
    }

    public Font getArialScore() {
        return ArialScore;
    }
}
