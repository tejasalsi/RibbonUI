package our.company.name.loan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionDestroyEvent;
import com.vaadin.server.SessionDestroyListener;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinServlet;

@SuppressWarnings("serial")
@WebServlet(value = "/*", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = LoginUI.class, widgetset = "our.company.name.loan.widgetset.RibbonuiWidgetset")
public class LoginServlet extends VaadinServlet implements SessionInitListener,
		SessionDestroyListener {

	@Override
	protected void servletInitialized() throws ServletException {
		super.servletInitialized();
		getService().addSessionInitListener(this);
		getService().addSessionDestroyListener(this);
	}

	@Override
	public void sessionInit(SessionInitEvent event) throws ServiceException {
		System.out.println("The Session has been initialized");
	}

	@Override
	public void sessionDestroy(SessionDestroyEvent event) {
		System.out.println("The Session has been destroyed");
	}

}
