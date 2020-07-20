/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.factories.spec;

import pl.refactoring.interpreter.factories.EstatePlacement;
import pl.refactoring.interpreter.factories.RealEstate;
import pl.refactoring.interpreter.factories.Spec;

class PlacementSpec implements Spec {
    private final EstatePlacement placement;

    PlacementSpec(EstatePlacement placement) {
        this.placement = placement;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return estate.getPlacement().equals(placement);
    }
}
