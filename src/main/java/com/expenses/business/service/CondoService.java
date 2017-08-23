package com.expenses.business.service;

import com.expenses.business.converter.CondoConverter;
import com.expenses.business.model.Condo;
import com.expenses.persistence.entities.CondoEntity;
import com.expenses.persistence.repository.CondoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CondoService {

    @Autowired
    private CondoRepository repository;

    private CondoConverter converter;


    CondoService(CondoRepository repository) {
        this.repository = repository;
        this.converter = new CondoConverter();
    }

    public Condo registerCondo(Condo newCondo) {

        if (newCondo == null) {
            throw new IllegalArgumentException("Illegal argument, null condo received");
        }

        Optional<CondoEntity> entityOptional = converter.fromModel(newCondo);

        CondoEntity savedEntity = repository.save(entityOptional.get());
        newCondo.setId(savedEntity.getId());
        return newCondo;
    }
}
