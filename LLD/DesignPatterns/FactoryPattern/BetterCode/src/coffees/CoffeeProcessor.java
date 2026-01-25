package FactoryPattern.BetterCode.src.coffees;

public class CoffeeProcessor {

    public Coffee prepareCoffee(String whichCoffee) {
        Coffee coffee = new CoffeeFactory().getCoffee(whichCoffee);

        return coffee;
    }
    
}
