package our.company.name.loan.application.custom.ui.components;

import com.vaadin.ui.TextArea;

@SuppressWarnings("serial")
public class LoanTextArea extends TextArea {

	public LoanTextArea() {
		super();
		setImmediate(true);
	}

	public LoanTextArea(String caption) {
		this();
		setCaption(caption);
	}

	public LoanTextArea(String caption, String value) {
		this();
		setCaption(caption);
		setValue(value);
	}

}
