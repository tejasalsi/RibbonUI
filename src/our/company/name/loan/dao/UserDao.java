package our.company.name.loan.dao;

import our.company.name.loan.application.pojos.User;

public interface UserDao extends GenericDao {

	public User isValidUser(String userName, String password);



}
