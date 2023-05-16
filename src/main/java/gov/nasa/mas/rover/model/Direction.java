package gov.nasa.mas.rover.model;

public enum Direction {

    E,S,W,N;

    public Direction nextClockWiseDir(){
        return values()[(ordinal() + 1  + values().length) % values().length];
    }

    public Direction nextAntiClockWiseDir(){
        return  values()[(ordinal() - 1  + values().length) % values().length];
    }
}
