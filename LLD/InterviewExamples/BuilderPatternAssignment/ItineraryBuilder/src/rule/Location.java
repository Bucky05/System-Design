package rule;
public class Location {
    
    
    public static void check(String location, String name) {
        if(location == null || location.length() != 3 || !location.toUpperCase().equals(location)) {
           throw new Error("\n"+name + " must be 3 letter IATA '"+location+"' given.");
        } 
    }
}
