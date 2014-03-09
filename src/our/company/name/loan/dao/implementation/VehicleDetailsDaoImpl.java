package our.company.name.loan.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import our.company.name.application.utils.BooleanAndMessages;
import our.company.name.loan.application.pojos.VehicleDetails;
import our.company.name.loan.dao.VehicleDetailsDao;

@SuppressWarnings("serial")
public class VehicleDetailsDaoImpl implements VehicleDetailsDao {

	private SessionFactory sessionFactory;
	static Logger log = LoggerFactory.getLogger(VehicleDetailsDaoImpl.class);

	@Override
	@SuppressWarnings("unchecked")
	public List<VehicleDetails> getAllVehicleDetails() {
		StringBuilder hqlQuery = new StringBuilder("FROM VehicleDetails ");

		log.info("Generated HQL Query = {}", hqlQuery.toString());

		Query query = sessionFactory.getCurrentSession().createQuery(
				hqlQuery.toString());

		List<VehicleDetails> results = query.list();

		return results;
	}

	@Override
	public BooleanAndMessages saveVehicleDetails(
			VehicleDetails vehicleDetail) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.save(vehicleDetail);

			log.info("Added = {}", vehicleDetail.toString());

			return new BooleanAndMessages(true, "Success",
					"Vehicle Successfully Saved in Database");

		} catch (Exception ex) {

			log.error("An error has occured while saving Vehicle - {}",
					vehicleDetail.toString());
			log.error("Problem = {}", ex.getMessage());

			return new BooleanAndMessages(false, "Vehicle Not Added",
					ex.getMessage());

		}
	}

	@Override
	public BooleanAndMessages updateVehicleDetails(VehicleDetails vehicleDetail) {
		try {

			Session session = this.sessionFactory.getCurrentSession();

			session.update(vehicleDetail);
			log.info("Updated = {}", vehicleDetail.toString());

			return new BooleanAndMessages(true, "Success",
					"Vehicle Successfully Edited & Saved in Database");

		} catch (Exception ex) {

			log.error("An error has occured while saving Vehicle - {}",
					vehicleDetail.toString());
			log.error("Problem = {}", ex.getMessage());

			return new BooleanAndMessages(false, "Vehicle Not Edited",
					ex.getMessage());
		}
	}

	@Override
	public BooleanAndMessages deleteVehicleDetail(VehicleDetails vehicleDetail) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.delete(vehicleDetail);

			return new BooleanAndMessages(true, "Object Deletion Successful",
					"VehicleDetail Object Deleted Successfully");

		} catch (Exception ex) {

			log.error(
					"An error has occured while deleting VehicleDetail Object - {}",
					vehicleDetail.toString());
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
