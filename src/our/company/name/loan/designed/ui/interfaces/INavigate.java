package our.company.name.loan.designed.ui.interfaces;



public interface INavigate {

	public void navigateTo(String vaadinPageName);
	
	/**
	 * All button click listeners should be added in this method. The call to
	 * method must be the last line in constructor. This method is used to
	 * ensure that all the button click listeners are present in one place and
	 * it will reduce the code length of constructor.
	 * */
	public void addAllButtonClickListeners();

}
