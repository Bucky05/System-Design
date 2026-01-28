package controllers;

import factories.RequestHandlerFactory;
import handlers.*;
import schemas.Todo;
import dto.Request;
public class TodoController {

    public Todo createTodo(Request request) {
       RequestHandlerFactory.getHandlersForCreateTodo().handle(request);

        return new Todo();
    }
}
