/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.completed.spec;

import pl.refactoring.interpreter.completed.RealEstate;
import pl.refactoring.interpreter.completed.Spec;

import java.util.stream.Stream;

public class AndSpec implements Spec {
    private Spec[] specs;

    public AndSpec(Spec ... specs) {
        this.specs = specs;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return Stream.of(specs)
                .allMatch(spec -> spec.isSatisfiedBy(estate));
    }
}
