package our.company.name.loan.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import our.company.name.application.utils.BooleanAndMessages;
import our.company.name.loan.application.pojos.VehicleDetails;

public interface VehicleDetailsDao extends GenericDao {

	/** CRUD operations for - "VehicleDetails" */
	@Transactional
	public List<VehicleDetails> getAllVehicleDetails();

	@Transactional
	public BooleanAndMessages saveVehicleDetails(VehicleDetails vehicleDetails);

	@Transactional
	public BooleanAndMessages updateVehicleDetails(VehicleDetails vehicleDetails);

	@Transactional
	public BooleanAndMessages deleteVehicleDetail(VehicleDetails vehicleDetail);

}
