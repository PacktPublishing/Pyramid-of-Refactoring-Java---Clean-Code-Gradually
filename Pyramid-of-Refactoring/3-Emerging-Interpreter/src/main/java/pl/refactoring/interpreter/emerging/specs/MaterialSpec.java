/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.emerging.specs;

import pl.refactoring.interpreter.emerging.EstateMaterial;
import pl.refactoring.interpreter.emerging.RealEstate;
import pl.refactoring.interpreter.emerging.Spec;

public class MaterialSpec implements Spec {
    private EstateMaterial material;

    public MaterialSpec(EstateMaterial material) {
        this.material = material;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return estate.getMaterial().equals(material);
    }
}