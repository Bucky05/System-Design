import java.util.List;

import rule.Location;

import java.util.ArrayList;
public class App {
    public static void main(String[] args) throws Exception {
        List<Segment> segments = new ArrayList<>();

        segments.add(new Segment("AME","RUS","2025-10-10T00:00:00","2025-10-12T00:00:00"));
        segments.add(new Segment("RUS","HOK","2025-10-13T00:00:00","2025-10-14T00:00:00"));

        List<String> tags = new ArrayList<>();

        tags.add("WanderLust");
        tags.add("Bike");

        Itinerary itinerary = new Builder()
                                .travelerName("Bharat")
                                .startDate("2025-10-09")
                                .endDate("2025-10-15")
                                .origin("AME")
                                .destination("HOK")
                                .segments(segments)
                                .build();
        
        System.out.println("\n"+itinerary.getTravelerName());
    }
}
