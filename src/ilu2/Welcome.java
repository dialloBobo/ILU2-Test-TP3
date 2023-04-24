package ilu2;

public class Welcome {
	
	public static String welcome(String input) {
		StringBuilder message = new StringBuilder();
		
		if(input==null || input.trim().isEmpty()) {
			message.append("Hello, my friend");
		}
		else if(isUpperCase(input)){
			message.append("HELLO, "+input+ "!");
		}
		else{
			String[] noms=input.split(",");
			int nbPersonne = noms.length;
			
			if (nbPersonne==1){
				message.append("Hello, "+noms[0].substring(0, 1).toUpperCase()+ noms[0].substring(1));
			}
			else{
				message.append("Hello");
				for(int i=0; i < nbPersonne ;i++) {
					message.append(", "+noms[i].substring(0, 1).toUpperCase()+ noms[i].substring(1));
					
				}
			}
			
		}
		return message.toString();
		
	}
	
	
	
	private static boolean isUpperCase(String input){
		return input.equals(input.toUpperCase());
	}

}
