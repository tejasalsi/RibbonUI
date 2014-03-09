package our.company.name.loan.application.property.pojos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AssetValue implements Serializable {

	public long assetValue;

	/**
	 * 
	 * 
	 * The Default Constructor
	 */
	public AssetValue() {
		super();
	}

	/**
	 * @param assetValue
	 * 
	 *            The Parameterized Constructor
	 */
	public AssetValue(long assetValue) {
		super();
		this.assetValue = assetValue;
	}

	public long getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(long assetValue) {
		this.assetValue = assetValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AssetValue - [ assetValue=");
		builder.append(assetValue);
		builder.append(" ]");
		return builder.toString();
	}

}
