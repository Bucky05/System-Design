package handlers;

import dto.Request;
import services.TokenService;
import services.TokenServiceImpl;

public class AuthenticationHandler implements RequestHandler{

    private final RequestHandler nextHandler;
    private final TokenService tokenService;
    public AuthenticationHandler(RequestHandler nextHandler,TokenService tokenService) {
        this.nextHandler = nextHandler;
        this.tokenService = tokenService;
    }
    @Override
    public void handle(Request request) {
        //before calling the next handler
        System.out.println("AuthenticationHandler: Authenticating the request");
        tokenService.validateToken(request);
        this.nextHandler.handle(request);
        //after calling the next handler
    }
}
