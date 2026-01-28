package handlers;

import dto.Request;

public class ValidateParamHandler implements  RequestHandler{

    private final RequestHandler nextHandler;

    public ValidateParamHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    @Override
    public void handle(Request request) {
        System.out.println("ValidateParamHandler: Validating the request params");
        nextHandler.handle(request);
    }
}
