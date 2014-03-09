package our.company.name.loan.application.custom.ui.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vaadin.peter.contextmenu.ContextMenu;
import org.vaadin.peter.contextmenu.ContextMenu.ContextMenuItem;

import our.company.name.loan.application.pojos.IMasterTablesPojo;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Table;

@SuppressWarnings("serial")
public class LoanMasterDetailsTable<K, V> extends Table {

	static Logger log = LoggerFactory.getLogger(LoanMasterDetailsTable.class);

	public ContextMenu menu = null;
	public ContextMenuItem editItem = null;
	public ContextMenuItem deleteItem = null;
	public ContextMenuItem refreshItem = null;
	public BeanContainer<K, V> dataSource;

	// When a row is selected in table, this object is instantiated
	private IMasterTablesPojo iMasterTablesPojo;

	public LoanMasterDetailsTable(String caption,
			final BeanContainer<K, V> dataSource) {
		// Step-1: Create the Vaadin Table
		super(caption, dataSource);
		this.dataSource = dataSource;

		// Step-2: Create the Custom Context Menu
		menu = new ContextMenu();
		ThemeResource editImage = new ThemeResource(
				"images/context-menu-images/edit.png");
		ThemeResource refreshImage = new ThemeResource(
				"images/context-menu-images/refresh.png");
		ThemeResource deleteImage = new ThemeResource(
				"images/context-menu-images/delete.png");
		editItem = menu.addItem("Edit", editImage);
		refreshItem = menu.addItem("Refresh", refreshImage);
		deleteItem = menu.addItem("Delete", deleteImage);

		addExtension(menu);

		// Step-3: Configure various properties of the Table
		this.setColumnReorderingAllowed(false);
		this.setSelectable(false);
		this.setImmediate(true);
		this.setMultiSelect(false);
		this.setHeight("100%");
		this.setWidth("100%");

	}

	public IMasterTablesPojo getiMasterTablesPojo(int id) {

		BeanItem beanItem = dataSource.getItem(id);

		IMasterTablesPojo iMasterTablesPojo = (IMasterTablesPojo) beanItem
				.getBean();

		return iMasterTablesPojo;
	}

	/** The Default Constructor. It has been deliberately kept "Private" */
	@SuppressWarnings("unused")
	private LoanMasterDetailsTable() {

	}
}
