package our.company.name.loan.application.custom.ui;

import our.company.name.loan.application.custom.ui.components.LoanTextField;
import our.company.name.loan.designed.ui.interfaces.IValidate;

import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class LoanGuarantorDetailsFLayout extends FormLayout implements
		IValidate {

	public TextArea officeAddressTextArea2;

	public TextArea permanentAddressTextArea2;

	public TextArea residentAddressTextArea2;

	public TextField emailTxtFld2;

	public TextField mobileTxtFld2;

	public LoanTextField landlineTxtFld2;

	public TextField lastNameTxtFld2;

	public TextField firstNameTxtFld2;

	private static String emailTxtFld1ErrorStr = "Email ID CANNOT be empty";
	private static String mobileTxtFld1ErrorStr = "Mobile number CANNOT be empty";
	private static String landlineTxtFld2ErrorStr = "Telephone number CANNOT be empty";
	private static String lastNameTxtFld1ErrorStr = "Last Name CANNOT be empty";
	private static String firstNameTxtFld1ErrorStr = "First Name CANNOT be empty";
	private static String residentAddressTextArea1ErrorStr = "Resident Address CANNOT be empty";
	private static String permanentAddressTextArea1ErrorStr = "Permanent Address CANNOT be empty";
	private static String officeAddressTextArea1ErrorStr = "Office Address CANNOT be empty";

	public LoanGuarantorDetailsFLayout() {

		super();

		this.setCaption("Details of Guarantor");
		this.setImmediate(true);
		this.setWidth("100.0%");
		this.setHeight("100.0%");
		this.setMargin(true);
		this.setSpacing(true);

		// firstNameTxtFld2
		firstNameTxtFld2 = new TextField("Name");
		firstNameTxtFld2.setImmediate(true);
		firstNameTxtFld2.setWidth("195px");
		firstNameTxtFld2.setHeight("-1px");
		this.addComponent(firstNameTxtFld2);

		// lastNameTxtFld2
		lastNameTxtFld2 = new TextField("Surname");
		lastNameTxtFld2.setImmediate(true);
		lastNameTxtFld2.setWidth("195px");
		lastNameTxtFld2.setHeight("-1px");
		this.addComponent(lastNameTxtFld2);

		// mobileTxtFld2
		mobileTxtFld2 = new TextField("Mobile");
		mobileTxtFld2.setImmediate(true);
		mobileTxtFld2.setWidth("195px");
		mobileTxtFld2.setHeight("-1px");
		mobileTxtFld2.setInputPrompt("Should be 10 digits");
		this.addComponent(mobileTxtFld2);

		// landlineTxtFld2
		landlineTxtFld2 = new LoanTextField("Landline");
		landlineTxtFld2.setWidth("195px");
		landlineTxtFld2.setHeight("-1px");
		// landlineTxtFld2.setInputPrompt("Should be 10 digits");
		this.addComponent(landlineTxtFld2);

		// emailTxtFld2
		emailTxtFld2 = new TextField("Email");
		emailTxtFld2.setImmediate(true);
		emailTxtFld2.setWidth("195px");
		emailTxtFld2.setHeight("-1px");
		emailTxtFld2.setInputPrompt("Should be Valid Email ID");
		this.addComponent(emailTxtFld2);

		// residentAddressTextArea2
		residentAddressTextArea2 = new TextArea("Current Address");
		residentAddressTextArea2.setImmediate(true);
		residentAddressTextArea2.setWidth("195px");
		residentAddressTextArea2.setHeight("-1px");
		residentAddressTextArea2
				.setInputPrompt("Where does loan guarantor live ? ");

		this.addComponent(residentAddressTextArea2);

		// permanentAddressTextArea2
		permanentAddressTextArea2 = new TextArea("Permanent Address");
		permanentAddressTextArea2.setImmediate(true);
		permanentAddressTextArea2.setWidth("195px");
		permanentAddressTextArea2.setHeight("-1px");
		permanentAddressTextArea2
				.setInputPrompt("What is loan guarantor's Permanent Address ?");
		this.addComponent(permanentAddressTextArea2);

		// officeAddressTextArea2
		officeAddressTextArea2 = new TextArea("Office Address");
		officeAddressTextArea2.setImmediate(true);
		officeAddressTextArea2.setWidth("195px");
		officeAddressTextArea2.setHeight("-1px");
		officeAddressTextArea2
				.setInputPrompt("Where does loan guarantor work ? ");
		this.addComponent(officeAddressTextArea2);
	}

	@Override
	public int validate() {
		int errors = 0;

		try {
			emailTxtFld2.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			mobileTxtFld2.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			landlineTxtFld2.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			lastNameTxtFld2.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			firstNameTxtFld2.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			residentAddressTextArea2.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			permanentAddressTextArea2.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			officeAddressTextArea2.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		return errors;
	}

	@Override
	public void removeAllTextValidators() {

		emailTxtFld2.removeAllValidators();
		mobileTxtFld2.removeAllValidators();
		landlineTxtFld2.removeAllValidators();
		lastNameTxtFld2.removeAllValidators();
		firstNameTxtFld2.removeAllValidators();
		residentAddressTextArea2.removeAllValidators();
		permanentAddressTextArea2.removeAllValidators();
		officeAddressTextArea2.removeAllValidators();

	}

	@Override
	public void addAllTextValidators() {
		// Step-1: Remove previous validators
		removeAllTextValidators();

		// Step-2: Add new validators
		firstNameTxtFld2.addValidator(new StringLengthValidator(
				firstNameTxtFld1ErrorStr, 1, 100, false));
		lastNameTxtFld2.addValidator(new StringLengthValidator(
				lastNameTxtFld1ErrorStr, 1, 100, false));
		mobileTxtFld2.addValidator(new StringLengthValidator(
				mobileTxtFld1ErrorStr, 1, 100, false));
		landlineTxtFld2.addValidator(new StringLengthValidator(
				landlineTxtFld2ErrorStr, 1, 100, false));
		emailTxtFld2.addValidator(new StringLengthValidator(
				emailTxtFld1ErrorStr, 1, 100, false));
		residentAddressTextArea2.addValidator(new StringLengthValidator(
				residentAddressTextArea1ErrorStr, 1, 1000, false));
		permanentAddressTextArea2.addValidator(new StringLengthValidator(
				permanentAddressTextArea1ErrorStr, 1, 1000, false));
		officeAddressTextArea2.addValidator(new StringLengthValidator(
				officeAddressTextArea1ErrorStr, 1, 1000, false));
	}

}
