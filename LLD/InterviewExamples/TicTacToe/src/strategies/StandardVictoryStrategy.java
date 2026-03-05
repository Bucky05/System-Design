package strategies;

public class StandardVictoryStrategy implements VictoryStrategy {


    public boolean checkVictory(char[][] table, char symbol) {

        // check row
        for (char[] chars : table) {
            boolean flag = true;

            for (int j = 0; j < table.length; j++) {
                if (chars[j] != symbol) {
                    flag = false;
                    break;
                }
            }

            if (flag) return true;
        }

        //check for cols

        for(int i = 0 ; i < table.length ; i++) {
            boolean flag = true;

            for (char[] chars : table) {
                if (chars[i] != symbol) {
                    flag = false;
                    break;
                }
            }

            if(flag) return true;
        }

        // check diagonals;
        boolean flag = true;
        for(int i = 0 ; i < table.length; i++) {
            if(table[i][i] != symbol) {
                flag = false;
                break;
            }
        }

        if(flag) return true;

        flag=true;

        for(int i = 0 ; i < table.length ; i++) {
            if(table[i][table.length-i-1] != symbol) {
                flag = false;
                break;
            }
        }

        return flag;



    }
}
