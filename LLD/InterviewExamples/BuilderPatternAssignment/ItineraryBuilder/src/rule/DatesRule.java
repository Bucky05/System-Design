package rule;
import java.time.LocalDateTime;
import java.time.LocalDate;
public class DatesRule {
    
    public static void checkStartAndEndDate(LocalDate startDate, LocalDate endDate) {
        if(endDate.isBefore(startDate)) {
            throw new Error("\nendDate: " +endDate.toString() +" is before startDate: "+endDate.toString());
        }
    }

    public static void checkStartAndEndDate(LocalDateTime startDate, LocalDateTime endDate) {
        if(endDate.isBefore(startDate)) {
            throw new Error("\nendDate: " +endDate.toString() +" is before startDate: "+endDate.toString());
        }
    }
}
