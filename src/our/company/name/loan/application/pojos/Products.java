package our.company.name.loan.application.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** This bean represents the "Types" of Vehicles */

@SuppressWarnings("serial")
@Entity
@Table(name = "PRODUCT_TABLE")
public class Products implements IMasterTablesPojo {

	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue
	public int productId;

	@Column(name = "VEHICLE_MAKE")
	public String vehicleMake;

	@Column(name = "VEHICLE_MODEL")
	public String vehicleModel;
	
	/** The Default Constructor */
	public Products() {

	}

	/**
	 * @param productId
	 * @param vehicleMake
	 * @param vehicleModel
	 * 
	 *            The Constructor
	 */
	public Products(int productId, String vehicleMake, String vehicleModel) {
		super();
		this.productId = productId;
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Products - [ productId=");
		builder.append(productId);
		builder.append(", vehicleMake=");
		builder.append(vehicleMake);
		builder.append(", vehicleModel=");
		builder.append(vehicleModel);
		builder.append(" ]");
		return builder.toString();
	}

}
