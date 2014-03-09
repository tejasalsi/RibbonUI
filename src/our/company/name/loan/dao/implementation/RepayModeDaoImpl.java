package our.company.name.loan.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import our.company.name.application.utils.BooleanAndMessages;
import our.company.name.loan.application.pojos.RepayMode;
import our.company.name.loan.dao.RepayModeDao;

@SuppressWarnings("serial")
public class RepayModeDaoImpl implements RepayModeDao {

	private SessionFactory sessionFactory;
	static Logger log = LoggerFactory.getLogger(RepayModeDaoImpl.class);

	@Override
	@SuppressWarnings("unchecked")
	public List<RepayMode> getAllRepayModes() {
		StringBuilder hqlQuery = new StringBuilder("FROM REPAY_MODE_TABLE ");

		log.info("Generated HQL Query = {}", hqlQuery.toString());

		Query query = sessionFactory.getCurrentSession().createQuery(
				hqlQuery.toString());

		List<RepayMode> results = query.list();

		return results;
	}

	@Override
	public BooleanAndMessages saveOrUpdateRepayMode(RepayMode repayMode) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(repayMode);

			return new BooleanAndMessages(true, "Saving Object Successful",
					"RepayMode Object Saved/Updated Successfully");

		} catch (Exception ex) {

			log.error(
					"An error has occured while saving RepayMode Object - {}",
					repayMode.toString());
			log.error("Error Details = {}", ex.getMessage());

			return new BooleanAndMessages(false, "Exception has occured",
					ex.getMessage());

		}
	}

	@Override
	public BooleanAndMessages deleteRepayMode(RepayMode repayMode) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.delete(repayMode);

			return new BooleanAndMessages(true, "Object Deletion Successful",
					"RepayMode Object Deleted Successfully");

		} catch (Exception ex) {

			log.error(
					"An error has occured while deleting RepayMode Object - {}",
					repayMode.toString());
			log.error("Error Details = {}", ex.getMessage());

			return new BooleanAndMessages(false, "Exception has occured",
					ex.getMessage());

		}
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
