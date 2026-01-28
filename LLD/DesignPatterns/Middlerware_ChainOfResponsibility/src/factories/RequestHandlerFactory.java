package factories;

import handlers.*;
import services.TokenService;
import services.TokenServiceImpl;

public class RequestHandlerFactory {

    public static RequestHandler getHandlersForCreateTodo() {
        return new ValidateBodyHandler(
                new ValidateParamHandler(
                        new AuthenticationHandler(
                                new AuthorizationHandler(
                                        new FinishingHandler()
                                ), new TokenServiceImpl()
                        )
                )
        );
    }

    public static RequestHandler getHandlersForUpdateTodo() {
        // create flow accordingly
        return new ValidateBodyHandler(
                new ValidateParamHandler(
                        new AuthenticationHandler(
                                new AuthorizationHandler(
                                        new FinishingHandler()
                                ), new TokenServiceImpl()
                        )
                )
        );
    }
}
