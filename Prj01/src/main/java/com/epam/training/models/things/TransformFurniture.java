package com.epam.training.models.things;

public class TransformFurniture extends Furniture {

    private double minSquare;

    public TransformFurniture(String name, double minSquare, double square) {
        super(name, square);
        this.minSquare = minSquare;
    }


    public double getMinSquare() {
        return minSquare;
    }
}
