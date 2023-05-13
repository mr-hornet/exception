import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String login = "java_skypro_go";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_9";

        try {
            loginCheck(login);
            passwordCheck(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка ввода логина: " + e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка ввода пароля: " + e.getMessage());
        }

    }


    public static void loginCheck (String login) {

        if (login == null) {
            System.out.println("Нет необходимых параметров");
        }
        if (!login.matches("^[a-zA-Z0-9-_]+$")) {
            throw new WrongLoginException("Login должен содержать в себе только латинские буквы, цифры и знак подчеркивания.");
        } else if (login.length() > 20) {
            throw new WrongLoginException("Login должен быть меньше или равен 20 символам.");
        }
    }

    public static void passwordCheck (String password, String confirmPassword) {
        if (password == null || confirmPassword == null) {
            System.out.println("Нет необходимых параметров");
        }
        if (!password.matches("^[a-zA-Z0-9-_]+$")) {
            throw new WrongPasswordException ("Password должен содержать в себе только латинские буквы, цифры и знак подчеркивания.");
        } else if (password.length() >= 20) {
            throw new WrongPasswordException ("Password должен быть меньше 20 символов.");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException ("Пароли не совпадают");
        }
    }
}