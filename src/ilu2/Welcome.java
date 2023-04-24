package ilu2;


public class Welcome {
	
	public static String welcome(String input) {
		
		
		if(input==null || input.trim().isEmpty()) {
			return "Hello, my friend";
		}
		else if(isUpperCase(input)){
			return"HELLO, "+input+ "!";
		}
		else {
		String[] noms=input.split(",");
		StringBuilder message = new StringBuilder();
		StringBuilder messageMajuscule = new StringBuilder();
	    for (String nom : noms) {
	        if (isUpperCase(nom)) {
	        	messageMajuscule.append("AND HELLO, " + nom+ "!");
	        } 
	        else {
	            message.append(", "+nom.substring(0, 1).toUpperCase()+ nom.substring(1));
	
	        }
	    }
		message.replace(0, 2, "Hello, ");
	    if (messageMajuscule.length() > 0) {
	        message.append(".");
	    }
	    message.append(messageMajuscule);
	    return message.toString();
		}
	}

	private static boolean isUpperCase(String input) {
		 return input.equals(input.toUpperCase());
	}

}
