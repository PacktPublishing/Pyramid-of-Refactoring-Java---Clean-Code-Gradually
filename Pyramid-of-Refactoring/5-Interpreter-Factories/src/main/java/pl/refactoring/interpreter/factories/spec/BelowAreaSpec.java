/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.factories.spec;

import pl.refactoring.interpreter.factories.RealEstate;
import pl.refactoring.interpreter.factories.Spec;

class BelowAreaSpec implements Spec {
    private float maxBuildingArea;

    BelowAreaSpec(float maxBuildingArea) {
        this.maxBuildingArea = maxBuildingArea;
    }

    @Override
    public boolean isSatisfiedBy(RealEstate estate) {
        return estate.getBuildingArea() < maxBuildingArea;
    }
}
