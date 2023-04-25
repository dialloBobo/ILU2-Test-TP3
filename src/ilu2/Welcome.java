package ilu2;

import java.util.ArrayList;
import java.util.List;

public class Welcome {
    public static String welcome(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Hello, my friend";
        } else if (isUpperCase(input)) {
            return "HELLO, " + input + "!";
        } else {
            String[] noms = input.split("\\s*,\\s*"); 
            List<String> tableauxNomsNormaux = new ArrayList<>();
            List<String> tableauxNomsMajuscules = new ArrayList<>();
            for (String name : noms) {
                if (isUpperCase(name.trim())) {
                    tableauxNomsMajuscules.add(name.trim());
                } else {
                    tableauxNomsNormaux.add(name.substring(0, 1).toUpperCase()+ name.substring(1).trim());
                }
            }
            StringBuilder messageCasNormal = messageCasNormal(tableauxNomsNormaux);
            StringBuilder messageCasMajuscule = messageCasMajuscule(tableauxNomsMajuscules);
            
            if (messageCasNormal.length() == 0) {
                return messageCasMajuscule.toString();
            } else if (messageCasMajuscule.length() == 0) {
                return messageCasNormal.toString() ;
            } else {
                return messageCasNormal.toString() + "." + messageCasMajuscule.toString();
            }
        }
    
    }    
            
    


private static boolean isUpperCase(String input) {
    return input.equals(input.toUpperCase());
}

private static StringBuilder messageCasNormal(List<String> names) {
    StringBuilder message = new StringBuilder();
    if (!names.isEmpty()) {
        message.append("Hello, ");
        for (int i = 0; i < names.size(); i++) {
            if ((i == names.size() - 1) && (names.size()>1)) {
                message.append(" and ");
            } else if (i > 0) {
                message.append(", ");
            }
            message.append(names.get(i));
        }
    }
    return message;
}

private static StringBuilder messageCasMajuscule(List<String> names) {
    StringBuilder message = new StringBuilder();
    if (!names.isEmpty()) {
        message.append("AND HELLO ");
        for (int i = 0; i < names.size(); i++) {
            if (i == names.size() - 1 && names.size() > 1) {
                message.append(" AND ");
                message.append(names.get(i));
            } 
             else {
                message.append(names.get(i));
            }
        }
        message.append("!");  
    }
    return message;
}
}
