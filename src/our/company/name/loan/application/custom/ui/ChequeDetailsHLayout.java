package our.company.name.loan.application.custom.ui;

import our.company.name.application.utils.StringConstants;
import our.company.name.loan.application.custom.ui.components.LoanTextField;
import our.company.name.loan.designed.ui.interfaces.IValidate;

import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;

@SuppressWarnings("serial")
public class ChequeDetailsHLayout extends HorizontalLayout implements IValidate {

	private GridLayout chequeDetailsGLayout;

	private Label chequeNumberLbl;
	public LoanTextField chequeNumberTxtFld;

	private Label bankNameLbl;
	public LoanTextField bankNameTxtFld;

	private Label chequeDateLbl;
	public PopupDateField chequeDateFld;

	private Label loanAccountNumberLbl;
	public LoanTextField loanAccountNumberTxtFld;

	private Label amountLbl;
	public LoanTextField amountTxtFld;

	private static String chequeNumberTxtFldErrorStr = "Cheque Number CANNOT be empty";
	private static String bankNameTxtFldErrorStr = "Bank CANNOT be empty";
	private static String loanAccountNumberTxtFldErrorStr = "Loan Account Number CANNOT be empty";
	private static String amountTxtFldErrorStr = "Amount CANNOT be empty";

	public ChequeDetailsHLayout() {
		super();
		this.setCaption("Cheque Details");
		this.setMargin(true);

		chequeDetailsGLayout = new GridLayout(2, 5);

		chequeNumberLbl = new Label("Cheque No.");
		chequeNumberLbl.setImmediate(false);
		chequeDetailsGLayout.addComponent(chequeNumberLbl, 0, 0);

		chequeNumberTxtFld = new LoanTextField();
		chequeDetailsGLayout.addComponent(chequeNumberTxtFld, 1, 0);

		bankNameLbl = new Label("Bank Name");
		bankNameLbl.setImmediate(false);

		chequeDetailsGLayout.addComponent(bankNameLbl, 0, 1);

		bankNameTxtFld = new LoanTextField();
		chequeDetailsGLayout.addComponent(bankNameTxtFld, 1, 1);

		chequeDateLbl = new Label("Cheque Date");
		chequeDateLbl.setImmediate(false);
		chequeDetailsGLayout.addComponent(chequeDateLbl, 0, 2);

		chequeDateFld = new PopupDateField();
		chequeDateFld.setImmediate(true);
		chequeDateFld.setTextFieldEnabled(false);
		chequeDateFld.setDateFormat(StringConstants.DATE_FORMAT);
		chequeDetailsGLayout.addComponent(chequeDateFld, 1, 2);

		loanAccountNumberLbl = new Label("Loan Account Number");
		loanAccountNumberLbl.setImmediate(false);
		chequeDetailsGLayout.addComponent(loanAccountNumberLbl, 0, 3);

		loanAccountNumberTxtFld = new LoanTextField();
		chequeDetailsGLayout.addComponent(loanAccountNumberTxtFld, 1, 3);

		amountLbl = new Label("Amount Recieved");
		amountLbl.setImmediate(false);
		chequeDetailsGLayout.addComponent(amountLbl, 0, 4);

		amountTxtFld = new LoanTextField();
		chequeDetailsGLayout.addComponent(amountTxtFld, 1, 4);

		this.addComponent(chequeDetailsGLayout);

	}

	@Override
	public int validate() {

		int errors = 0;

		try {
			chequeNumberTxtFld.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			bankNameTxtFld.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			loanAccountNumberTxtFld.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			amountTxtFld.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}

		return errors;
	}

	public void addAllTextValidators() {

		// Step-1: Remove previous validators
		removeAllTextValidators();

		// Step-2: Add new validators
		chequeNumberTxtFld.addValidator(new StringLengthValidator(
				chequeNumberTxtFldErrorStr, 1, 100, false));

		bankNameTxtFld.addValidator(new StringLengthValidator(
				bankNameTxtFldErrorStr, 1, 100, false));

		loanAccountNumberTxtFld.addValidator(new StringLengthValidator(
				loanAccountNumberTxtFldErrorStr, 1, 100, false));

		amountTxtFld.addValidator(new StringLengthValidator(
				amountTxtFldErrorStr, 1, 100, false));

	}

	public void removeAllTextValidators() {

		chequeNumberTxtFld.removeAllValidators();
		bankNameTxtFld.removeAllValidators();
		loanAccountNumberTxtFld.removeAllValidators();
		amountTxtFld.removeAllValidators();

	}

}
