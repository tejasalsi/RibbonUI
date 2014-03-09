package our.company.name.loan.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import our.company.name.application.utils.BooleanAndMessages;
import our.company.name.loan.application.pojos.RepayMode;

public interface RepayModeDao extends GenericDao {

	/** CRUD Operations for - RepayMode */
	@Transactional
	public List<RepayMode> getAllRepayModes();

	@Transactional
	public BooleanAndMessages saveOrUpdateRepayMode(RepayMode repayMode);

	@Transactional
	public BooleanAndMessages deleteRepayMode(RepayMode repayMode);

}
