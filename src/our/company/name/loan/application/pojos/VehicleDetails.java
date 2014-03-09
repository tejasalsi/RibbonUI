package our.company.name.loan.application.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name = "PRODUCT_TABLE")
public class VehicleDetails implements IMasterTablesPojo {

	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	@Column(name = "PRODUCT_ID", unique = true, nullable = false)
	public int id;

	@Column(name = "VEHICLE_COMPANY")
	public String make;

	@Column(name = "VEHICLE_MODEL")
	public String model;

	/** The Default Constructor */
	public VehicleDetails() {

	}

	/**
	 * @param id
	 * @param make
	 *            - First Letter should be in UPPERCASE, followed by lower case.
	 *            letters (Eg: "Honda"). Such a "formatted" String should be
	 *            provided by UI Layer.
	 * @param model
	 *            - First Letter should be in UPPERCASE, followed by lower case
	 *            letters.(Eg: "Dio") Such a "formatted" String should be
	 *            provided by UI Layer.
	 * 
	 *            The Parameterized Constructor
	 * 
	 */
	public VehicleDetails(String make, String model) {
		this.make = make;
		this.model = model;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleDetails other = (VehicleDetails) obj;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehicleDetails - [ id=");
		builder.append(id);
		builder.append(", make=");
		builder.append(make);
		builder.append(", model=");
		builder.append(model);
		builder.append(" ]");
		return builder.toString();
	}

}



