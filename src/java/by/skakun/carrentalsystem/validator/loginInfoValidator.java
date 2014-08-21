
package by.skakun.carrentalsystem.validator;

/**
 *
 * @author Skakun
 * 
 * server-side validation
 */
public class loginInfoValidator {
    public boolean loginVal(String login) {
        if(login.isEmpty()) {
            return false;
        } else if (login.length()<3) {
            return false;
        } else if (login.length()>16) {
            return false;
        }
        return true;
    }
}
