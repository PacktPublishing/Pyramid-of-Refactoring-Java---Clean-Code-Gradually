/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.factories;

import java.util.function.Predicate;

public interface Spec extends Predicate<RealEstate> {
    boolean isSatisfiedBy(RealEstate estate);

    @Override
    default boolean test(RealEstate realEstate) {
        return isSatisfiedBy(realEstate);
    }
}
