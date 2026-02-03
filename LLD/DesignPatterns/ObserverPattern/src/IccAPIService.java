public class IccAPIService {

    private int runs;
    private int overs;
    private int wickets;

    public IccAPIService(int runs, int wickets, int overs) {
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
    }

    public int getRuns() {
        return this.runs;
    }

    public int getOvers() {
        return this.overs;
    }

    public int getWickets() {
        return this.wickets;
    }

    public void updateScore(int runs, int wickets, int overs) {
        this.overs = overs;
        this.wickets = wickets;
        this.runs = runs;
    }
}
