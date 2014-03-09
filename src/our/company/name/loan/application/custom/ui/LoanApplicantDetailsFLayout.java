package our.company.name.loan.application.custom.ui;

import our.company.name.loan.application.custom.ui.components.LoanTextArea;
import our.company.name.loan.application.custom.ui.components.LoanTextField;
import our.company.name.loan.designed.ui.interfaces.IValidate;

import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.FormLayout;

@SuppressWarnings("serial")
public class LoanApplicantDetailsFLayout extends FormLayout implements
		IValidate {

	public LoanTextArea officeAddressTextArea1;

	public LoanTextArea permanentAddressTextArea1;

	public LoanTextArea residentAddressTextArea1;

	public LoanTextField emailTxtFld1;

	public LoanTextField mobileTxtFld1;

	public LoanTextField landlineTxtFld1;

	public LoanTextField lastNameTxtFld1;

	public LoanTextField firstNameTxtFld1;

	private static String emailTxtFld1ErrorStr = "Email ID CANNOT be empty";
	private static String mobileTxtFld1ErrorStr = "Mobile number CANNOT be empty";
	private static String landlineTxtFld1ErrorStr = "Telephone number CANNOT be empty";
	private static String lastNameTxtFld1ErrorStr = "Last Name CANNOT be empty";
	private static String firstNameTxtFld1ErrorStr = "First Name CANNOT be empty";
	private static String residentAddressTextArea1ErrorStr = "Resident Address CANNOT be empty";
	private static String permanentAddressTextArea1ErrorStr = "Permanent Address CANNOT be empty";
	private static String officeAddressTextArea1ErrorStr = "Office Address CANNOT be empty";

	public LoanApplicantDetailsFLayout() {

		super();

		this.setCaption("Details of Loan Applicant");
		this.setImmediate(true);
		this.setWidth("100px");
		this.setHeight("100px");
		this.setMargin(true);
		this.setSpacing(true);

		// firstNameTxtFld1
		firstNameTxtFld1 = new LoanTextField("Name");
		firstNameTxtFld1.setWidth("195px");
		firstNameTxtFld1.setHeight("-1px");
		this.addComponent(firstNameTxtFld1);

		// lastNameTxtFld1
		lastNameTxtFld1 = new LoanTextField("Surname");
		lastNameTxtFld1.setWidth("195px");
		lastNameTxtFld1.setHeight("-1px");
		this.addComponent(lastNameTxtFld1);

		// mobileTxtFld1
		mobileTxtFld1 = new LoanTextField("Mobile");
		mobileTxtFld1.setWidth("195px");
		mobileTxtFld1.setHeight("-1px");
		mobileTxtFld1.setInputPrompt("Should be 10 digits");
		this.addComponent(mobileTxtFld1);

		// landlineTxtFld1
		landlineTxtFld1 = new LoanTextField("Landline");
		landlineTxtFld1.setWidth("195px");
		landlineTxtFld1.setHeight("-1px");
		// landlineTxtFld1.setInputPrompt("Should be 10 digits");
		this.addComponent(landlineTxtFld1);

		// emailTxtFld1
		emailTxtFld1 = new LoanTextField("Email");
		emailTxtFld1.setWidth("195px");
		emailTxtFld1.setHeight("-1px");
		emailTxtFld1.setInputPrompt("Should be a Valid Email ID");
		this.addComponent(emailTxtFld1);

		// residentAddressTextArea1
		residentAddressTextArea1 = new LoanTextArea("Current Address");
		residentAddressTextArea1.setWidth("195px");
		residentAddressTextArea1.setHeight("-1px");
		residentAddressTextArea1
				.setInputPrompt("Where does loan applicant live ? ");
		this.addComponent(residentAddressTextArea1);

		// permanentAddressTextArea1
		permanentAddressTextArea1 = new LoanTextArea("Permanent Address");
		permanentAddressTextArea1.setWidth("195px");
		permanentAddressTextArea1.setHeight("-1px");
		permanentAddressTextArea1
				.setInputPrompt("What is loan applicant's Permanent Address ?");
		this.addComponent(permanentAddressTextArea1);

		// officeAddressTextArea1
		officeAddressTextArea1 = new LoanTextArea("Office Address");
		officeAddressTextArea1.setWidth("195px");
		officeAddressTextArea1.setHeight("-1px");
		officeAddressTextArea1
				.setInputPrompt("Where does loan applicant work ? ");
		this.addComponent(officeAddressTextArea1);

	}

	@Override
	public int validate() {
		int errors = 0;

		try {
			emailTxtFld1.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			mobileTxtFld1.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			landlineTxtFld1.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			lastNameTxtFld1.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			firstNameTxtFld1.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			residentAddressTextArea1.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			permanentAddressTextArea1.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			officeAddressTextArea1.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		return errors;
	}

	@Override
	public void removeAllTextValidators() {

		emailTxtFld1.removeAllValidators();
		mobileTxtFld1.removeAllValidators();
		landlineTxtFld1.removeAllValidators();
		lastNameTxtFld1.removeAllValidators();
		firstNameTxtFld1.removeAllValidators();
		residentAddressTextArea1.removeAllValidators();
		permanentAddressTextArea1.removeAllValidators();
		officeAddressTextArea1.removeAllValidators();

	}

	@Override
	public void addAllTextValidators() {
		// Step-1: Remove previous validators
		removeAllTextValidators();

		// Step-2: Add new validators
		firstNameTxtFld1.addValidator(new StringLengthValidator(
				firstNameTxtFld1ErrorStr, 1, 100, false));
		lastNameTxtFld1.addValidator(new StringLengthValidator(
				lastNameTxtFld1ErrorStr, 1, 100, false));
		mobileTxtFld1.addValidator(new StringLengthValidator(
				mobileTxtFld1ErrorStr, 1, 100, false));
		landlineTxtFld1.addValidator(new StringLengthValidator(
				landlineTxtFld1ErrorStr, 1, 100, false));
		emailTxtFld1.addValidator(new StringLengthValidator(
				emailTxtFld1ErrorStr, 1, 100, false));
		residentAddressTextArea1.addValidator(new StringLengthValidator(
				residentAddressTextArea1ErrorStr, 1, 1000, false));
		permanentAddressTextArea1.addValidator(new StringLengthValidator(
				permanentAddressTextArea1ErrorStr, 1, 1000, false));
		officeAddressTextArea1.addValidator(new StringLengthValidator(
				officeAddressTextArea1ErrorStr, 1, 1000, false));
	}

}
