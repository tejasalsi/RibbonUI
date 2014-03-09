package our.company.name.loan.application.custom.ui;

import our.company.name.application.utils.SizeUtils;
import our.company.name.loan.application.custom.ui.components.LoanTextField;
import our.company.name.loan.designed.ui.interfaces.IValidate;

import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

@SuppressWarnings("serial")
public class LoanDetailsHLayout extends HorizontalLayout implements IValidate {

	private GridLayout loanDetailsGLayout;

	private Label loanAmountLbl;
	public LoanTextField loanAmountTxtFld;

	private Label loanTenureLbl;
	public LoanTextField loanTenureTxtFld;

	private Label loanInstallemntLbl;
	public LoanTextField loanInstallmentTxtFld;

	private Label rateOfInterestLbl;
	public LoanTextField rateOfInterestTxtFld;

	private static String loanAmountTxtFldErrorStr = "Loan Amount CANNOT be empty";
	private static String loanTenureTxtFldErrorStr = "Loan Tenure CANNOT be empty";
	private static String loanInstallmentTxtFldErrorStr = "Loan Installment CANNOT be empty";
	private static String rateOfInterestTxtFldErrorStr = "Rate of Interest CANNOT be empty";

	public LoanDetailsHLayout() {

		super();
		this.setCaption("Loan Details");

		// loanDetailsGLayout
		loanDetailsGLayout = new GridLayout(4, 2);
		loanDetailsGLayout.setImmediate(true);
		loanDetailsGLayout.setHeight(SizeUtils.HUNDRED,
				Sizeable.Unit.PERCENTAGE);
		loanDetailsGLayout
				.setWidth(SizeUtils.HUNDRED, Sizeable.Unit.PERCENTAGE);

		// First Row
		// loanAmountLbl
		loanAmountLbl = new Label("Loan Amount");
		loanAmountLbl.setImmediate(false);
		loanDetailsGLayout.addComponent(loanAmountLbl, 0, 0);

		// loanAmountTxtFld
		loanAmountTxtFld = new LoanTextField();
		loanDetailsGLayout.addComponent(loanAmountTxtFld, 1, 0);

		// loanTenureLbl
		loanTenureLbl = new Label("Loan Tenure");
		loanTenureLbl.setImmediate(false);
		loanDetailsGLayout.addComponent(loanTenureLbl, 2, 0);

		// loanTenureTxtFld
		loanTenureTxtFld = new LoanTextField();
		loanTenureTxtFld.setInputPrompt("in Months");
		loanDetailsGLayout.addComponent(loanTenureTxtFld, 3, 0);

		// Second Row
		// loanInstallemntLbl
		loanInstallemntLbl = new Label("Loan Installemnt");
		loanInstallemntLbl.setImmediate(false);
		loanDetailsGLayout.addComponent(loanInstallemntLbl, 0, 1);

		// loanInstallmentTxtFld
		loanInstallmentTxtFld = new LoanTextField();
		loanInstallmentTxtFld.setInputPrompt("EMI");

		loanDetailsGLayout.addComponent(loanInstallmentTxtFld, 1, 1);

		// rateOfInterestLbl
		rateOfInterestLbl = new Label("Rate of Interest");
		rateOfInterestLbl.setImmediate(false);
		loanDetailsGLayout.addComponent(rateOfInterestLbl, 2, 1);

		// rateOfInterestTxtFlds
		rateOfInterestTxtFld = new LoanTextField();
		rateOfInterestTxtFld.setInputPrompt("DONOT input '%' symbol");

		loanDetailsGLayout.addComponent(rateOfInterestTxtFld, 3, 1);

		this.addComponent(loanDetailsGLayout);
	}


	@Override
	public int validate() {
		int errors = 0;

		try {
			loanAmountTxtFld.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}

		try {
			loanTenureTxtFld.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}
		try {
			loanInstallmentTxtFld.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}

		try {
			rateOfInterestTxtFld.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}

		return errors;
	}

	@Override
	public void removeAllTextValidators() {

		loanAmountTxtFld.removeAllValidators();
		loanTenureTxtFld.removeAllValidators();
		loanInstallmentTxtFld.removeAllValidators();
		rateOfInterestTxtFld.removeAllValidators();

	}

	@Override
	public void addAllTextValidators() {

		// Step-1: Remove previous validators
		removeAllTextValidators();

		// Step-2: Add new validators
		loanAmountTxtFld.addValidator(new StringLengthValidator(
				loanAmountTxtFldErrorStr, 1, 100, false));
		loanTenureTxtFld.addValidator(new StringLengthValidator(
				loanTenureTxtFldErrorStr, 1, 100, false));
		loanInstallmentTxtFld.addValidator(new StringLengthValidator(
				loanInstallmentTxtFldErrorStr, 1, 100, false));
		rateOfInterestTxtFld.addValidator(new StringLengthValidator(
				rateOfInterestTxtFldErrorStr, 1, 100, false));
	}

}
