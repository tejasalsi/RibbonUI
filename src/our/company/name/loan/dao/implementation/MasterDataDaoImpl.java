package our.company.name.loan.dao.implementation;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import our.company.name.loan.dao.MasterDataDao;
import our.company.name.loan.dao.RepayModeDao;
import our.company.name.loan.dao.ResidenceTypeDao;
import our.company.name.loan.dao.VehicleDetailsDao;

@SuppressWarnings("serial")
public class MasterDataDaoImpl implements MasterDataDao {

	static Logger log = LoggerFactory.getLogger(MasterDataDaoImpl.class);

	private SessionFactory sessionFactory;

	private ResidenceTypeDao residenceTypeDao;
	private VehicleDetailsDao vehicleDetailsDao;
	private RepayModeDao repayModeDao;


	/**
	 * @return the residenceTypeDao
	 */
	public ResidenceTypeDao getResidenceTypeDao() {
		return residenceTypeDao;
	}

	/**
	 * @param residenceTypeDao
	 *            the residenceTypeDao to set
	 */
	public void setResidenceTypeDao(ResidenceTypeDao residenceTypeDao) {
		this.residenceTypeDao = residenceTypeDao;
	}

	/**
	 * @return the vehicleDetailsDao
	 */
	public VehicleDetailsDao getVehicleDetailsDao() {
		return vehicleDetailsDao;
	}

	/**
	 * @param vehicleDetailsDao
	 *            the vehicleDetailsDao to set
	 */
	public void setVehicleDetailsDao(VehicleDetailsDao vehicleDetailsDao) {
		this.vehicleDetailsDao = vehicleDetailsDao;
	}

	/**
	 * @return the repayModeDao
	 */
	public RepayModeDao getRepayModeDao() {
		return repayModeDao;
	}

	/**
	 * @param repayModeDao
	 *            the repayModeDao to set
	 */
	public void setRepayModeDao(RepayModeDao repayModeDao) {
		this.repayModeDao = repayModeDao;
	}

	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @param sessionFactory
	 * @param residenceTypeDao
	 * @param vehicleDetailsDao
	 * @param repayModeDao
	 * 
	 *            The Constructor
	 */
	public MasterDataDaoImpl(SessionFactory sessionFactory,
			ResidenceTypeDao residenceTypeDao,
			VehicleDetailsDao vehicleDetailsDao, RepayModeDao repayModeDao) {
		this.sessionFactory = sessionFactory;
		this.residenceTypeDao = residenceTypeDao;
		this.vehicleDetailsDao = vehicleDetailsDao;
		this.repayModeDao = repayModeDao;
	}

	/**
	 * The Default Constructor
	 */
	public MasterDataDaoImpl() {

	}


}
