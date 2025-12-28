
import java.time.LocalDateTime;
import rule.Location;
import rule.DatesRule;
public class Segment {
    private String from;
    private String to;
    private LocalDateTime departAt;
    private LocalDateTime arriveAt;
    private String carrier = "";

    public Segment(String from, String to, String departAt, String arriveAt, String carrier) {
        Location.check(from,"from");
        this.from = from;
        Location.check(to, "to");
        this.to = to;

        if(departAt == null || departAt == "") {
            throw new Error("Departure time cannot be empty");
        }

        this.departAt = LocalDateTime.parse(departAt);
        
        if(arriveAt == null || arriveAt == "") {
            throw new Error("Arrival time cannot be empty");
        }

        this.arriveAt = LocalDateTime.parse(arriveAt);
        DatesRule.checkStartAndEndDate(this.departAt,this.arriveAt);
        this.carrier = carrier;
    }

     public Segment(String from, String to, String departAt, String arriveAt) {
        Location.check(from,"from");
        this.from = from;
        Location.check(to, "to");
        this.to = to;

        if(departAt == null || departAt == "") {
            throw new Error("Departure time cannot be empty");
        }

        this.departAt = LocalDateTime.parse(departAt);
        
        if(arriveAt == null || arriveAt == "") {
            throw new Error("Arrival time cannot be empty");
        }

        this.arriveAt = LocalDateTime.parse(arriveAt);

    }


    public Segment(Segment segment) {
        this.arriveAt = segment.arriveAt;
        this.carrier = segment.carrier;
        this.departAt = segment.departAt;
        this.from = segment.from;
        this.to = segment.to;
    }

    public Segment clone() {
        return new Segment(this);
    }

    public String getFrom(){
        return this.from;
    }

    public String getTo() {
        return to;
    }

    public LocalDateTime getArriveAt() {
        return arriveAt;
    }

    public LocalDateTime getDepartAt() {
        return departAt;
    }
}
