package handlers;

import dto.Request;

public class ValidateBodyHandler implements  RequestHandler{

    private final RequestHandler nextHandler;

    public ValidateBodyHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    @Override
    public void handle(Request request) {
        System.out.println("ValidateBodyHandler: Validating the body");
        nextHandler.handle(request);
    }
}
