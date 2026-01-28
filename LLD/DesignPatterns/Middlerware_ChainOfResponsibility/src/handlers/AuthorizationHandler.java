package handlers;

import dto.Request;

public class AuthorizationHandler implements RequestHandler{

    private final RequestHandler nextHandler;

    public AuthorizationHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    @Override
    public void handle(Request request) {
        System.out.println("AuthorizationHandler: Authorizing the request");
        nextHandler.handle(request);
    }
}
