import DatabaseHandler.Connect;
import UI.LoginPage;
import DatabaseHandler.Connect;
public class Test {
    public static void main(String [] args)
    {
        Connect con = new Connect();
        new LoginPage();
    }
}
