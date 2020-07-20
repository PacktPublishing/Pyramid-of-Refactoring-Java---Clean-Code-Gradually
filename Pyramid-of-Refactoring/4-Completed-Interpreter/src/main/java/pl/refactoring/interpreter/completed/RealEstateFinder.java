/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.completed;

import pl.refactoring.interpreter.completed.spec.*;

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

    @Deprecated
    public List<RealEstate> byBelowArea(float maxBuildingArea){
        return bySpec(new BelowAreaSpec(maxBuildingArea));
    }

    @Deprecated
    public List<RealEstate> byMaterial(EstateMaterial material){
        return bySpec(new MaterialSpec(material));
    }

    @Deprecated
    public List<RealEstate> byMaterialBelowArea(EstateMaterial material, float maxBuildingArea){
        Spec materialSpec = new MaterialSpec(material);
        Spec belowAreaSpec = new BelowAreaSpec(maxBuildingArea);

        return bySpec(new AndSpec(materialSpec, belowAreaSpec));
    }

    @Deprecated
    public List<RealEstate> byPlacement(EstatePlacement placement){
        return bySpec(new PlacementSpec(placement));
    }

    @Deprecated
    public List<RealEstate> byAvoidingPlacement(EstatePlacement placement){
        return bySpec(new NotSpec(new PlacementSpec(placement)));
    }

    @Deprecated
    public List<RealEstate> byAreaRange(float minArea, float maxArea){
        return bySpec(new AreaRangeSpec(minArea, maxArea));
    }

    @Deprecated
    public List<RealEstate> byType(EstateType type){
        return bySpec(new TypeSpec(type));
    }

    @Deprecated
    public List<RealEstate> byVerySpecificCriteria(EstateType type, EstatePlacement placement, EstateMaterial material){
        Spec typeSpec = new TypeSpec(type);
        Spec placementSpec = new PlacementSpec(placement);
        Spec materialSpec = new MaterialSpec(material);

        return bySpec(new AndSpec(typeSpec, placementSpec, materialSpec));
    }

}
