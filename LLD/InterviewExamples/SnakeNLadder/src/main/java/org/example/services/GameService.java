package org.example.services;

import org.example.models.*;
import org.example.states.InitializeState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameService {



    StateTracker state;
    public GameService(int rows, int cols, List<List<Integer>> snakeOrLadder, int totalPlayers) {

        state = new StateTracker(new InitializeState());

        state.initializeGame(rows,cols,snakeOrLadder,totalPlayers);




    }


}
