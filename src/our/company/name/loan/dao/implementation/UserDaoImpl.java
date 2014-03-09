package our.company.name.loan.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import our.company.name.loan.application.pojos.User;
import our.company.name.loan.dao.UserDao;

@SuppressWarnings("serial")
public class UserDaoImpl implements UserDao {

	static Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

	private SessionFactory sessionFactory;

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public User isValidUser(String userName, String password) {

		StringBuilder hqlQuery = new StringBuilder(
				"FROM User U WHERE U.email = '");
		hqlQuery.append(userName);
		hqlQuery.append("' and U.password = '");
		hqlQuery.append(password + "' ");

		log.info("Generated HQL Query = {}", hqlQuery.toString());

		Query query = sessionFactory.getCurrentSession().createQuery(
				hqlQuery.toString());

		List<User> results = query.list();
		User user = null;

		if (results.size() == 1) {

			user = results.get(0);
			user.setIsValidUser(true);

			log.info("User has provided correct credentials.");
			log.info("The details of the user as per our records are = {}",
					user.toString());

			return user;

		} else {

			log.info("The user has NOT provided CORRECT credentials.");

			user = new User();
			user.setIsValidUser(false);
			return user;
		}

	}

	/**
	 * The Default Constructor
	 */
	public UserDaoImpl() {

	}

	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



}
