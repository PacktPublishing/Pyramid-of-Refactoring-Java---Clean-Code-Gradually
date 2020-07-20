/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.factories.spec;

import pl.refactoring.interpreter.factories.Spec;

import java.util.ArrayList;
import java.util.List;

public class AndSpecBuilder {
    private List<Spec> specs = new ArrayList<>();

    public AndSpecBuilder withSpec(Spec spec){
        specs.add(spec);
        return this;
    }

    public AndSpec build() {
        return new AndSpec(specs.toArray(new Spec[specs.size()]));
    }
}