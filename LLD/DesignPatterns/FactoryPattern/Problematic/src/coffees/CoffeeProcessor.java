package FactoryPattern.Problematic.src.coffees;

public class CoffeeProcessor {

    public Coffee prepareCoffee(String whichCoffee) {
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
