package our.company.name.loan.application.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class User implements Serializable {
	
	@Id
	@Column(name = "Id")
	@GeneratedValue
	private Integer id;

	@Column(name = "Firstname")
	public String firstname;

	@Column(name = "Lastname")
	public String lastname;

	@Column(name = "Email")
	public String email;

	@Column(name = "Mobile")
	public String mobile;
	
	@Column(name = "Password")
	public String password;

	/**
	 * This boolean field, 'isValidUser', is used for some internal application
	 * logic.It has no corresponding field for database.Hence it has been marked
	 * as 'Transient'
	 * */
	@Transient
	private boolean isValidUser;

	/**
	 * This is the default constructor
	 * 
	 */
	public User() {

	}

	/**
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param mobile
	 * @param password
	 * @param isValidUser
	 * 
	 *            This is another constructor with a few parameters
	 * 
	 */
	public User(Integer id, String firstname, String lastname, String email,
			String mobile, String password) {

		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile = mobile;
		this.password = password;

	}

	public Integer getId() {
		return id;
	}

	/*
	 * This ID is auto generated. There should not be any way to set this ID
	 * from outside. public void setId(Integer id) { this.id = id; }
	 */

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isValidUser() {
		return isValidUser;
	}

	public void setIsValidUser(boolean isValidUser) {
		this.isValidUser = isValidUser;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User - [ id=");
		builder.append(id);
		builder.append(", firstname=");
		builder.append(firstname);
		builder.append(", lastname=");
		builder.append(lastname);
		builder.append(", email=");
		builder.append(email);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", password=");
		builder.append(password);
		builder.append(", isValidUser=");
		builder.append(isValidUser);
		builder.append(" ]");
		return builder.toString();
	}



}
