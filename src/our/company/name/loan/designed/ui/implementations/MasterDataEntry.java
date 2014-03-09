package our.company.name.loan.designed.ui.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import our.company.name.application.utils.CustomItems;
import our.company.name.loan.application.custom.ui.components.LoanMenuBar;
import our.company.name.loan.application.custom.ui.masterpages.ResidenceTypeGLayout;
import our.company.name.loan.application.custom.ui.masterpages.VehicleDetailsGLayout;
import our.company.name.loan.dao.MasterDataDao;
import our.company.name.loan.designed.ui.interfaces.INavigate;
import our.company.name.spring.SpringContextHelper;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class MasterDataEntry extends CustomComponent implements View, INavigate {

	static Logger log = LoggerFactory.getLogger(MasterDataEntry.class);

	private VerticalLayout mainVLayout;

	private LoanMenuBar loanMenu;

	private HorizontalLayout tableAndDataEntryHLayout;

	private GridLayout tableAndDataEntryGLayout;

	private Tree tree;

	private MasterDataDao masterDataDao = null;

	public static final String NAME = "Master-Data-Entry";

	public MasterDataEntry() {

		buildMainLayout();
		setCompositionRoot(mainVLayout);


		SpringContextHelper helper = new SpringContextHelper(VaadinServlet
				.getCurrent().getServletContext());

		this.masterDataDao = (MasterDataDao) helper.getBean("masterDataDao");

	}

	private VerticalLayout buildMainLayout() {

		mainVLayout = new VerticalLayout();
		mainVLayout.setImmediate(false);
		mainVLayout.setWidth("100%");
		mainVLayout.setHeight("100%");

		loanMenu = new LoanMenuBar();
		mainVLayout.addComponent(loanMenu, 0);

		tableAndDataEntryHLayout = buildTableAndDataEntryHLayout();
		mainVLayout.addComponent(tableAndDataEntryHLayout, 1);

		return mainVLayout;
	}

	private HorizontalLayout buildTableAndDataEntryHLayout() {
		tableAndDataEntryHLayout = new HorizontalLayout();
		tableAndDataEntryHLayout.setHeight("100%");
		tableAndDataEntryHLayout.setWidth("100%");

		tableAndDataEntryGLayout = buildTableAndDataEntryGLayout();

		tableAndDataEntryHLayout.addComponent(tableAndDataEntryGLayout);
		return tableAndDataEntryHLayout;
	}

	private GridLayout buildTableAndDataEntryGLayout() {

		tableAndDataEntryGLayout = new GridLayout(4, 3);
		tableAndDataEntryGLayout.setHeight("100%");
		tableAndDataEntryGLayout.setWidth("100%");

		tree = buildMasterPagesTree();
		tableAndDataEntryGLayout.addComponent(tree, 0, 0, 0, 2);

		return tableAndDataEntryGLayout;

	}

	private Tree buildMasterPagesTree() {
		tree = new Tree("Master Data Entry Pages");
		tree.setImmediate(true);

		CustomItems products = new CustomItems(1, "Products");
		tree.addItem(products);

		CustomItems residenceType = new CustomItems(2, "Residence-Type");
		tree.addItem(residenceType);

		CustomItems resaleProduct = new CustomItems(3, "Resale-Product");
		tree.addItem(resaleProduct);

		CustomItems repayMode = new CustomItems(4, "Repay-Mode");
		tree.addItem(repayMode);

		tree.addItemClickListener(new ItemClickEvent.ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {

				CustomItems ci = (CustomItems) event.getItemId();

				switch (ci.id) {
				case 1:

					// Step-1: Remove earlier component
					tableAndDataEntryGLayout.removeComponent(1, 0);

					// Step-2: Add new component
					VehicleDetailsGLayout vehicleDetailsGLayout = new VehicleDetailsGLayout(
							masterDataDao.getVehicleDetailsDao());

					tableAndDataEntryGLayout.addComponent(
							vehicleDetailsGLayout, 1, 0, 3, 2);

					break;

				case 2:

					// Step-1: Remove earlier component
					tableAndDataEntryGLayout.removeComponent(1, 0);

					// Step-2: Add new component
					ResidenceTypeGLayout residenceTypeGLayout = new ResidenceTypeGLayout(
							masterDataDao.getResidenceTypeDao());

					tableAndDataEntryGLayout.addComponent(residenceTypeGLayout,
							1, 0, 3, 2);

					break;

				case 3:
					Notification.show("Resale-Product", "was clicked",
							Type.HUMANIZED_MESSAGE);
					break;

				case 4:
					Notification.show("Repay-Mode", "was clicked",
							Type.HUMANIZED_MESSAGE);
					break;

				default:
					Notification.show("Please click on correct page name",
							Type.HUMANIZED_MESSAGE);

				}
			}
		});

		return tree;
	}

	@Override
	public void navigateTo(String vaadinPageName) {

	}

	@Override
	public void addAllButtonClickListeners() {

	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

}
