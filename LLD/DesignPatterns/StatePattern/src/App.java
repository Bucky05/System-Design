import enums.CardType;
import models.ATM;
import models.VisaDebitCard;
import models.Card;
public class App {
    public static void main(String[] args) {
        ATM atm = new ATM("123");
        Card card = new VisaDebitCard(12345, 1234, "Anirudh", CardType.DEBIT,"SBI");

        atm.initTransaction(card);
        atm.readCardDetailsAndPin(1234);
        atm.readCashWithdrawlDetails(100);
        atm.dispenseCash(100);

    }
}

Table columns(Name of student) column(Gender) column (Marks)
SELECT name, marks from results where marks > 50 && GENDER = 'MALE'
        composite indexing (Marks, Gender)

student info ,

ecommerce
products - id, name, price, category

get min and max price for each category


        1
                (MIN PRICE FOR CATEGORY)
        2 (MAX PRICE FOR CATEGORY)


        SELECT p.category, min1.min, max1.max FROM products as p JOIN

        (SELECT category, MIN(price) as min FROM products GROUP BY category)
as min1 ON p.category = min1.category

        JOIN
        (SELECT category, MAX(price) as max FROM products GROUP BY category)
as max1 ON p.category = max1.category




1 Product1, 800, Electroncis
2 Product2, 700, Electronics
3 Product3, 500, Sports

Electronics 800 700
Sports 500 500

min -
Electronics 700
Sports 500

max -

Electronics 800
Sports 500


        SELECT category, MAX(price), MIN(price) as max FROM products GROUP BY category

button - display message , time increased between click on

