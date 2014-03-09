package our.company.name.loan.dao;


public interface MasterDataDao extends GenericDao {
	

	public RepayModeDao getRepayModeDao();
	public void setRepayModeDao(RepayModeDao repayMode);
	
	public VehicleDetailsDao getVehicleDetailsDao();
	public void setVehicleDetailsDao(VehicleDetailsDao vehicleDetailsDao);

	public ResidenceTypeDao getResidenceTypeDao();
	public void setResidenceTypeDao(ResidenceTypeDao residenceTypeDao);


}
