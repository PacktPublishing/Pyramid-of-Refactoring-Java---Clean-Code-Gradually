/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.factories.spec;

import pl.refactoring.interpreter.factories.EstateMaterial;
import pl.refactoring.interpreter.factories.RealEstate;
import pl.refactoring.interpreter.factories.Spec;

class MaterialSpec implements Spec {
    private EstateMaterial material;

    MaterialSpec(EstateMaterial material) {
        this.material = material;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return estate.getMaterial().equals(material);
    }
}