package our.company.name.application.utils;

public class StringUtil {

	public static String setFirstWordCapitaCase(String input) {

		if (input.length() != 0) {

			// Step-1: Remove leading and trailing whitespace
			input = input.trim();

			// Step-2: Format String
			String output = input.substring(0, 1).toUpperCase()
					+ input.substring(1);

			// Step-3: Return "Formatted" String
			return output;

		} else {

			return null;

		}

	}

}
