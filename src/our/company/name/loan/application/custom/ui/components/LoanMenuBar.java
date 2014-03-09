package our.company.name.loan.application.custom.ui.components;

import java.util.Set;

import our.company.name.application.utils.StringConstants;
import our.company.name.application.utils.WrappedSessionDiagnostics;
import our.company.name.loan.designed.ui.implementations.LoginView;
import our.company.name.loan.designed.ui.implementations.MasterDataEntry;
import our.company.name.loan.designed.ui.implementations.Tabbed;

import com.vaadin.server.ThemeResource;
import com.vaadin.server.WrappedSession;
import com.vaadin.ui.MenuBar;


@SuppressWarnings("serial")
public class LoanMenuBar extends MenuBar {

	public MenuItem newLoan, editLoan, masterDataEntry, logout;
	private WrappedSession wrappedSession;

	public LoanMenuBar() {
		super();

		this.setWidth(100.0f, Unit.PERCENTAGE);
		this.setHeight(10.0f, Unit.PERCENTAGE);
		this.setImmediate(true);
		this.setAutoOpen(false);

		// Add Individual Menu Items
		initializeMenuItems();

	}

	public void initializeMenuItems() {

		// New loan (Start)

		Command newLoanCommand = new MenuBar.Command() {

			@Override
			public void menuSelected(MenuItem selectedItem) {
				getUI().getNavigator().navigateTo(Tabbed.NAME);

			}

		};

		ThemeResource newLoanImage = new ThemeResource(
				"images/MenuBar-Images/New-Loan.png");

		newLoan = this.addItem("New Loan", newLoanImage, newLoanCommand);

		// New loan (End)

		newLoan.addSeparator();

		// Edit loan (Start)

		Command editLoanCommand = new MenuBar.Command() {

			@Override
			public void menuSelected(MenuItem selectedItem) {
				getUI().getNavigator().navigateTo(Tabbed.NAME);

			}

		};

		ThemeResource editIcon = new ThemeResource(
				"images/MenuBar-Images/Edit-Loan.png");

		editLoan = this.addItem("Edit Loan", editIcon, editLoanCommand);

		// Edit loan (End)

		// Master Data Entry (Start)
		Command masterDataEntryCommand = new Command() {

			@Override
			public void menuSelected(MenuItem selectedItem) {

				getUI().getNavigator().navigateTo(MasterDataEntry.NAME);

			}
		};

		ThemeResource masterDataEntryIcon = new ThemeResource(
				"images/MenuBar-Images/Master-Data.png");

		masterDataEntry = this.addItem("Master-Data-Entry",
				masterDataEntryIcon, masterDataEntryCommand);
		// Master Data Entry (End)

		// Logout (Start)
		Command logoutCommand = new Command() {

			@Override
			public void menuSelected(MenuItem selectedItem) {

				wrappedSession
						.removeAttribute(StringConstants.USER_ATTRIBUTE_NAME);

				Set<String> attributeNames = wrappedSession.getAttributeNames();

				WrappedSessionDiagnostics.printSetInformation(attributeNames);

				getUI().getNavigator().navigateTo(LoginView.NAME);

			}
		};

		ThemeResource logoutIcon = new ThemeResource(
				"images/MenuBar-Images/Logout.png");

		logout = this.addItem("Logout", logoutIcon, logoutCommand);

		// Logout (End)

	}

}
