package our.company.name.loan.designed.ui.interfaces;

public interface IValidate {

	/**
	 * This method validates the fields and returns the number of error fields
	 * in a component. If error = 0, then it means that there are no errors in
	 * child components.
	 * */
	public int validate();

	public void removeAllTextValidators();

	public void addAllTextValidators();

}
