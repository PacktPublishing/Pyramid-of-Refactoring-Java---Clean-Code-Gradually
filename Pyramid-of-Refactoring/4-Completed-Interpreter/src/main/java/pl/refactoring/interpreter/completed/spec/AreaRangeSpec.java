/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.completed.spec;

import pl.refactoring.interpreter.completed.RealEstate;
import pl.refactoring.interpreter.completed.Spec;

public class AreaRangeSpec implements Spec {
    private final float minArea;
    private final float maxArea;

    public AreaRangeSpec(float minArea, float maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        float buildingArea = estate.getBuildingArea();
        return buildingArea >= minArea && buildingArea <= maxArea;
    }
}
