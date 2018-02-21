package com.epam.training.models;

import com.epam.training.exceptions.IlluminanceTooMuchException;
import com.epam.training.exceptions.SpaceUsageTooMuchException;
import com.epam.training.models.illumination.DefaultWindow;
import com.epam.training.models.illumination.Illumination;
import com.epam.training.models.illumination.LightBulb;
import com.epam.training.models.illumination.Window;
import com.epam.training.models.things.Furniture;
import com.epam.training.models.things.TransformFurniture;
import com.epam.training.validators.IlluminationValidator;
import com.epam.training.validators.SquareValidator;

import java.util.ArrayList;


public class Room {

    private String name;
    private double square;

    private ArrayList<Window> listWindows;
    private ArrayList<LightBulb> lisstLightBulbs;
    private ArrayList<Furniture> listFurnitures;

    public Room(String name, double square, int windowsCount) throws IlluminanceTooMuchException {
        this.name = name;
        this.square = square;
        this.listWindows = new ArrayList<Window>();
        this.lisstLightBulbs = new ArrayList<LightBulb>();
        this.listFurnitures = new ArrayList<Furniture>();
        addDefaultWindows(windowsCount);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public ArrayList<Window> getWindows() {
        return listWindows;
}

    public void setWindows(ArrayList<Window> windows) {
        this.listWindows = windows;
    }

    public ArrayList<LightBulb> getLightBulbs() {
        return lisstLightBulbs;
    }

    public void setLightBulbs(ArrayList<LightBulb> lightBulbs) {
        this.lisstLightBulbs = lightBulbs;
    }

    public ArrayList<Furniture> getFurnitures() {
        return listFurnitures;
    }

    public void setFurnitures(ArrayList<Furniture> furnitures) {
        this.listFurnitures = furnitures;
    }

    private void addDefaultWindows(int windowsCount) throws IlluminanceTooMuchException{
        for(; 0 < windowsCount; windowsCount--){
            DefaultWindow defaultWindow = new DefaultWindow();
            IlluminationValidator.validate(this, defaultWindow);
            this.listWindows.add(defaultWindow);
        }
    }

    public void addLightBulb(LightBulb lightBulb) throws IlluminanceTooMuchException{
        IlluminationValidator.validate(this, lightBulb);
        lisstLightBulbs.add(lightBulb);
    }

    public void addFurniture(Furniture thing) throws SpaceUsageTooMuchException {
        SquareValidator.validate(this, thing);
        this.listFurnitures.add(thing);
    }

    public void addWindow(Window window) throws IlluminanceTooMuchException{
        IlluminationValidator.validate(this, window);
        listWindows.add(window);
    }

    public int getTotalIllumation(){
        ArrayList<Illumination> listIlluminations = new ArrayList<Illumination>(this.lisstLightBulbs);
        listIlluminations.addAll(this.listWindows);
        return listIlluminations.stream().mapToInt(Illumination::getIllumination).sum();
    }

    public double getTotalSquare(){
        return this.listFurnitures.stream().mapToDouble(Furniture::getSquare).sum();
    }

    public double getMinTotalSquare(){

        double totalMaxSquare = this.listFurnitures.stream().mapToDouble(Furniture::getSquare).sum();
        double differenceSquare = 0;

        for (Furniture furnit : this.listFurnitures) {
            if (TransformFurniture.class.isAssignableFrom(furnit.getClass())) {
                TransformFurniture transformFurniture = (TransformFurniture) furnit;
                differenceSquare += (transformFurniture.getSquare() - transformFurniture.getMinSquare());
            }
            
        }
        return totalMaxSquare - differenceSquare;

    }


}
