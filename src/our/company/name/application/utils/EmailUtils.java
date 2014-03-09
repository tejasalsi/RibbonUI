package our.company.name.application.utils;

public class EmailUtils {

	public String TO, CC, BCC;
	public String SUBJECT;
	public String EMAIL_BODY;

	/**
	 * @param tO
	 * @param sUBJECT
	 * @param eMAIL_BODY
	 * 
	 *            The Constructor - without CC and BCC
	 */
	public EmailUtils(String tO, String sUBJECT, String eMAIL_BODY) {

		TO = tO;
		SUBJECT = sUBJECT;
		EMAIL_BODY = eMAIL_BODY;
	}


	/**
	 * @param tO
	 * @param cC
	 * @param sUBJECT
	 * @param eMAIL_BODY
	 * 
	 *            The Constructor - without BCC field
	 */
	public EmailUtils(String tO, String cC, String sUBJECT, String eMAIL_BODY) {
		super();
		TO = tO;
		CC = cC;
		SUBJECT = sUBJECT;
		EMAIL_BODY = eMAIL_BODY;
	}


	/**
	 * @param tO
	 * @param cC
	 * @param bCC
	 * @param sUBJECT
	 * @param eMAIL_BODY
	 * 
	 *            The Constructor
	 */
	public EmailUtils(String tO, String cC, String bCC, String sUBJECT,
			String eMAIL_BODY) {
		super();
		TO = tO;
		CC = cC;
		BCC = bCC;
		SUBJECT = sUBJECT;
		EMAIL_BODY = eMAIL_BODY;
	}

	/** We do not want the default constructor to be called by any other class */
	@SuppressWarnings("unused")
	private EmailUtils() {

	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailUtils - [ TO=");
		builder.append(TO);
		builder.append(", CC=");
		builder.append(CC);
		builder.append(", BCC=");
		builder.append(BCC);
		builder.append(", SUBJECT=");
		builder.append(SUBJECT);
		builder.append(", EMAIL_BODY=");
		builder.append(EMAIL_BODY);
		builder.append(" ]");
		return builder.toString();
	}

}
