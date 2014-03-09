package our.company.name.loan.application.custom.ui;

import our.company.name.application.utils.StringConstants;
import our.company.name.loan.application.custom.ui.components.LoanTextField;
import our.company.name.loan.designed.ui.interfaces.IValidate;

import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PaymentDetailsHLayout extends HorizontalLayout implements
		IValidate {

	private GridLayout paymentDetailsGLayout;

	private Label paymentDateLbl;
	public PopupDateField paymentDateFld;

	private Label chequeNumberLbl;
	public LoanTextField chequeNumberTxtFld;

	private Label beneficiaryLbl;
	public LoanTextField beneficiaryTxtFld;

	private Label startingRepaymentDateLbl;
	public PopupDateField startingRepaymentDateFld;

	private Label repayModeLbl;
	public VerticalLayout repayModeVLayout;

	public OptionGroup repaymodeOptionGroup;
	public final String CHEQUE = "Cheque";
	public final String CASH = "Cash";

	private static String chequeNumberTxtFldErrorStr = "Cheque Number CANNOT be empty";
	private static String beneficiaryTxtFldErrorStr = "Benificiary CANNOT be empty";

	// constructor
	public PaymentDetailsHLayout() {
		super();

		this.setCaption("Payment Details");
		this.setImmediate(false);
		this.setMargin(true);

		paymentDetailsGLayout = new GridLayout(2, 5);
		paymentDetailsGLayout.setImmediate(true);

		paymentDateLbl = new Label("Payment Date");
		paymentDateLbl.setImmediate(false);
		paymentDetailsGLayout.addComponent(paymentDateLbl, 0, 0);

		paymentDateFld = new PopupDateField();
		paymentDateFld.setImmediate(true);
		paymentDateFld.setTextFieldEnabled(false);
		paymentDateFld.setDateFormat(StringConstants.DATE_FORMAT);
		paymentDetailsGLayout.addComponent(paymentDateFld, 1, 0);

		chequeNumberLbl = new Label("Cheque No.");
		chequeNumberLbl.setImmediate(false);
		paymentDetailsGLayout.addComponent(chequeNumberLbl, 0, 1);

		chequeNumberTxtFld = new LoanTextField();
		paymentDetailsGLayout.addComponent(chequeNumberTxtFld, 1, 1);

		beneficiaryLbl = new Label("Beneficiary");
		beneficiaryLbl.setImmediate(false);
		paymentDetailsGLayout.addComponent(beneficiaryLbl, 0, 2);

		beneficiaryTxtFld = new LoanTextField();
		paymentDetailsGLayout.addComponent(beneficiaryTxtFld, 1, 2);

		startingRepaymentDateLbl = new Label("Starting RePayment Date");
		startingRepaymentDateLbl.setImmediate(false);
		paymentDetailsGLayout.addComponent(startingRepaymentDateLbl, 0, 3);

		startingRepaymentDateFld = new PopupDateField();
		startingRepaymentDateFld.setImmediate(true);
		startingRepaymentDateFld.setTextFieldEnabled(false);
		startingRepaymentDateFld.setDateFormat(StringConstants.DATE_FORMAT);
		paymentDetailsGLayout.addComponent(startingRepaymentDateFld, 1, 3);

		repayModeLbl = new Label("Repay Mode");
		repayModeLbl.setImmediate(false);
		paymentDetailsGLayout.addComponent(repayModeLbl, 0, 4);

		repayModeVLayout = new VerticalLayout();
		repaymodeOptionGroup = new OptionGroup();
		repaymodeOptionGroup.addStyleName("horizontalgroup");
		repaymodeOptionGroup.setImmediate(true);
		repaymodeOptionGroup.addItem(CHEQUE);
		repaymodeOptionGroup.addItem(CASH);
		repaymodeOptionGroup.setMultiSelect(false);
		repayModeVLayout.addComponent(repaymodeOptionGroup);
		paymentDetailsGLayout.addComponent(repayModeVLayout, 1, 4);

		this.addComponent(paymentDetailsGLayout);

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
			beneficiaryTxtFld.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}

		return errors++;

	}

	@Override
	public void removeAllTextValidators() {

		chequeNumberTxtFld.removeAllValidators();
		beneficiaryTxtFld.removeAllValidators();

	}

	@Override
	public void addAllTextValidators() {
		// Step-1: Remove previous validators
		removeAllTextValidators();

		// Step-2: Add new validators

		chequeNumberTxtFld.addValidator(new StringLengthValidator(
				chequeNumberTxtFldErrorStr, 1, 100, false));

		beneficiaryTxtFld.addValidator(new StringLengthValidator(
				beneficiaryTxtFldErrorStr, 1, 100, false));

	}

}
