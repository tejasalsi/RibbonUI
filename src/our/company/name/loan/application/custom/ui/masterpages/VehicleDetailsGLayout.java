package our.company.name.loan.application.custom.ui.masterpages;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vaadin.peter.contextmenu.ContextMenu.ContextMenuItemClickEvent;
import org.vaadin.peter.contextmenu.ContextMenu.ContextMenuItemClickListener;

import our.company.name.application.utils.BooleanAndMessages;
import our.company.name.application.utils.StringUtil;
import our.company.name.loan.application.custom.ui.components.LoanMasterDetailsTable;
import our.company.name.loan.application.custom.ui.components.LoanTextField;
import our.company.name.loan.application.pojos.VehicleDetails;
import our.company.name.loan.dao.VehicleDetailsDao;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.event.FieldEvents.FocusEvent;
import com.vaadin.event.FieldEvents.FocusListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.Align;

@SuppressWarnings("serial")
public class VehicleDetailsGLayout<V, K> extends GridLayout implements
		IMasterPageUI {

	static Logger log = LoggerFactory.getLogger(VehicleDetailsGLayout.class);

	private VehicleDetailsDao vehicleDetailsDao;

	private Label companyNameLbl;
	public LoanTextField companyNameTxtFld;

	private Label vehicleNameLbl;
	public LoanTextField vehicleNameTxtFld;

	private Button addNewDataBtn;
	private Button editAndSaveBtn;

	public OptionGroup addOrEditOptionGroup;
	public final String addVehicles = "Add New Vehicles";
	public final String editVehicles = "Edit Existing Vehicles";

	private LoanMasterDetailsTable<K, V> table;
	private BeanContainer<Integer, VehicleDetails> beanContainer;

	private VehicleDetails details;
	private VehicleTableValueChangeListener listener;

	public VehicleDetailsGLayout(VehicleDetailsDao vehicleDetailsDao) {
		super(4, 4);
		this.setHeight("100%");
		this.setWidth("100%");
		this.setSpacing(false);

		this.vehicleDetailsDao = vehicleDetailsDao;
		this.listener = new VehicleTableValueChangeListener();

		initializeUIComponents();

	}

	private void initializeUIComponents() {

		companyNameLbl = new Label("Company Name");
		companyNameLbl.setImmediate(false);
		this.addComponent(companyNameLbl, 0, 0);

		companyNameTxtFld = new LoanTextField();
		companyNameTxtFld.setEnabled(false);
		this.addComponent(companyNameTxtFld, 1, 0);

		vehicleNameLbl = new Label("Vehicle Name");
		vehicleNameLbl.setImmediate(false);
		this.addComponent(vehicleNameLbl, 2, 0);

		vehicleNameTxtFld = new LoanTextField();
		vehicleNameTxtFld.setEnabled(false);
		this.addComponent(vehicleNameTxtFld, 3, 0);

		addNewDataBtn = new Button("Add New Vehicle");
		addNewDataBtn.setImmediate(true);
		addNewDataBtn.setEnabled(false);
		this.addComponent(addNewDataBtn, 0, 1, 1, 1);

		editAndSaveBtn = new Button("Save Edited Vehicle");
		editAndSaveBtn.setImmediate(true);
		editAndSaveBtn.setEnabled(false);
		this.addComponent(editAndSaveBtn, 2, 1, 3, 1);

		addOrEditOptionGroup = new OptionGroup();
		addOrEditOptionGroup.addStyleName("horizontalgroup");
		addOrEditOptionGroup.setImmediate(true);
		addOrEditOptionGroup.addItem(addVehicles);
		addOrEditOptionGroup.addItem(editVehicles);
		addOrEditOptionGroup.setMultiSelect(false);
		this.addComponent(addOrEditOptionGroup, 1, 2, 2, 2);

		table = buildVehicleDetailsTable();
		this.addComponent(table, 0, 3, 3, 3);

		addAllListeners();

	}

	private void addAllListeners() {

		// Listener for Check Boxes
		this.addOrEditOptionGroup
				.addValueChangeListener(new ValueChangeListener() {

					@Override
					public void valueChange(ValueChangeEvent event) {

						String radioButtonValue = (String) addOrEditOptionGroup
								.getValue();

						System.out.println(radioButtonValue);

						if (radioButtonValue
								.equals(VehicleDetailsGLayout.this.addVehicles)) {
							/*
							 * NOTE: User wants to ADD NEW VALUE the vehicles
							 * table
							 */
							table.removeValueChangeListener(listener);
							table.setSelectable(false);

							addNewDataBtn.setVisible(true);
							addNewDataBtn.setEnabled(true);

							editAndSaveBtn.setVisible(false);
							editAndSaveBtn.setEnabled(false);

							companyNameTxtFld.setEnabled(true);
							vehicleNameTxtFld.setEnabled(false);

						} else {
							/*
							 * NOTE: User wants to EDIT EXISTING VALUE in
							 * vehicles table
							 */
							table.addValueChangeListener(listener);
							table.setSelectable(true);

							addNewDataBtn.setVisible(false);
							addNewDataBtn.setEnabled(false);

							editAndSaveBtn.setVisible(true);
							editAndSaveBtn.setEnabled(true);

							companyNameTxtFld.setEnabled(true);
							vehicleNameTxtFld.setEnabled(false);

						}
					}
				});

		// Listeners for items in context menu
		table.editItem.addItemClickListener(new ContextMenuItemClickListener() {

			public void contextMenuItemClicked(ContextMenuItemClickEvent event) {

				Notification.show("Edit Not Yet Supported",
						"Contact the Developer", Type.ERROR_MESSAGE);

			}
		});

		table.refreshItem
				.addItemClickListener(new ContextMenuItemClickListener() {

					@Override
					public void contextMenuItemClicked(
							ContextMenuItemClickEvent event) {

						VehicleDetailsGLayout.this.refreshTable();
					}
				});

		table.deleteItem
				.addItemClickListener(new ContextMenuItemClickListener() {

					public void contextMenuItemClicked(
							ContextMenuItemClickEvent event) {

						Notification.show("Delete Not Yet Supported",
								"Contact the Developer", Type.ERROR_MESSAGE);
					}
				});

		// Listeners for Buttons
		addNewDataBtn.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				// Step-1: Create a simple VehicleDetails Object
				VehicleDetails newDetails = new VehicleDetails(
						companyNameTxtFld.getValue(), vehicleNameTxtFld
								.getValue());

				// Step-2: Check whether same object exists in DB
				boolean bool = doesObjectExistInBeanContainer(newDetails);

				// Step-3: Depending upon the "bao.bool", we decide
				// the next course of action

				if (bool) {

					Notification.show("Vehicle Already Exists",
							"Please provide details of new Vehicle",
							Type.TRAY_NOTIFICATION);
				} else {
					BooleanAndMessages bam = vehicleDetailsDao
							.saveVehicleDetails(newDetails);
					if (bam.state) {
						Notification.show(bam.priorityMessage1,
								bam.priorityMessage2, Type.TRAY_NOTIFICATION);

						VehicleDetailsGLayout.this.refreshTable();
					} else {
						// Some error has occurred
						Notification.show(bam.priorityMessage1,
								bam.priorityMessage2, Type.ERROR_MESSAGE);
					}
				}
			}
		});

		editAndSaveBtn.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				// Step-1: Create a simple VehicleDetails Object
				VehicleDetails newDetails = new VehicleDetails(
						companyNameTxtFld.getValue(), vehicleNameTxtFld
								.getValue());

				// Step-2: Check whether same object exists in DB
				boolean bool = doesObjectExistInBeanContainer(newDetails);

				// Step-3: Depending upon the "bao.bool", we decide
				// the next course of action

				if (bool) {

					Notification.show("Vehicle Already Exists",
							"Please provide details of new Vehicle",
							Type.TRAY_NOTIFICATION);
				} else {
					if (details != null) {
						newDetails.id = details.id;
						BooleanAndMessages bam = vehicleDetailsDao
								.updateVehicleDetails(newDetails);
						if (bam.state) {
							Notification.show(bam.priorityMessage1,
									bam.priorityMessage2,
									Type.TRAY_NOTIFICATION);


							VehicleDetailsGLayout.this.refreshTable();
						} else {
							// Some error has occurred
							Notification.show(bam.priorityMessage1,
									bam.priorityMessage2, Type.ERROR_MESSAGE);
						}

					}
				}
			}
		});

		// Text Field Listeners
		companyNameTxtFld.addFocusListener(new FocusListener() {

			@Override
			public void focus(FocusEvent event) {
				// vehicleNameTxtFld.setEnabled(false);
			}
		});

		companyNameTxtFld.addBlurListener(new BlurListener() {
			@Override
			public void blur(BlurEvent event) {

				String formattedString = StringUtil
						.setFirstWordCapitaCase(companyNameTxtFld.getValue());

				if (formattedString != null) {
					companyNameTxtFld.setValue(formattedString);
				} else {
					companyNameTxtFld.focus();
				}
				if (!StringUtils.isBlank(formattedString)) {
					companyNameTxtFld.setValue(formattedString);
					vehicleNameTxtFld.setEnabled(true);
				} else {
					companyNameTxtFld.focus();
				}
			}
		});

		vehicleNameTxtFld.addBlurListener(new BlurListener() {

			@Override
			public void blur(BlurEvent event) {

				String formattedString = StringUtil
						.setFirstWordCapitaCase(vehicleNameTxtFld.getValue());

				if (formattedString != null) {
					vehicleNameTxtFld.setValue(formattedString);
				} else {
					vehicleNameTxtFld.focus();
				}
				if (!StringUtils.isBlank(formattedString)) {
					vehicleNameTxtFld.setValue(formattedString);
				} else {
					vehicleNameTxtFld.focus();
				}

			}
		});

	}

	public boolean doesObjectExistInBeanContainer(VehicleDetails newDetails) {
		/*
		 * Step-1: Check whether an object with same value exists within the
		 * beanContainer
		 */
		List<Integer> idList = beanContainer.getItemIds();
		BeanItem<VehicleDetails> beanItem = null;
		VehicleDetails vd = null;
		boolean isEqual = false;
		for (Integer id : idList) {
			/*
			 * Get the corresponding VehicleDetails object in the beanContainer
			 */
			beanItem = beanContainer.getItem(id);
			vd = beanItem.getBean();

			// Step-2: Check whether the two objects have equal values
			isEqual = vd.equals(newDetails);

			if (isEqual) {
				/*
				 * Step-3.1: We found an object in beanContainer that has same
				 * values as that of our new object. We CANNOT NOT insert the
				 * object into DB. We will break the loop.
				 */
				log.info("VehicleDetails in DB = {}", vd.toString());
				log.info("VehicleDetails given by User = {}",
						newDetails.toString());
				log.info("We CANNOT NOT insert the object into DB.");

				return true;
			}

		}// End of for-each loop

		/*
		 * Step-3.2: We found that an NO SUCH Object exists in DB. We CAN safely
		 * insert the new object into DB.
		 */
		log.info("We CAN insert the object into DB.");
		return false;

	}

	private LoanMasterDetailsTable<K, V> buildVehicleDetailsTable() {

		// Step-1: Create the bean container
		beanContainer = constructBeanContainer();

		// Step-2: Create & configure a new table with datasource
		table = (LoanMasterDetailsTable<K, V>) configureVehicleDetailsTable(
				"Vehicle Details", beanContainer);

		return table;
	}

	private Table configureVehicleDetailsTable(String caption,
			BeanContainer<Integer, VehicleDetails> dataSource) {

		Table vehicleDetailsTable = new LoanMasterDetailsTable<Integer, VehicleDetails>(
				caption, dataSource);

		vehicleDetailsTable.setHeight("100%");
		vehicleDetailsTable.setWidth("70%");

		vehicleDetailsTable.setColumnHeader("id", "Serial-Number");
		vehicleDetailsTable.setColumnAlignment("id", Align.CENTER);

		vehicleDetailsTable.setColumnHeader("make", "Compnay");
		vehicleDetailsTable.setColumnAlignment("make", Align.LEFT);

		vehicleDetailsTable.setColumnHeader("model", "Model");
		vehicleDetailsTable.setColumnAlignment("model", Align.LEFT);

		return vehicleDetailsTable;
	}

	public LoanMasterDetailsTable<K, V> refreshTable() {

		// Step-1: Remove the value change listener of the table
		VehicleDetailsGLayout.this.table.removeValueChangeListener(listener);

		// Step-2: Flush current beanContainer
		beanContainer.removeAllItems();
		beanContainer = null;

		// Step-3: Construct beanContainer
		beanContainer = constructBeanContainer();

		// Step-4: Set new beanContainer to Table
		table.setContainerDataSource(beanContainer);

		return table;

	}

	private BeanContainer<Integer, VehicleDetails> constructBeanContainer() {
		// Step-1: Create datasource for table
		List<VehicleDetails> vdList = vehicleDetailsDao.getAllVehicleDetails();

		beanContainer = new BeanContainer<Integer, VehicleDetails>(
				VehicleDetails.class);

		// Use the name property as the item ID of the bean
		beanContainer.setBeanIdProperty("id");

		// Step-2: Populate beanContainer
		for (VehicleDetails vd : vdList) {
			beanContainer.addBean(vd);
		}

		return beanContainer;

	}

	private class VehicleTableValueChangeListener implements
			ValueChangeListener {

		/** The Default Constructor */
		VehicleTableValueChangeListener() {
		}

		@Override
		public void valueChange(ValueChangeEvent event) {

			int id = Integer.parseInt(table.getValue().toString());

			details = (VehicleDetails) table.getiMasterTablesPojo(id);

			companyNameTxtFld.setEnabled(true);
			companyNameTxtFld.setValue(details.make);

			vehicleNameTxtFld.setEnabled(true);
			vehicleNameTxtFld.setValue(details.model);

			log.info("Vehicle = {}", details.toString());

		}
	} // End of Class VehicleTableValueChangeListener

}// End of class VehicleDetailsGLayout
