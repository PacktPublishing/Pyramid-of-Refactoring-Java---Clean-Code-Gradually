package pl.refactoring.interpreter.legacy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
public class RealEstateFinder {
    private List<RealEstate> repository;

    public RealEstateFinder(List<RealEstate> repository) {
        this.repository = repository;
    }

    public List<RealEstate> byBelowArea(float maxBuildingArea){
        List<RealEstate> foundRealEstates = new ArrayList<>();
        Iterator<RealEstate> estates = repository.iterator();
        while (estates.hasNext()) {
            RealEstate estate = estates.next();
            if (estate.getBuildingArea() < maxBuildingArea)
                foundRealEstates.add(estate);
        }
        return foundRealEstates;
    }

    public List<RealEstate> byMaterial(EstateMaterial material){
        List<RealEstate> foundRealEstates = new ArrayList<>();

        Iterator<RealEstate> estates = repository.iterator();
        while (estates.hasNext()) {
            RealEstate estate = estates.next();
            if (estate.getMaterial().equals(material))
                foundRealEstates.add(estate);
        }
        return foundRealEstates;
    }

    public List<RealEstate> byMaterialBelowArea(EstateMaterial material, float maxBuildingArea){
        List<RealEstate> foundRealEstates = new ArrayList<>();

        Iterator<RealEstate> estates = repository.iterator();
        while (estates.hasNext()) {
            RealEstate estate = estates.next();
            if (estate.getMaterial().equals(material) && estate.getBuildingArea() < maxBuildingArea)
                foundRealEstates.add(estate);
        }
        return foundRealEstates;
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
