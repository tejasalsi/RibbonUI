package our.company.name.loan.application.custom.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

@SuppressWarnings("serial")
public class LoanSubmitHLayout extends HorizontalLayout {

	public Button checkDataBtn;
	public Button submitBtn;

	public LoanSubmitHLayout() {

		checkDataBtn = new Button("Check Data");
		checkDataBtn.setImmediate(true);
		this.addComponent(checkDataBtn);

		submitBtn = new Button("Submit Details");
		submitBtn.setImmediate(true);
		submitBtn.setEnabled(false);
		this.addComponent(submitBtn);
		submitBtn
				.setDescription("Check all details before clicking on this button");

	}

}
