package services;

import dto.Request;

public class TokenServiceImpl implements  TokenService{


    @Override
    public boolean validateToken(Request request) {
        System.out.println("TokenServiceImpl: Validating token");

        return true;

    }
}
