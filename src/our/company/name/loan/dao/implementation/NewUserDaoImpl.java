package our.company.name.loan.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import our.company.name.application.utils.BooleanAndMessages;
import our.company.name.loan.application.enums.UserType;
import our.company.name.loan.application.pojos.User;
import our.company.name.loan.dao.EmailDao;
import our.company.name.loan.dao.NewUserDao;

@SuppressWarnings("serial")
public class NewUserDaoImpl implements NewUserDao {

	static Logger log = LoggerFactory.getLogger(NewUserDaoImpl.class);

	private EmailDao emailDao = null;

	private SessionFactory sessionFactory;

	/**
	 * The Default Constructor
	 */
	public NewUserDaoImpl() {

	}

	@Transactional
	@Override
	public BooleanAndMessages createNewUser(User user) {

		BooleanAndMessages emailStatusMessage = emailDao.isEmailIdUnique(
				user.email, UserType.NewUser);

		if (emailStatusMessage.state) {

			sessionFactory.getCurrentSession().save(user);

			return new BooleanAndMessages(true, "Congratulations..!!",
					"New User" + user.firstname + " Successfully Created");
		} else {

			return emailStatusMessage;
		}

	}

	@Transactional
	@Override
	public BooleanAndMessages updatePasswordOfExistingUser(String emailID,
			String newPassword) {

		BooleanAndMessages doesUserExists = emailDao.isEmailIdUnique(emailID,
				UserType.ForgotPasswordUser);

		if (doesUserExists.state) {

			StringBuilder getUserQuery = new StringBuilder(
					"FROM User U WHERE U.email = '");
			getUserQuery.append(emailID);
			getUserQuery.append("'");

			log.info("Generated HQL Query = {}", getUserQuery.toString());

			Query query = sessionFactory.getCurrentSession().createQuery(
					getUserQuery.toString());

			@SuppressWarnings("unchecked")
			List<User> results = query.list();

			User user = results.get(0);

			user.password = newPassword;

			sessionFactory.getCurrentSession().saveOrUpdate(user);
			
			return new BooleanAndMessages(true,
					"The password was changed successfully",
					"From now on use the new password");

		} else {

			// The email-ID does not exist.
			return doesUserExists;
		}

	}

	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public EmailDao getEmailDao() {
		return emailDao;
	}

	public void setEmailDao(EmailDao emailDao) {
		this.emailDao = emailDao;
	}

}
