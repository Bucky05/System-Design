public class CricBuzz {

    private int runs;
    private int wickets;
    private int overs;
    private IccAPIService iccAPIService; // violates DIP just for demo

    public CricBuzz() {
        this.iccAPIService = new IccAPIService(0,0,0);
    }

    public void updateScore(int runs, int wickets, int overs) {
        while(true) {
            iccAPIService.updateScore(runs,wickets,overs);
            if( this.overs != iccAPIService.getOvers()) {
                this.runs = iccAPIService.getRuns();
                this.overs = iccAPIService.getOvers();
                this.wickets = iccAPIService.getWickets();
            }
        }

        // check if values are updated;


    }
}
