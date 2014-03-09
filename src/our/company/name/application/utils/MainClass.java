package our.company.name.application.utils;


public class MainClass {

	public static void main(String[] args) {

		String small = "hello";

		String capital = small.substring(0, 1).toUpperCase()
				+ small.substring(1);
		System.out.println(capital);


	}

}
