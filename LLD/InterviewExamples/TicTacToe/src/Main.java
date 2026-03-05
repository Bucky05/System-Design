import enums.GameStates;
import enums.VictoryStrategyEnum;
import services.GameEngine;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static void main() {

        Scanner sc = new Scanner(System.in);
        GameEngine engine = new GameEngine();
        System.out.println("Enter board Size");
        int size = Integer.parseInt(sc.nextLine());
        System.out.println("Enter number of Players");
        int numberOfPlayer = Integer.parseInt(sc.nextLine());
        engine.initGame(size,numberOfPlayer, VictoryStrategyEnum.STANDARD);
        for(int i = 0 ; i < numberOfPlayer ; i++) {
            System.out.println("Enter Player "+(i+1)+" name");
            String name = sc.nextLine();
            System.out.println("Enter Player "+(i+1)+" symbol");
            String ch = sc.nextLine();
            char c = ch.charAt(0);
            engine.addPlayer(name,c);
        }
        int moves = 0;
        while(true) {
            System.out.println(" Enter row and col");
            int row = sc.nextInt();
            int col = sc.nextInt();

            try{
            engine.move(row,col);}
            catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            if(engine.getState() == GameStates.ENDED) break;

        }

        engine.endGame();


}
