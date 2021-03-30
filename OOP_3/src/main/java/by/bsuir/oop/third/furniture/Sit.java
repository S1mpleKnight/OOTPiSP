package by.bsuir.oop.third.furniture;

public abstract class Sit extends Furniture{
    private int places;

    public Sit(int weight, int places) {
        super(weight);
        this.places = places;
    }

    public int getPlaces() {
        return places;
    }
}
