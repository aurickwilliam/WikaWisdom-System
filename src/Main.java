import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    // File Path for Users File
    private final String usersFilePath = "src/textfiles/users.txt";

    public static void main(String[] args) {
        Main main = new Main();
        boolean isUserFileEmpty = main.checkIfUserFileIsEmpty(main.usersFilePath);

//        if (isUserFileEmpty){
//            new LoginRegisterFrame();
//        }else {
//            new AccountsFrame();
//        }

        new DashboardFrame();
    }

    // Check if the User File is Empty
    public boolean checkIfUserFileIsEmpty(String filePath){
        try{
            FileReader file = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(file);
            return reader.readLine() == null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
