package by.bsuir.oop.third.furniture;

public abstract class Sit extends Furniture {
    private Integer places;

    public Sit(int weight, int places) {
        super(weight);
        this.places = places;
    }

    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }
}
