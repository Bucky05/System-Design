package PrototypePattern.BetterSolution;

public interface Prototype<T extends Prototype<T>> {
    T clone();
}
