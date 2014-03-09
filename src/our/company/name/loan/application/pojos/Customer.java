package our.company.name.loan.application.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** This bean represents the details of "Loan Applicant" and "Guarantor" */

@SuppressWarnings("serial")
@Entity
@Table(name = "CUSTOMER_TABLE")
public class Customer implements ILoanData {

	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue
	public int customerId;
	
	@Column(name = "FIRST_NAME")
	public String firstName;
	
	@Column(name = "LAST_NAME")
	public String lastName;
	
	@Column(name = "RES_ADD")
	public String reidentialAddress;
	
	@Column(name = "PERMANENT_ADD")
	public String permanentAddress;
	
	@Column(name = "OFFICE_ADD")
	public String officeAddress;

	@Column(name = "TELEPHONE_NUMBER")
	public String landlineNumber;
	
	@Column(name = "MOBILE_NUMBER")
	public String mobileNUmber;
	
	@Column(name = "EMAIL")
	public String emailId;

	/** The Default Constructor */
	public Customer() {

	}

	/**
	 * @param customerId
	 * @param firstName
	 * @param lastName
	 * @param reidentialAddress
	 * @param permanentAddress
	 * @param officeAddress
	 * @param landlineNumber
	 * @param mobileNUmber
	 * @param emailId
	 * 
	 *            The Constructor
	 */
	public Customer(int customerId, String firstName, String lastName,
			String reidentialAddress, String permanentAddress,
			String officeAddress, String landlineNumber, String mobileNUmber,
			String emailId) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.reidentialAddress = reidentialAddress;
		this.permanentAddress = permanentAddress;
		this.officeAddress = officeAddress;
		this.landlineNumber = landlineNumber;
		this.mobileNUmber = mobileNUmber;
		this.emailId = emailId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getReidentialAddress() {
		return reidentialAddress;
	}

	public void setReidentialAddress(String reidentialAddress) {
		this.reidentialAddress = reidentialAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getLandlineNumber() {
		return landlineNumber;
	}

	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}

	public String getMobileNUmber() {
		return mobileNUmber;
	}

	public void setMobileNUmber(String mobileNUmber) {
		this.mobileNUmber = mobileNUmber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer - [ customerId=");
		builder.append(customerId);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", reidentialAddress=");
		builder.append(reidentialAddress);
		builder.append(", permanentAddress=");
		builder.append(permanentAddress);
		builder.append(", officeAddress=");
		builder.append(officeAddress);
		builder.append(", landlineNumber=");
		builder.append(landlineNumber);
		builder.append(", mobileNUmber=");
		builder.append(mobileNUmber);
		builder.append(", emailId=");
		builder.append(emailId);
		builder.append(" ]");
		return builder.toString();
	}

}
