package our.company.name.loan.application.custom.ui;

import our.company.name.loan.application.custom.ui.components.LoanTextField;
import our.company.name.loan.designed.ui.interfaces.IValidate;

import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

@SuppressWarnings("serial")
public class ProductDetailHLayout extends HorizontalLayout implements IValidate {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	private GridLayout loanDetailsGridLayout;

	private Label companyLbl;
	public LoanTextField companyNameTxtFld;

	private Label modelLbl;
	public LoanTextField modelNameTxtFld;

	private Label regNoLbl;
	public LoanTextField regNoTxtFld;

	private Label assetValueLbl;
	public LoanTextField assetValueTxtFld;

	private static String regNoTxtFldErrorStr = "Registration Number CANNOT be empty";
	private static String assetValueTxtFldErrorStr = "Asset Value CANNOT be empty";

	public ProductDetailHLayout() {

		this.setCaption("Vehicle Details");

		loanDetailsGridLayout = new GridLayout(4, 2);
		loanDetailsGridLayout.setImmediate(true);

		// First Row
		// companyLbl
		companyLbl = new Label("Brand");
		companyLbl.setImmediate(false);
		loanDetailsGridLayout.addComponent(companyLbl, 0, 0);

		// companyNameTxtFld
		companyNameTxtFld = new LoanTextField();
		companyNameTxtFld.setImmediate(false);
		companyNameTxtFld.setReadOnly(true);
		loanDetailsGridLayout.addComponent(companyNameTxtFld, 1, 0);

		// modelLbl
		modelLbl = new Label("Model");
		loanDetailsGridLayout.addComponent(modelLbl, 2, 0);

		// modelNameTxtFld
		modelNameTxtFld = new LoanTextField();
		modelNameTxtFld.setImmediate(true);
		modelNameTxtFld.setReadOnly(true);
		loanDetailsGridLayout.addComponent(modelNameTxtFld, 3, 0);

		// Second Row
		// regNoLbl
		regNoLbl = new Label("Registration Number");
		regNoLbl.setImmediate(false);
		loanDetailsGridLayout.addComponent(regNoLbl, 0, 1);

		// regNoTxtFld
		regNoTxtFld = new LoanTextField();
		loanDetailsGridLayout.addComponent(regNoTxtFld, 1, 1);

		// assetValueLbl
		assetValueLbl = new Label("Asset Value");
		assetValueLbl.setImmediate(true);
		loanDetailsGridLayout.addComponent(assetValueLbl, 2, 1);

		// assetValueTxtFld
		assetValueTxtFld = new LoanTextField();
		loanDetailsGridLayout.addComponent(assetValueTxtFld, 3, 1);

		this.addComponent(loanDetailsGridLayout);

	}

	@Override
	public int validate() {

		int errors = 0;

		try {
			assetValueTxtFld.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}

		try {
			regNoTxtFld.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}

		return errors++;

	}

	@Override
	public void removeAllTextValidators() {

		regNoTxtFld.removeAllValidators();
		assetValueTxtFld.removeAllValidators();

	}

	@Override
	public void addAllTextValidators() {
		// Step-1: Remove previous validators
		removeAllTextValidators();

		// Step-2: Add new validators
		regNoTxtFld.addValidator(new StringLengthValidator(regNoTxtFldErrorStr,
				1, 100, false));
		assetValueTxtFld.addValidator(new StringLengthValidator(
				assetValueTxtFldErrorStr, 1, 100, false));

	}

}