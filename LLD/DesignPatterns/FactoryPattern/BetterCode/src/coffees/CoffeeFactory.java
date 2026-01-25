package FactoryPattern.BetterCode.src.coffees;

public class CoffeeFactory {
    
    public Coffee getCoffee(String whichCoffee) {
        Coffee coffee;
        if(whichCoffee.equals("Espresso")) {
            coffee= new Espresso();
        } else if(whichCoffee.equals("Cappucino")) {
            coffee = new Cappucino();
        } else {
            coffee = new Latte();
        }

        return coffee;
    }
}
