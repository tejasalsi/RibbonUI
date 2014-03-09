package our.company.name.loan.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import our.company.name.application.utils.BooleanAndMessages;
import our.company.name.loan.application.pojos.ResidenceType;

public interface ResidenceTypeDao extends GenericDao {

	/** CRUD operations for - "Residence Type" */
	@Transactional
	public List<ResidenceType> getAllResidenceTypes();

	@Transactional
	public BooleanAndMessages saveOrUpdateResidenceType(
			ResidenceType residenceType);

	@Transactional
	public BooleanAndMessages deleteResidenceType(ResidenceType residenceType);



}
