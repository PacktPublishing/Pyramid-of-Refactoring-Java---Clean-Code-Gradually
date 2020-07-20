/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.factories.spec;

import pl.refactoring.interpreter.factories.EstateMaterial;
import pl.refactoring.interpreter.factories.EstatePlacement;
import pl.refactoring.interpreter.factories.EstateType;
import pl.refactoring.interpreter.factories.Spec;

public class Specs {
    public static Spec ofAreaRange(float minArea, float maxArea) {
        return new AreaRangeSpec(minArea, maxArea);
    }

    public static Spec belowArea(float maxBuildingArea) {
        return new BelowAreaSpec(maxBuildingArea);
    }

    public static Spec ofMaterial(EstateMaterial material) {
        return new MaterialSpec(material);
    }

    public static Spec not(Spec spec) {
        return new NotSpec(spec);
    }

    public static Spec placedIn(EstatePlacement placement) {
        return new PlacementSpec(placement);
    }

    public static Spec ofType(EstateType type) {
        return new TypeSpec(type);
    }
}
