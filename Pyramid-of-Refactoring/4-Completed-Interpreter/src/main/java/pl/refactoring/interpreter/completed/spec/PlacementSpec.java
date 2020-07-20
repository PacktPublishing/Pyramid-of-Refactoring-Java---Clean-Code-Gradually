/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.completed.spec;

import pl.refactoring.interpreter.completed.EstatePlacement;
import pl.refactoring.interpreter.completed.RealEstate;
import pl.refactoring.interpreter.completed.Spec;

public class PlacementSpec implements Spec {
    private final EstatePlacement placement;

    public PlacementSpec(EstatePlacement placement) {
        this.placement = placement;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return estate.getPlacement().equals(placement);
    }
}
