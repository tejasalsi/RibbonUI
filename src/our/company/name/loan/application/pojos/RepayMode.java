package our.company.name.loan.application.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** This bean represents the "Mode" of Repayment */

@SuppressWarnings("serial")
@Entity
@Table(name = "REPAY_MODE_TABLE")
public class RepayMode implements IMasterTablesPojo {

	@Id
	@Column(name = "REPAY_MODE_ID")
	@GeneratedValue
	public int repayModeId;

	@Column(name = "REPAY_MODE")
	public String repayMode;
	
	/** The Default Constructor */
	public RepayMode() {

	}

	/**
	 * @param repayModeId
	 * @param repayMode
	 * 
	 *            The Constructor
	 */
	public RepayMode(int repayModeId, String repayMode) {
		super();
		this.repayModeId = repayModeId;
		this.repayMode = repayMode;
	}

	public int getRepayModeId() {
		return repayModeId;
	}

	public void setRepayModeId(int repayModeId) {
		this.repayModeId = repayModeId;
	}

	public String getRepayMode() {
		return repayMode;
	}

	public void setRepayMode(String repayMode) {
		this.repayMode = repayMode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RepayMode - [ repayModeId=");
		builder.append(repayModeId);
		builder.append(", repayMode=");
		builder.append(repayMode);
		builder.append(" ]");
		return builder.toString();
	}
	
	
}
