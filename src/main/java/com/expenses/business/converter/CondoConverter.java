package com.expenses.business.converter;

import com.expenses.business.model.Condo;
import com.expenses.persistence.entities.CondoEntity;

import java.util.Optional;

public class CondoConverter implements IConverter<Condo, CondoEntity>{

    public Optional<Condo> fromEntity(CondoEntity anEntity){

        if (anEntity == null){
            return Optional.empty();
        }

        Condo result = new Condo();
        result.setId(anEntity.getId());
        result.setName(anEntity.getName());
        result.setAddress(anEntity.getAddress());
        result.setPhones(anEntity.getPhones());
        return Optional.of(result);
    }

    public Optional<CondoEntity> fromModel(Condo aCondo){
        if (aCondo == null){
            return Optional.empty();
        }

        CondoEntity result = new CondoEntity();
        result.setId(aCondo.getId());
        result.setName(aCondo.getName());
        result.setAddress(aCondo.getAddress());
        result.setPhones(aCondo.getPhones());
        return Optional.of(result);
    }

}
