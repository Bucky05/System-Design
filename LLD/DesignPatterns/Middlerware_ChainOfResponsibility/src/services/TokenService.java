package services;

import dto.Request;

public interface TokenService {

    boolean validateToken(Request request);
}
