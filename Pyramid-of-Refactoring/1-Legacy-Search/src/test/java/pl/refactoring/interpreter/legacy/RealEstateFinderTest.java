/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */

package pl.refactoring.interpreter.legacy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RealEstateFinderTest {
    private RealEstateFinder finder;

    private static final RealEstate WOODEN_VILLAGE_BUNGALLOW =
            new RealEstate(1, 140, EstatePlacement.VILLAGE,
                    EstateType.BUNGALLOW, EstateMaterial.WOOD);

    private static final RealEstate WOODEN_VILLAGE_HOUSE =
            new RealEstate(2, 210, EstatePlacement.VILLAGE,
                    EstateType.HOUSE, EstateMaterial.WOOD);

    private static final RealEstate BRICK_TOWN_HOUSE =
            new RealEstate(3, 230, EstatePlacement.TOWN,
                    EstateType.HOUSE, EstateMaterial.BRICK);

    private static final RealEstate BRICK_VILLAGE_BUNGALLOW =
            new RealEstate(4, 130, EstatePlacement.VILLAGE,
                    EstateType.BUNGALLOW, EstateMaterial.BRICK);

    private static final RealEstate STONE_TOWN_CASTLE =
            new RealEstate(5, 3900, EstatePlacement.TOWN,
                    EstateType.CASTLE, EstateMaterial.STONE);

    private static final RealEstate FERROCONCRETE_CITY_FLAT =
            new RealEstate(6, 40, EstatePlacement.CITY,
                    EstateType.FLAT, EstateMaterial.FERROCONCRETE);

    private static final RealEstate BRICK_CITY_FLAT =
            new RealEstate(7, 69, EstatePlacement.CITY,
                    EstateType.FLAT, EstateMaterial.BRICK);

    private List<RealEstate> createProductRepository() {
        return Arrays.asList(WOODEN_VILLAGE_BUNGALLOW,
                WOODEN_VILLAGE_HOUSE,
                BRICK_TOWN_HOUSE,
                BRICK_VILLAGE_BUNGALLOW,
                STONE_TOWN_CASTLE,
                FERROCONCRETE_CITY_FLAT,
                BRICK_CITY_FLAT);
    }

    @BeforeAll
    public void setUp() {
        finder = new RealEstateFinder(createProductRepository());
    }

    @Test
    public void findSmallRealEstates() {
        //when
        List<RealEstate> foundResults = finder.byBelowArea(70);

        //then
        assertEquals(2, foundResults.size(), "found 2 estates");
        assertTrue(foundResults.contains(FERROCONCRETE_CITY_FLAT));
        assertTrue(foundResults.contains(BRICK_CITY_FLAT));
    }

    @Test
    public void findWoodenRealEstates() {
        //when
        List<RealEstate> foundResults = finder.byMaterial(EstateMaterial.WOOD);

        //then
        assertEquals(2, foundResults.size(), "found 2 estates");
        assertTrue(foundResults.contains(WOODEN_VILLAGE_BUNGALLOW));
        assertTrue(foundResults.contains(WOODEN_VILLAGE_HOUSE));
    }

    @Test
    public void findWoodenSmallProperty() {
        //when
        List<RealEstate> foundResults = finder.byMaterialBelowArea(EstateMaterial.WOOD, 150);

        //then
        assertEquals(1, foundResults.size(), "found 1 estate");
        assertTrue(foundResults.contains(WOODEN_VILLAGE_BUNGALLOW));
    }

    @Test
    public void findRealEstatesInTown() {
        //when
        List<RealEstate> foundResults = finder.byPlacement(EstatePlacement.TOWN);

        //then
        assertEquals(2, foundResults.size(), "found 2 estates");
        assertTrue(foundResults.contains(BRICK_TOWN_HOUSE));
        assertTrue(foundResults.contains(STONE_TOWN_CASTLE));
    }

    @Test
    public void findNonVillageRealEstates() {
        //when
        List<RealEstate> foundResults = finder.byAvoidingPlacement(EstatePlacement.VILLAGE);

        //then
        assertEquals(4, foundResults.size(), "found 4 estates");
        assertTrue(foundResults.contains(STONE_TOWN_CASTLE));
        assertTrue(foundResults.contains(BRICK_TOWN_HOUSE));
        assertTrue(foundResults.contains(BRICK_CITY_FLAT));
        assertTrue(foundResults.contains(FERROCONCRETE_CITY_FLAT));
    }

    @Test
    public void findByAreaRange() {
        //when
        List<RealEstate> foundResults = finder.byAreaRange(130, 140);

        //then
        assertEquals(2, foundResults.size(), "found 2 estates");
        assertTrue(foundResults.contains(BRICK_VILLAGE_BUNGALLOW));
        assertTrue(foundResults.contains(WOODEN_VILLAGE_BUNGALLOW));
    }

    @Test
    public void findAllHouses() {
        //when
        List<RealEstate> foundResults = finder.byType(EstateType.HOUSE);

        //then
        assertEquals(2, foundResults.size(), "found 2 estates");
        assertTrue(foundResults.contains(BRICK_TOWN_HOUSE));
        assertTrue(foundResults.contains(WOODEN_VILLAGE_HOUSE));
    }

    @Test
    public void findStoneCastlesInTowns() {
        //when
        List<RealEstate> foundResults = finder.byVerySpecificCriteria(EstateType.CASTLE, EstatePlacement.TOWN, EstateMaterial.STONE);

        //then
        assertEquals(1, foundResults.size(), "found 1 estate");
        assertTrue(foundResults.contains(STONE_TOWN_CASTLE));
    }
}
