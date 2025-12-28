import java.time.LocalDate;
import models.Budget;

import java.util.ArrayList;
import java.util.List;
class Itinerary {
    final private String travelerName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String origin;
    private String destination;
    private Budget budget;
    final private boolean travelInsurance;
    private List<Segment> segments = new ArrayList<>();
    private List<String> tags = new ArrayList<>();

    public Itinerary(Builder builder) {
        travelerName = builder.getTravelerName();
        startDate = builder.getStartDate();
        endDate = builder.getEndDate();
        origin = builder.getOrigin();
        destination = builder.getDestination();
        budget = builder.getBudget();
        travelInsurance = builder.getTravelInsurance();
        segments = deepCopyOfSegmentList(builder.getSegments());
        tags = deepCopyOfStringList(builder.getTags());
    }

    public String getTravelerName() {
        return travelerName;
    }

    public String getOrigin() {
        return origin;
    }

    public Budget getBudget() {
        // since budget is already immutible
        return budget;
    }

    public String getDestination() {
        return destination;
    }

    public String getEndDate() {
        return endDate.toString();
    }

    public List<Segment> getSegments() {
        return deepCopyOfSegmentList(segments);
    }

    public String getStartDate() {
        return startDate.toString();
    }

    public List<String> getTags() {
        return deepCopyOfStringList(tags);
    }

    public boolean getTravelInsurance() {
        return travelInsurance;
    }




    private List<Segment> deepCopyOfSegmentList(List<Segment> segments) {
        if(segments.size() == 0) return new ArrayList<>();

        List<Segment> deepCopy = new ArrayList<>();

        for(Segment segment : segments) {
            deepCopy.add(segment.clone());
        }

        return deepCopy;
    }

    private List<String> deepCopyOfStringList(List<String> list) {
        if(list.size() == 0) return new ArrayList<>();

        List<String> deepCopy = new ArrayList<>();

        for(String string : list) {
            deepCopy.add(string);
        }
        return deepCopy;
    }
}