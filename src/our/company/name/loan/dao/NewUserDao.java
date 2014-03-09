package our.company.name.loan.dao;

import our.company.name.application.utils.BooleanAndMessages;
import our.company.name.loan.application.pojos.User;

public interface NewUserDao extends GenericDao {


	/**
	 * This method will create a new user in DB.
	 * */
	public BooleanAndMessages createNewUser(User user);

	/**
	 * This method will check whether a user with given email-ID exists in DB.
	 * If the user exists, then user's existing password will be replaced with
	 * the given password .
	 * 
	 * If the user does not exist, then appropriate message will be sent in
	 * BooleanAndMessages object.
	 * */
	public BooleanAndMessages updatePasswordOfExistingUser(String emailID,
			String newPassword);

}
