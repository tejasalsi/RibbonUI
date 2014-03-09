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
public class CashDetailsHLayout extends HorizontalLayout implements IValidate {

	private GridLayout cashDetailsGLayout;

	private Label cashRecieptNumberLbl;
	public LoanTextField cashRecieptNumberTxtFld;

	private Label dateLbl;
	public PopupDateField dateFld;

	private Label loanAccountNumberLbl;
	public LoanTextField loanAccountNumberTxtFld;

	private Label amountLbl;
	public LoanTextField amountTxtFld;

	private static String cashRecieptNumberTxtFldErrorStr = "Cash Reciept Number CANNOT be empty";
	private static String loanAccountNumberTxtFldErrorStr = "Loan Account Number CANNOT be empty";
	private static String amountTxtFldErrorStr = "Amount CANNOT be empty";

	public CashDetailsHLayout() {
		super();
		this.setCaption("Cash Details");
		this.setMargin(true);

		cashDetailsGLayout = new GridLayout(2, 4);

		cashRecieptNumberLbl = new Label("Cash Reciept No.");
		cashRecieptNumberLbl.setImmediate(false);
		cashDetailsGLayout.addComponent(cashRecieptNumberLbl, 0, 0);

		cashRecieptNumberTxtFld = new LoanTextField();
		cashDetailsGLayout.addComponent(cashRecieptNumberTxtFld, 1, 0);

		dateLbl = new Label("Date");
		dateLbl.setImmediate(false);
		cashDetailsGLayout.addComponent(dateLbl, 0, 1);

		dateFld = new PopupDateField();
		dateFld.setImmediate(true);
		dateFld.setTextFieldEnabled(false);
		dateFld.setDateFormat(StringConstants.DATE_FORMAT);
		cashDetailsGLayout.addComponent(dateFld, 1, 1);

		loanAccountNumberLbl = new Label("Loan Account Number");
		loanAccountNumberLbl.setImmediate(false);
		cashDetailsGLayout.addComponent(loanAccountNumberLbl, 0, 2);

		loanAccountNumberTxtFld = new LoanTextField();
		cashDetailsGLayout.addComponent(loanAccountNumberTxtFld, 1, 2);

		amountLbl = new Label("Amount Recieved");
		amountLbl.setImmediate(false);
		cashDetailsGLayout.addComponent(amountLbl, 0, 3);

		amountTxtFld = new LoanTextField();
		cashDetailsGLayout.addComponent(amountTxtFld, 1, 3);

		this.addComponent(cashDetailsGLayout);

		addAllTextValidators();
	}

	@Override
	public int validate() {

		int errors = 0;

		try {
			cashRecieptNumberTxtFld.validate();
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

	@Override
	public void addAllTextValidators() {

		// Step-1: Remove previous validators
		removeAllTextValidators();

		// Step-2: Add new validators
		cashRecieptNumberTxtFld.addValidator(new StringLengthValidator(
				cashRecieptNumberTxtFldErrorStr, 1, 100, false));

		loanAccountNumberTxtFld.addValidator(new StringLengthValidator(
				loanAccountNumberTxtFldErrorStr, 1, 100, false));

		amountTxtFld.addValidator(new StringLengthValidator(
				amountTxtFldErrorStr, 1, 100, false));

	}

	@Override
	public void removeAllTextValidators() {

		cashRecieptNumberTxtFld.removeAllValidators();
		loanAccountNumberTxtFld.removeAllValidators();
		amountTxtFld.removeAllValidators();

	}

}
