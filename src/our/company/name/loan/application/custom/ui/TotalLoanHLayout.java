package our.company.name.loan.application.custom.ui;

import our.company.name.loan.application.custom.ui.components.LoanTextField;
import our.company.name.loan.application.enums.PaymentMethod;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;

@SuppressWarnings("serial")
public class TotalLoanHLayout extends HorizontalLayout {

	public LoanTextField totalLoanTxtFld;
	public Table summaryTable;

	public TotalLoanHLayout() {
		super();

		this.setCaption(" Total Loan ");

		totalLoanTxtFld = new LoanTextField();
		totalLoanTxtFld.setReadOnly(true);
		totalLoanTxtFld.setInputPrompt(" in INR ");
		this.addComponent(totalLoanTxtFld);

	}

	public TotalLoanHLayout(PaymentMethod paymentMethod) {
		// Step - 1) Call the default constructor and initialize the object
		this();

		// Step -2 ) Determine the type of payment method and construct table
		// accordingly

		summaryTable = buildSummaryTable(paymentMethod);
		this.addComponent(summaryTable);

	}

	private Table buildSummaryTable(PaymentMethod paymentMethod) {

		Table table = null;

		switch (paymentMethod) {
		case CASH:
			table = buildCashSummaryTable();
			break;

		case CHEQUE:
			table = buildChequeSummaryTable();
			break;
		}

		return table;
	}

	private Table buildChequeSummaryTable() {


		Table table = new Table();

		// We only need a "read-only" table
		table.setSelectable(false);
		table.setSortEnabled(false);

		table.addContainerProperty("Dues + Surcharges", String.class, null);
		table.addContainerProperty("Amount", String.class, null);

		/* Add a few items in the table. */
		// First Row in Table
		String emivalue = "7500";
		table.addItem(new Object[] { "EMI", emivalue }, 1);

		// Second Row in Table
		String chequeBounceSurchargeStr = "500";
		table.addItem(new Object[] { "Previous Cheque Bounce Surcharge",
				chequeBounceSurchargeStr }, 2);

		// Third row in table
		String surchargeStr = "1500";
		table.addItem(new Object[] { "Late Payment Surcharge", surchargeStr },
				3);

		// Fourth row in table
		String totalStr = "10,000";
		table.addItem(new Object[] { "Total Due", totalStr }, 4);

		return table;
	}

	private Table buildCashSummaryTable() {

		Table table = new Table();
		// We only need a "read-only" table
		table.setSelectable(false);

		return table;
	}

	/*
	 * 1,00,00,00,000 -> 10 digits
	 * 
	 * 3. Reciept number in cash layout is alphanumeric (format not known)
	 * 
	 * 4.A small table - principle amount , any surcharges, previous cheque
	 * bouncing charges Principle outstanding, cash handling charge, delay
	 * charges, company loan approvals (extra loan amount)
	 * 
	 * 5. Cash handling charge - master.
	 * 
	 * 6. Increase spacing between cash/cheque and loan details.
	 */

}
