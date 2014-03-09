package our.company.name.application.utils;

/**
 * At many places throughout our application we need to communicate 2 or more
 * than 2 things simultaneously, like A boolean and 1 or 2 messages. This class
 * will be used for that purpose.
 * */
public class BooleanAndMessages {

	public boolean state;

	public String priorityMessage1;

	public String priorityMessage2;

	/**
	 * @param state
	 * @param priorityMessage1
	 *            - The message with higher priority
	 * @param priorityMessage2
	 *            - The message with lower priority
	 * 
	 *            The Constructor for BooleanAndMessage class
	 */
	public BooleanAndMessages(boolean state, String priorityMessage1,
			String priorityMessage2) {
		this.state = state;
		this.priorityMessage1 = priorityMessage1;
		this.priorityMessage2 = priorityMessage2;
	}

	/**
	 * The parameterless constructor is 'private', because we don't want any
	 * other class to use it.
	 */
	@SuppressWarnings("unused")
	private BooleanAndMessages() {

	}

}
