package our.company.name.loan.custom.validators;

import com.vaadin.data.validator.AbstractValidator;

//
// Validator for validating the passwords
//
@SuppressWarnings("serial")
public final class PasswordValidator extends AbstractValidator<String> {

	public PasswordValidator() {
		super("The password provided is not valid");
	}

	@Override
	protected boolean isValidValue(String value) {
		//
		// Password must be at least 8 characters long and contain at least
		// one number
		//
		if (value != null && (value.length() < 8)) {
			return false;
		}
		return true;
	}

	@Override
	public Class<String> getType() {
		return String.class;
	}
}
