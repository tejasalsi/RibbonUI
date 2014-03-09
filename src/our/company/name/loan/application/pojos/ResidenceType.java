package our.company.name.loan.application.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "residence_table")
public class ResidenceType implements IMasterTablesPojo {

	@Id
	@Column(name = "RESIDENCE_ID")
	@GeneratedValue
	public int id;

	@Column(name = "RESIDENCE_TYPE", nullable = false)
	public String residenceType;

	public ResidenceType() {

	}

	/**
	 * @param id
	 * @param residenceType
	 * 
	 *            The Constructor
	 */
	public ResidenceType(int id, String residenceType) {

		this.id = id;
		this.residenceType = residenceType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResidenceType() {
		return residenceType;
	}

	public void setResidenceType(String residenceType) {
		this.residenceType = residenceType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResidenceTypeGLayout - [ id=");
		builder.append(id);
		builder.append(", residenceType=");
		builder.append(residenceType);
		builder.append(" ]");
		return builder.toString();
	}
	
}
