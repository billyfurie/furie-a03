package baseline;

public class InputValidator {

    private static final String MESSAGE_LENGTH_FIRST = "The first name must be at least 2 characters long.";
    private static final String MESSAGE_LENGTH_LAST = "The last name must be at least 2 characters long.";
    private static final String MESSAGE_EMPTY_FIRST = "The first name must be filled in.";
    private static final String MESSAGE_EMPTY_LAST = "The last name must be filled in.";
    private static final String MESSAGE_ID_FORMAT = "The employee ID must be in the format of AA-1234.";
    private static final String MESSAGE_ZIPCODE_FORMAT = "The zipcode must be a 5 digit number.";
    private static final String MESSAGE_NO_ERRORS = "There were no errors found.";

    private static final int ID_LENGTH = 7;

    private StringBuilder validationMessage;

    public InputValidator(String firstName, String lastName, String zip, String id) {
        validationMessage = new StringBuilder();

        validateInput(firstName, lastName, zip, id);
    }

    // Used for testing purposes
    public InputValidator(){
        validationMessage = new StringBuilder();
    }

    // calls all the validation methods
    private void validateInput(String firstName, String lastName, String zip, String id) {
        boolean firstValid = validateFirstName(firstName);
        boolean lastValid = validateLastName(lastName);
        boolean idValid = validateID(id);
        boolean zipValid = validateZip(zip);


        // if no issue with any of these, print "There were no errors found."
        if (firstValid && lastValid && zipValid && idValid) {
            addToDisplayMessage(MESSAGE_NO_ERRORS);
        }
    }

    // return whether there was an issue with first name
    public boolean validateFirstName(String firstName) {
        boolean valid = true;

        if (firstName == null) {
            return false;
        }

        // check that the name is at least 2 chars long
        // if not, add message to string builder
        if (firstName.length() < 2) {
            addToDisplayMessage(MESSAGE_LENGTH_FIRST);

            // check that the name is not empty
            // if not, add message to string builder
            if (firstName.isEmpty()) {
                addToDisplayMessage(MESSAGE_EMPTY_FIRST);
            }
            valid = false;
        }

        return valid;
    }

    // return whether there was an issue with last name
    public boolean validateLastName(String lastName) {
        boolean valid = true;

        if (lastName == null) {
            return false;
        }

        // check that the name is at least 2 chars long
        // if not, add message to string builder
        if (lastName.length() < 2) {
            addToDisplayMessage(MESSAGE_LENGTH_LAST);

            // check that the name is not empty
            // if not, add message to string builder
            if (lastName.isEmpty()) {
                addToDisplayMessage(MESSAGE_EMPTY_LAST);
            }
            valid = false;
        }

        return valid;
    }

    // return whether there was an issue with zip
    public boolean validateZip(String zip) {
        boolean valid = true;

        if (zip == null) {
            return false;
        }

        // check whether the zip code is an integer
        try {
            int num = Integer.parseInt(zip);
            if (num < 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            valid = false;
        }
        // check whether the zip code is 5 digits
        if (zip.length() != 5) {
            valid = false;
        }

        // if either case is incorrect, add message to string builder
        if (!valid) {
            addToDisplayMessage(MESSAGE_ZIPCODE_FORMAT);
        }

        return valid;
    }

    // return whether there was an issue with id
    public boolean validateID(String id) {
        boolean valid = true;

        if (id == null) {
            return false;
        }

        int length = id.length();

        if (length != ID_LENGTH) {
            addToDisplayMessage(MESSAGE_ID_FORMAT);
            return false;
        }

        // check that the ID is in format AA-1234
        char[] idArray = id.toCharArray();

        for (int i = 0; i < length; i++) {
            char currentChar = idArray[i];

            // validate each char
            if (!validateCharInID(i, currentChar)) {
                valid = false;
                break;
            }
        }
        // 2 letters, hyphen, 4 numbers
        // if there's an issue, add message to string builder
        if (!valid) {
            addToDisplayMessage(MESSAGE_ID_FORMAT);
        }

        return valid;
    }

    // validates each character for its index and rules
    public boolean validateCharInID(int index, char c) {
        // first 2 chars, check if capital letters
        // check for hyphen
        // check for last 4 chars to be digits

        // if any of these are false, the char is invalid
        // return whether char is valid or not
        return !(index < 2 && !Character.isUpperCase(c) || (index == 2 && c != '-') || (index > 2 && !Character.isDigit(c)));
    }

    private void addToDisplayMessage(String segment) {
        validationMessage.append(segment);
        validationMessage.append('\n');
    }

    public String getValidationMessage() {
        // return the string from the string builder
        return validationMessage.toString();
    }
}
