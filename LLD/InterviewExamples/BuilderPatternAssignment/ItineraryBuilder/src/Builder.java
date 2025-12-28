import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import rule.Location;
import models.Budget;
import rule.DatesRule;

public class Builder {
    private String nonEmtpyError = "field can not be empty";
    private String travelerName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String origin;
    private String destination;
    private Budget budget;
    private boolean travelInsurance = false;
    private List<Segment> segments = new ArrayList<>();
    private List<String> tags = new ArrayList<>();

    public Builder travelerName(String name) {
        if (name == null || name == "") {
            String error = "\nTraveler name " + nonEmtpyError;
            throw new IllegalArgumentException(error);
        }
        this.travelerName = name;
        return this;
    }

    public Builder startDate(String date) {
        if (date == null) {
            String error = "\nStart date " + nonEmtpyError;
            throw new IllegalArgumentException(error);
        }
        this.startDate = LocalDate.parse(date);
        if (endDate != null) {
            DatesRule.checkStartAndEndDate(startDate, endDate);
        }

        return this;
    }

    public Builder endDate(String date) {
        if (date == null) {
            String error = "\nStart date " + nonEmtpyError;
            throw new IllegalArgumentException(error);
        }
        this.endDate = LocalDate.parse(date);
        if (startDate != null) {
            DatesRule.checkStartAndEndDate(startDate, endDate);
        }

        return this;
    }

    public Builder origin(String origin) {
        Location.check(origin, "origin");

        this.origin = origin;
        return this;
    }

    public Builder destination(String destination) {

        Location.check(destination, "destination");

        this.destination = destination;
        return this;
    }

    public Builder travelInsurance(boolean isInsured) {
        travelInsurance = isInsured;
        return this;
    }

    public Builder segments(List<Segment> segments) {
        this.segments = segments;
        return this;
    }

    public Builder tags(List<String> tags) {
        this.tags = tags;
        return this;
    }
    public Itinerary build() {
        if (travelerName == null || startDate == null || endDate == null || origin == null || destination == null) {
            throw new IllegalArgumentException("\nOne of the required field is missing");
        }
        checkSegmentList();
        return new Itinerary(this);
    }

    public String getTravelerName() {
        return travelerName;
    }

    public String getOrigin() {
        return origin;
    }

    public Budget getBudget() {
        return budget;
    }
 

    public String getDestination() {
        return destination;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public List<String> getTags() {
        return tags;
    }

    public boolean getTravelInsurance() {
        return travelInsurance;
    }

    private void checkSegmentList() {
        if (segments.size() == 0)
            return;

        LocalDateTime prevTime = LocalDateTime.parse(startDate.toString() + "T00:00:00");
        String prevLocation = origin;

        for (Segment segment : segments) {
            if (!prevLocation.equals(segment.getFrom())) {
                throw new IllegalArgumentException("\nLocation mismatched");
            }
            prevLocation = segment.getTo();

            if (segment.getDepartAt().isBefore(prevTime)) {
                throw new IllegalArgumentException("\nInconsistency in time");
            }

            prevTime = segment.getArriveAt();
        }

        if (!prevLocation.equals(destination)) {
            throw new IllegalArgumentException("\nLocation mismatched");
        }

        LocalDateTime arriveTime = LocalDateTime.parse(endDate.toString() + "T12:59:59");
        if (arriveTime.isBefore(prevTime)) {
            throw new IllegalArgumentException("\nInconsistency in time");
        }

    }
}
