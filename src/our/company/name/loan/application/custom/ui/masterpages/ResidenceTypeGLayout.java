package our.company.name.loan.application.custom.ui.masterpages;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vaadin.peter.contextmenu.ContextMenu;
import org.vaadin.peter.contextmenu.ContextMenu.ContextMenuItem;
import org.vaadin.peter.contextmenu.ContextMenu.ContextMenuOpenedListener;
import org.vaadin.peter.contextmenu.ContextMenu.ContextMenuOpenedOnTableFooterEvent;
import org.vaadin.peter.contextmenu.ContextMenu.ContextMenuOpenedOnTableHeaderEvent;
import org.vaadin.peter.contextmenu.ContextMenu.ContextMenuOpenedOnTableRowEvent;

import our.company.name.application.utils.BooleanAndMessages;
import our.company.name.loan.application.custom.ui.components.LoanTextField;
import our.company.name.loan.application.pojos.ResidenceType;
import our.company.name.loan.dao.ResidenceTypeDao;
import our.company.name.loan.designed.ui.interfaces.IValidate;

import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.Align;

@SuppressWarnings("serial")
public class ResidenceTypeGLayout extends GridLayout implements IValidate,
		IMasterPageUI {

	static Logger log = LoggerFactory.getLogger(ResidenceTypeGLayout.class);

	private Label residenceTypeLbl;
	public LoanTextField residenceTypeTxtFld;

	private Button saveResidenceTypeBtn;
	private Table residenceTypesTable;
	private ContextMenu tableContextMenu;
	private BeanContainer<Integer, ResidenceType> beanContainer;
	private ResidenceTypeDao residenceTypeDao;

	private String residenceTypeTxtFldErrorStr = "Residence Type CANNOT Be empty";

	public ResidenceTypeGLayout(ResidenceTypeDao residenceTypeDao) {
		super(2, 3);
		this.setHeight("100%");
		this.setWidth("100%");
		this.setSpacing(false);

		this.residenceTypeDao = residenceTypeDao;

		initializeUIComponents();

	}

	private void initializeUIComponents() {

		residenceTypeLbl = new Label("Residence Type");
		residenceTypeLbl.setImmediate(false);
		this.addComponent(residenceTypeLbl, 0, 0);

		residenceTypeTxtFld = new LoanTextField();
		residenceTypeTxtFld.addBlurListener(new BlurListener() {

			@Override
			public void blur(BlurEvent event) {
				log.info("Text Change Event was fired");

				int errors = 0;
				// Step-1: Add Text Validator
				addAllTextValidators();

				// Step-2: Validate Field
				errors = errors + validate();

				if (errors == 0) {
					// Step-3.1: If No error save in DB
					removeAllTextValidators();
					saveResidenceTypeBtn.setEnabled(true);

				} else {
					// Step-3.2: If error then notify the user
					removeAllTextValidators();
					saveResidenceTypeBtn.setEnabled(false);
				}

			}

		});

		this.addComponent(residenceTypeTxtFld, 1, 0);

		saveResidenceTypeBtn = new Button("Check & Save");
		saveResidenceTypeBtn.setImmediate(true);
		saveResidenceTypeBtn.setEnabled(false);
		saveResidenceTypeBtn.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				ResidenceType rt = new ResidenceType();
				rt.residenceType = residenceTypeTxtFld.getValue();

				BooleanAndMessages bAM = residenceTypeDao
						.saveOrUpdateResidenceType(rt);
				if (bAM.state == false) {
					Notification.show(bAM.priorityMessage1,
							bAM.priorityMessage2, Type.ERROR_MESSAGE);
				}

			}
		});

		this.addComponent(saveResidenceTypeBtn, 1, 1);

		// residenceTypesTable
		residenceTypesTable = buildResidenceTypesTable();
		this.addComponent(residenceTypesTable, 0, 2, 1, 2);

	}

	private Table buildResidenceTypesTable() {

		// Step-1: Create datasource for table
		List<ResidenceType> rtList = residenceTypeDao.getAllResidenceTypes();

		beanContainer = new BeanContainer<Integer, ResidenceType>(
				ResidenceType.class);

		// Use the name property as the item ID of the bean
		beanContainer.setBeanIdProperty("id");

		for (ResidenceType rt : rtList) {
			beanContainer.addBean(rt);
		}

		// Step-2: Create & configure a new table with datasource
		residenceTypesTable = configureResidenceTypesTable("Residence Table",
				beanContainer);

		tableContextMenu = buildContextMenuForResidenceTable();

		// tableContextMenu.setAsContextMenuOf(residenceTypesTable);
		// tableContextMenu.setAsTableContextMenu(residenceTypesTable);

		return residenceTypesTable;
	}

	private Table configureResidenceTypesTable(String caption,
			BeanContainer<Integer, ResidenceType> dataSource) {
		
		Table residenceTypesTable = new Table(caption, dataSource);
		
		residenceTypesTable.setHeight("100%");
		residenceTypesTable.setWidth("70%");

		residenceTypesTable.setColumnHeader("id", "Serial-Number");
		residenceTypesTable.setColumnAlignment("id", Align.CENTER);

		residenceTypesTable.setColumnHeader("residenceType", "Type");
		residenceTypesTable.setColumnAlignment("residenceType", Align.CENTER);

		residenceTypesTable.setColumnReorderingAllowed(false);
		residenceTypesTable.setSelectable(true);
		residenceTypesTable.setMultiSelect(false);

		return residenceTypesTable;
	}

	private ContextMenu buildContextMenuForResidenceTable() {
		tableContextMenu = new ContextMenu();

		// tableContextMenu.addItem("Edit");
		// tableContextMenu.addItem("Delete");

		ContextMenuItem edit = tableContextMenu.addItem("Edit");
		ContextMenuItem delete = tableContextMenu.addItem("Delete");



		ContextMenuOpenedListener.TableListener tableListener = new ContextMenuOpenedListener.TableListener() {

			public void onContextMenuOpenFromRow(
					ContextMenuOpenedOnTableRowEvent event) {

				log.info(event.getItemId().toString());

				// tableContextMenu.open(getCursorX(), getCursorY());
				


			}

			public void onContextMenuOpenFromHeader(
					ContextMenuOpenedOnTableHeaderEvent event) {
				// Notification.show("Click", "Header", Type.HUMANIZED_MESSAGE);
			}

			public void onContextMenuOpenFromFooter(
					ContextMenuOpenedOnTableFooterEvent event) {
				// Notification.show("Click", "Footer", Type.HUMANIZED_MESSAGE);
			}
		};


		tableContextMenu.addContextMenuTableListener(tableListener);
		tableContextMenu.setOpenAutomatically(false);
		tableContextMenu.setAsContextMenuOf(residenceTypesTable);



		return tableContextMenu;
	}

	@Override
	public int validate() {
		int errors = 0;

		try {
			residenceTypeTxtFld.validate();
		} catch (InvalidValueException exp) {
			errors++;
		}

		return errors;
	}

	@Override
	public void removeAllTextValidators() {
		residenceTypeTxtFld.removeAllValidators();
	}

	@Override
	public void addAllTextValidators() {

		// Step-1: Remove previous validators
		removeAllTextValidators();

		// Step-2: Add new validators
		residenceTypeTxtFld.addValidator(new StringLengthValidator(
				residenceTypeTxtFldErrorStr, 1, 100, false));

	}

	/**
	 * This getter method is kept private so that it is not used by other
	 * classes.
	 * 
	 * @return the residenceTypeDao
	 */
	private ResidenceTypeDao getResidenceTypeDao() {
		return residenceTypeDao;
	}

	/**
	 * This setter method is kept private so that it is not used by other
	 * classes. The ResidenceTypeDao object required for this object is to be
	 * specified in the constructor
	 * 
	 * @param residenceTypeDao
	 *            the residenceTypeDao to set
	 */
	private void setResidenceTypeDao(ResidenceTypeDao residenceTypeDao) {
		this.residenceTypeDao = residenceTypeDao;
	}




}
