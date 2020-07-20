/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.factories.spec;

import pl.refactoring.interpreter.factories.EstateType;
import pl.refactoring.interpreter.factories.RealEstate;
import pl.refactoring.interpreter.factories.Spec;

class TypeSpec implements Spec {
    private EstateType type;

    TypeSpec(EstateType type) {
        this.type = type;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return estate.getType().equals(type);
    }
}
