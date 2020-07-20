/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.emerging.specs;

import pl.refactoring.interpreter.emerging.RealEstate;
import pl.refactoring.interpreter.emerging.Spec;

import java.util.stream.Stream;

public class AndSpec implements Spec {
    private final Spec firstSpec;
    private final Spec secondSpec;

    public AndSpec(Spec firstSpec, Spec secondSpec) {
        this.firstSpec = firstSpec;
        this.secondSpec = secondSpec;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return firstSpec.isSatisfiedBy(estate) &&
                secondSpec.isSatisfiedBy(estate);
    }
}
