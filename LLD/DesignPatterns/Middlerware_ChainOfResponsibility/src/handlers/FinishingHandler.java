package handlers;

import dto.Request;

public class FinishingHandler implements  RequestHandler{

    @Override
    public void handle(Request request) {
        System.out.println("Finishing the request");
    }
}
