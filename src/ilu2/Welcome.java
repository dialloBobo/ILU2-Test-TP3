package ilu2;

public class Welcome {
	
	public static String welcome(String input) {
		StringBuilder message = new StringBuilder();
		
		if(input==null || input.trim().isEmpty()) {
			message.append("Hello, my friend");
		}
		else {
			return "Hello, "+input.substring(0, 1).toUpperCase()+ input.substring(1);
		}
		return message.toString();		
	}

}
