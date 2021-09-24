package baseline;

public class InputValidator {

    private String firstName;
    private String lastName;
    private String zip;
    private String id;
    private StringBuilder validationMessage;

    public InputValidator(String firstName, String lastName, String zip, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zip = zip;
        this.id = id;
        validationMessage = new StringBuilder();
    }

    // calls all the validation methods
    private void validateInput(String firstName, String lastName, String zip, String id) {

        validateFirstName(firstName);
        validateLastName(lastName);
        validateZip(zip);
        validateID(id);

        // if no issue with any of these, print "There were no errors found."
    }

    // return whether there was an issue with first name
    private boolean validateFirstName(String firstName) {
        // check that the name is not empty
        // if not, add message to string builder

        // check that the name is at least 2 chars long
        // if not, add message to string builder

        // placeholder
        return true;
    }

    // return whether there was an issue with last name
    private boolean validateLastName(String lastName) {
        // check that the name is not empty
        // if not, add message to string builder

        // check that the name is at least 2 chars long
        // if not, add message to string builder

        // placeholder
        return true;
    }

    // return whether there was an issue with zip
    private boolean validateZip(String zip) {
        // check whether the zip code is a 5-digit number
        // if not, add message to string builder

        // placeholder
        return true;
    }

    // return whether there was an issue with id
    private boolean validateID(String id) {
        // check that the ID is in format AA-1234
        // 2 letters, hyphen, 4 numbers
        // if not, add message to string builder

        // placeholder
        return true;
    }

    private String getValidationMessage() {
        // return the string from the string builder

        return "";
    }
}
