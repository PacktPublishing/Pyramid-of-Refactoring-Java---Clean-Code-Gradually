/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.factories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import pl.refactoring.interpreter.factories.spec.AndSpecBuilder;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AndSpecTest {

    private static final RealEstate BRICK_VILLAGE_BUNGALLOW =
            new RealEstate(4, 130, EstatePlacement.VILLAGE,
                    EstateType.BUNGALLOW, EstateMaterial.BRICK);

    private Spec yesSpec;
    private Spec noSpec;


    @BeforeEach
    public void setUp() {
        yesSpec = Mockito.mock(Spec.class);
        Mockito.when(yesSpec.isSatisfiedBy(Mockito.any(RealEstate.class))).thenReturn(true);

        noSpec = Mockito.mock(Spec.class);
        Mockito.when(noSpec.isSatisfiedBy(Mockito.any(RealEstate.class))).thenReturn(false);
    }

    @Test
    void multipleTrues() {
        Spec andSpec = new AndSpecBuilder().withSpec(yesSpec)
                .withSpec(yesSpec)
                .withSpec(yesSpec)
                .build();

        assertThat(andSpec.isSatisfiedBy(BRICK_VILLAGE_BUNGALLOW))
                .isTrue();

        Mockito.verify(yesSpec, Mockito.times(3)).isSatisfiedBy(BRICK_VILLAGE_BUNGALLOW);
    }

    @Test
    void multipleFalses() {
        Spec andSpec = new AndSpecBuilder().withSpec(noSpec)
                .withSpec(noSpec)
                .withSpec(noSpec).build();

        assertThat(andSpec.isSatisfiedBy(BRICK_VILLAGE_BUNGALLOW))
                .isFalse();

        Mockito.verify(noSpec, Mockito.times(1)).isSatisfiedBy(BRICK_VILLAGE_BUNGALLOW);
    }
}
