/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.emerging;

import pl.refactoring.interpreter.emerging.specs.AndSpec;
import pl.refactoring.interpreter.emerging.specs.BelowAreaSpec;
import pl.refactoring.interpreter.emerging.specs.MaterialSpec;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class RealEstateFinder {
    private List<RealEstate> repository;

    public RealEstateFinder(List<RealEstate> repository) {
        this.repository = repository;
    }

    public List<RealEstate> bySpec(Spec spec) {
        return repository.stream()
                .filter(spec::isSatisfiedBy)
                .collect(Collectors.toList());
    }

    public List<RealEstate> byBelowArea(float maxBuildingArea){
        return bySpec(new BelowAreaSpec(maxBuildingArea));
    }

    public List<RealEstate> byMaterial(EstateMaterial material){
        return bySpec(new MaterialSpec(material));

    }

    public List<RealEstate> byMaterialBelowArea(EstateMaterial material, float maxBuildingArea){
        Spec materialSpec = new MaterialSpec(material);
        Spec belowAreaSpec = new BelowAreaSpec(maxBuildingArea);

        return bySpec(new AndSpec(materialSpec, belowAreaSpec));
    }

    public List<RealEstate> byPlacement(EstatePlacement placement){
        List<RealEstate> foundRealEstates = new ArrayList<>();

        Iterator<RealEstate> estates = repository.iterator();
        while (estates.hasNext()) {
            RealEstate estate = estates.next();
            if (estate.getPlacement().equals(placement))
                foundRealEstates.add(estate);
        }
        return foundRealEstates;
    }

    public List<RealEstate> byAvoidingPlacement(EstatePlacement placement){
        List<RealEstate> foundRealEstates = new ArrayList<>();

        Iterator<RealEstate> estates = repository.iterator();
        while (estates.hasNext()) {
            RealEstate estate = estates.next();
            if (! estate.getPlacement().equals(placement))
                foundRealEstates.add(estate);
        }
        return foundRealEstates;
    }

    public List<RealEstate> byAreaRange(float minArea, float maxArea){
        List<RealEstate> foundRealEstates = new ArrayList<>();

        Iterator<RealEstate> estates = repository.iterator();
        while (estates.hasNext()) {
            RealEstate estate = estates.next();
            if (estate.getBuildingArea() >= minArea && estate.getBuildingArea() <= maxArea)
                foundRealEstates.add(estate);
        }
        return foundRealEstates;
    }

    public List<RealEstate> byType(EstateType type){
        List<RealEstate> foundRealEstates = new ArrayList<>();

        Iterator<RealEstate> estates = repository.iterator();
        while (estates.hasNext()) {
            RealEstate estate = estates.next();
            if (estate.getType().equals(type))
                foundRealEstates.add(estate);
        }
        return foundRealEstates;
    }

    public List<RealEstate> byVerySpecificCriteria(EstateType type, EstatePlacement placement, EstateMaterial material){
        List<RealEstate> foundRealEstates = new ArrayList<>();

        Iterator<RealEstate> estates = repository.iterator();
        while (estates.hasNext()) {
            RealEstate estate = estates.next();
            if (estate.getType().equals(type) && estate.getPlacement().equals(placement) && estate.getMaterial().equals(material))
                foundRealEstates.add(estate);
        }
        return foundRealEstates;
    }
}
