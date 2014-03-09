package our.company.name.loan.application.custom.ui.components;

import com.vaadin.data.Property;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class LoanTextField extends TextField {

	public LoanTextField() {
		super();
		this.setImmediate(true);
		this.setValidationVisible(true);

	}

	public LoanTextField(String caption) {
		super(caption);
		this.setImmediate(true);
		this.setValidationVisible(true);
	}

	public LoanTextField(String caption, String value) {
		super(caption, value);
		this.setImmediate(true);
		this.setValidationVisible(true);
	}

	public LoanTextField(String caption, Property<?> property) {
		super(caption, property);
		this.setImmediate(true);
		this.setValidationVisible(true);
	}

	public LoanTextField(Property<?> property) {
		super(property);
		this.setImmediate(true);
		this.setValidationVisible(true);
	}

}
