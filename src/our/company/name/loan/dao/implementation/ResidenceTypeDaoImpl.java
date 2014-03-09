package our.company.name.loan.dao.implementation;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import our.company.name.application.utils.BooleanAndMessages;
import our.company.name.loan.application.pojos.ResidenceType;
import our.company.name.loan.dao.ResidenceTypeDao;

@SuppressWarnings("serial")
public class ResidenceTypeDaoImpl implements ResidenceTypeDao {

	private SessionFactory sessionFactory;
	static Logger log = LoggerFactory.getLogger(ResidenceTypeDaoImpl.class);
	private Session session;

	/**
	 * @param sessionFactory
	 * 
	 *            The parameterized constructor
	 */
	private ResidenceTypeDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ResidenceType> getAllResidenceTypes() {

		List<ResidenceType> results = Collections.EMPTY_LIST;

		try {

			session = sessionFactory.openSession();

			String hqlQuery = new String("FROM ResidenceType ");

			log.info("Generated HQL Query = {}", hqlQuery.toString());

			Query query = session.createQuery(hqlQuery.toString());

			results = query.list();

			return results;

		} catch (Exception ex) {

			log.info("An exception has occured while getting Resident Types");
			log.info("Details = {} ", ex.getMessage());

			return results;

		} finally {
			session.close();
		}

	}

	@Override
	public BooleanAndMessages saveOrUpdateResidenceType(
			ResidenceType residenceType) {



		try {

			session = sessionFactory.openSession();
			session.saveOrUpdate(residenceType);

			return new BooleanAndMessages(true, "Saving Object Successful",
					"ResidenceType Object Saved/Updated Successfully");

		} catch (Exception ex) {

			log.error(
					"An error has occured while saving ResidenceType Object - {}",
					residenceType.toString());
			log.error("Error Details = {}", ex.getMessage());

			ex.printStackTrace();

			return new BooleanAndMessages(false, "Exception has occured",
					ex.getMessage());

		} finally {
			session.close();
		}
	}

	@Override
	public BooleanAndMessages deleteResidenceType(ResidenceType residenceType) {

		try {

			session = sessionFactory.openSession();

			session.delete(residenceType);

			return new BooleanAndMessages(true, "Object Deletion Successful",
					"ResidenceType Object Deleted Successfully");

		} catch (Exception ex) {

			log.error(
					"An error has occured while deleting ResidenceType Object - {}",
					residenceType.toString());
			log.error("Error Details = {}", ex.getMessage());

			return new BooleanAndMessages(false, "Exception has occured",
					ex.getMessage());

		} finally {
			session.close();
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

	/**
	 * 
	 * 
	 * The Default Constructor. It is kept private to prevent being accessed by
	 * other classes
	 */
	private ResidenceTypeDaoImpl() {

	}
}
