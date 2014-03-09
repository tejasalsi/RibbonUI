package our.company.name.loan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import our.company.name.loan.designed.ui.implementations.ForgotPasswordView;
import our.company.name.loan.designed.ui.implementations.HomePage;
import our.company.name.loan.designed.ui.implementations.LoginView;
import our.company.name.loan.designed.ui.implementations.MasterDataEntry;
import our.company.name.loan.designed.ui.implementations.NewUserView;
import our.company.name.loan.designed.ui.implementations.Tabbed;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("loantheme")
public class LoginUI extends UI {

	static Logger log = LoggerFactory.getLogger(LoginUI.class);

	@Override
	protected void init(VaadinRequest request) {

		/*
		 * TextArea area = new ContextMenuTextArea(); area.setWidth(200,
		 * Unit.PIXELS); area.setHeight(100, Unit.PIXELS); setContent(area);
		 */

		//
		// Create a new instance of the navigator. The navigator will attach
		// itself automatically to this view.
		//

		new Navigator(this, this);

		//
		// The initial log view where the user can login to the application
		//
		// getNavigator().addView(SimpleLoginView.NAME, SimpleLoginView.class);
		getNavigator().addView(LoginView.NAME, LoginView.class);

		//
		// Add the main view of the application
		//
		// getNavigator().addView(SimpleLoginMainView.NAME,
		// SimpleLoginMainView.class);

		getNavigator().addView(HomePage.NAME, HomePage.class);

		getNavigator().addView(NewUserView.NAME, NewUserView.class);

		getNavigator().addView(ForgotPasswordView.NAME,
				ForgotPasswordView.class);

		getNavigator().addView(Tabbed.NAME, Tabbed.class);

		getNavigator().addView(MasterDataEntry.NAME, MasterDataEntry.class);

		//
		// We use a view change handler to ensure the user is always redirected
		// to the login view if the user is not logged in.
		//

		getNavigator().navigateTo(HomePage.NAME);
	}
}