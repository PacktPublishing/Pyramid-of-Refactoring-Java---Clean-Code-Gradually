/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.factories.spec;

import pl.refactoring.interpreter.factories.RealEstate;
import pl.refactoring.interpreter.factories.Spec;

class NotSpec implements Spec {
    private Spec spec;

    NotSpec(Spec spec) {
        this.spec = spec;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return ! spec.isSatisfiedBy(estate);
    }
}
