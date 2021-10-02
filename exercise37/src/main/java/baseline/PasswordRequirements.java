package baseline;

public final class PasswordRequirements {

    private PasswordRequirements(){

    }

    // Checks if the password would be valid
    public static boolean isValidForPassword(int length, int numSpecials, int numNumbers) {
        int nonLetters = numSpecials + numNumbers;
        int letters = length - nonLetters;

        return letters >= nonLetters;
    }
}
