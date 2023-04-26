package ilu2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Welcome {
	public static String welcome(String input) {
	    if (input == null || input.trim().isEmpty()) {
	        return "Hello, my friend";
	    } else if (isUpperCase(input)) {
	        return "HELLO, " + input + "!";
	    } else {
	        String[] names = input.split("\\s*,\\s*"); 
	        List<String> distinctNames = new ArrayList<>();
	        int[] counts = new int[names.length];
	       
	        for (int i = 0; i < names.length; i++) {
	            String name = names[i].trim();
	            if (isUpperCase(name)) {
	                distinctNames.add(name);
	                counts[distinctNames.size()-1]++;
	            } else {
	                int index = distinctNames.indexOf(name.toLowerCase());
	                if (index == -1) {
	                    distinctNames.add(name.toLowerCase());
	                    counts[distinctNames.size()-1]++;
	                } else {
	                    counts[index]++;
	                }
	            }
	        }
	        List<String> normalNames = new ArrayList<>();
	        List<String> uppercaseNames = new ArrayList<>();
	        int[] normalCounts = new int[distinctNames.size()];
	        int[] uppercaseCounts = new int[distinctNames.size()];

	        for (int i = 0; i < distinctNames.size(); i++) {
	            String name = distinctNames.get(i);
	            int count = counts[i];
	            if (isUpperCase(name)) {
	                uppercaseNames.add(name);
	                uppercaseCounts[uppercaseNames.size()-1] = count;
	            } else {
	            	String nomNormal= name.substring(0, 1).toUpperCase() + name.substring(1);
	            	normalNames.add(nomNormal);
	                normalCounts[normalNames.size()-1] = count;
	            }
	        }
	        
	        StringBuilder normalMessage = messageCasNormal(normalNames, normalCounts);
	        StringBuilder uppercaseMessage = messageCasMajuscule(uppercaseNames);
	        
	        if (uppercaseMessage.length() == 0) {
	            return normalMessage.toString();
	        } else {
                return normalMessage.toString() + "." + uppercaseMessage.toString();
            }
        }
	}
        
            
    


	private static StringBuilder messageCasNormal(List<String> names, int[] counts) {
	    StringBuilder message = new StringBuilder();
	    boolean containsYoda = names.contains("Yoda");
	    if (!names.isEmpty()) {
	        if (containsYoda) {
	            message.append("");
	        } else {
	            message.append("Hello, ");
	        }
	        for (int i = 0; i < names.size(); i++) {
	            if ((i == names.size() - 1) && (names.size() > 1)) {
	                message.append(" and ");
	            } else if (i > 0) {
	                message.append(", ");
	            }
	            message.append(names.get(i));
	            if (counts[i] > 1) {
	                message.append(" (x").append(counts[i]).append(")");
	            }
	        }
	        if (containsYoda) {
	            message.append(", Hello");
	        }
	    }
	    return message;
	}




	private static StringBuilder messageCasMajuscule(List<String> names) {
	    StringBuilder message = new StringBuilder();
	    boolean containsYoda = names.contains("YODA");
	    if (!names.isEmpty()) {
	        Map<String, Integer> countMap = new HashMap<>();
	        if (containsYoda) {
	            message.append("AND ");
	        } else {
	            message.append("AND HELLO ");
	        }
	       
	        for (String name : names) {
	            countMap.put(name, countMap.getOrDefault(name, 0) + 1);
	        }
	        boolean first = true;
	        for (String name : countMap.keySet()) {
	            if (!first) {
	                message.append(" AND ");
	            }
	            message.append(name);
	            message.append(" (x");
	            message.append(countMap.get(name));
	            message.append(")");
	            first = false;
	        }
	        if (containsYoda) {
	            message.append(" HELLO!");
	        }
	    }
	    return message;
	}


	private static boolean isUpperCase(String input) {
    	return input.equals(input.toUpperCase());
    }
}
