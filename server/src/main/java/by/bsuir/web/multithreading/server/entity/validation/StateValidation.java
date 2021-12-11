package by.bsuir.web.multithreading.server.entity.validation;

public final class StateValidation {

    public static final String PHONE_NUMBER_PATTERN = "^(?:\\+|00)[1-9]\\d{1,14}$";
    public static final String EMAIL_PATTERN = "^(?:[_\\-.]?[A-Za-z0-9]+)+@[A-Za-z0-9-]+\\.[a-z]{2,}$";

    private StateValidation() {
    }

    public static void validateEmail(String email) throws StateValidationException {
        if (!email.matches(EMAIL_PATTERN)) {
            throw new StateValidationException("Email is not valid: " + email);
        }
    }

    public static void validatePhoneNumber(String phoneNumber) throws StateValidationException {
        if (!phoneNumber.matches(PHONE_NUMBER_PATTERN)) {
            throw new StateValidationException("Phone number is not valid: " + phoneNumber);
        }
    }
}
