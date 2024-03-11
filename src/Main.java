public class Main {
    public static void main(String[] args) {
        try {
            checkLoginAndPassword("admin12345", "admin", "admin");
        } catch (WrongLoginException | WrongPasswordException a) {
            a.printStackTrace();
        }
    }
    public static void checkLoginAndPassword(String login, String password, String confirmPassword) {
        if (login.length() > 20) {
            throw new WrongLoginException("Login is too long");
        }
        if (!login.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("Login contains unsupported symbols");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("Password is too long");
        }
        if (!password.matches("[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException("Password contains unsupported symbols");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Passwords don't match");
        }
    }
}