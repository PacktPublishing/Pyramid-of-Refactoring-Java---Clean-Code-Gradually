/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.factories.spec;

import pl.refactoring.interpreter.factories.RealEstate;
import pl.refactoring.interpreter.factories.Spec;

class AreaRangeSpec implements Spec {
    private final float minArea;
    private final float maxArea;

    AreaRangeSpec(float minArea, float maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        float buildingArea = estate.getBuildingArea();
        return buildingArea >= minArea && buildingArea <= maxArea;
    }
}
