package w0917.PasswordGenerator;

public class Condition {
    static boolean checkPassword(String password){
        if(password.length() < 8)
            return false;
        for(int i = 0; i < password.length(); i++){
            char ch = password.charAt(i);
            if(!Character.isAlphabetic(ch))
                return false;
        }
        return true;
    }
}
