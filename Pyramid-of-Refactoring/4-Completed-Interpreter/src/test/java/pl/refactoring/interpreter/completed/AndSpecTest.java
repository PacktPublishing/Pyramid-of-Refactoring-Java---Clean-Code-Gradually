package pl.refactoring.interpreter.completed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import pl.refactoring.interpreter.completed.spec.AndSpec;

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
        AndSpec andSpec = new AndSpec(yesSpec, yesSpec, yesSpec);

        assertThat(andSpec.isSatisfiedBy(BRICK_VILLAGE_BUNGALLOW))
                .isTrue();

        Mockito.verify(yesSpec, Mockito.times(3)).isSatisfiedBy(BRICK_VILLAGE_BUNGALLOW);
    }

    @Test
    void multipleFalses() {
        AndSpec andSpec = new AndSpec(noSpec, noSpec, noSpec);

        assertThat(andSpec.isSatisfiedBy(BRICK_VILLAGE_BUNGALLOW))
                .isFalse();

        Mockito.verify(noSpec, Mockito.times(1)).isSatisfiedBy(BRICK_VILLAGE_BUNGALLOW);
    }
}
