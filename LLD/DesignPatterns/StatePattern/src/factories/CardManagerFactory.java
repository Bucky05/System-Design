package factories;

import enums.CardType;
import models.services.CardManagerService;
import models.services.CreditCardManagerService;
import models.services.DebitCardManagerService;

public class CardManagerFactory {
    
    public static CardManagerService getCardManagerService(CardType cardType) {
        CardManagerService cardManagerService = null;

        if(cardType == CardType.DEBIT) {
            cardManagerService = new DebitCardManagerService();
        } else if(cardType == CardType.CREDIT) {
            cardManagerService = new CreditCardManagerService();
        } else {
            throw new IllegalArgumentException("Invalid card type");
        }
        
        return cardManagerService;
    }
}
