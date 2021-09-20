package baseline;

public class Password {

    private static final int RECOMMENDED_LENGTH = 8;

    public static final int VERY_WEAK = 0;
    public static final int WEAK = 1;
    public static final int STRONG = 2;
    public static final int VERY_STRONG = 3;
    public static final int UNKNOWN_STRENGTH = -1;

    private String pass;
    private int length;
    private boolean containsLetter;
    private boolean containsNumber;
    private boolean containsSpecial;
    private int strength;

    Password(String password) {
        pass = password;
        length = password.length();

        // Go through and look for our checks
        scanPassword();
        passwordValidator();
    }

    // Takes note on the password info
    private void scanPassword() {
        char[] passArray = pass.toCharArray();

        for (char c : passArray) {
            if (Character.isLetter(c)) {
                containsLetter = true;
            }
            else if (Character.isDigit(c)) {
                containsNumber = true;
            }
            else {
                containsSpecial = true;
            }
        }
    }

    // Next 4 functions are basic helpers
    private boolean onlyLetters() {
        return containsLetter && !containsNumber && ! containsSpecial;
    }

    private boolean onlyNumbers() {
        return containsNumber && !containsLetter && ! containsSpecial;
    }

    private boolean containsAll() {
        return containsNumber && containsLetter && containsSpecial;
    }

    private boolean lengthCheck() {
        return length >= RECOMMENDED_LENGTH;
    }

    public int passwordValidator() {
        // Based on rules provided
        if (onlyNumbers() && !lengthCheck()) {
            strength = VERY_WEAK;
        } else if (onlyLetters() && !lengthCheck()) {
            strength = WEAK;
        } else if (containsLetter && containsNumber && !containsSpecial && lengthCheck()) {
            strength = STRONG;
        } else if (containsAll() && lengthCheck()) {
            strength = VERY_STRONG;
        } else {
            strength = UNKNOWN_STRENGTH;
        }

        return strength;
    }

    public String getPasswordStrength() {
        // these strings always come after an "a"
        // this allows us to use "n ..." after the "a" to get "an"

        if (strength == VERY_WEAK) {
            return " very weak";
        } else if (strength == WEAK) {
            return " weak";
        } else if (strength == STRONG) {
            return " strong";
        } else if (strength == VERY_STRONG) {
            return " very strong";
        } else if (strength == UNKNOWN_STRENGTH) {
            return "n unknown strength";
        } else {
            return " broken";
        }
    }

    public String getPassword() {
        // We would check for credentials here
        return pass;
    }
 }
