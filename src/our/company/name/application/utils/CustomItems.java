package our.company.name.application.utils;

import java.util.Collection;

import com.vaadin.data.Item;
import com.vaadin.data.Property;

@SuppressWarnings("serial")
public class CustomItems implements Item {

	public int id;
	public String beanName = null;

	private CustomItems() {

	}

	/**
	 * @param id
	 * @param beanName
	 * 
	 *            The Constructor
	 */
	public CustomItems(int id, String beanName) {
		super();
		this.id = id;
		this.beanName = beanName;
	}


	@Override
	public Property getItemProperty(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<?> getItemPropertyIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addItemProperty(Object id, Property property)
			throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeItemProperty(Object id)
			throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return beanName;
	}

	public int getId() {
		return id;
	}

	public String getBeanName() {
		return beanName;
	}

}
