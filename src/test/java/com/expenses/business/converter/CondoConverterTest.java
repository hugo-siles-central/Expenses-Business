package com.expenses.business.converter;

import com.expenses.business.model.Condo;
import com.expenses.persistence.entities.CondoEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class CondoConverterTest {

    private CondoConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new CondoConverter();
    }

    @Test
    public void fromEntity_convertsCorrectly() {

        CondoEntity entity = new CondoEntity();
        entity.setId(1L);
        entity.setName("test name");
        entity.setAddress("test address");
        entity.setPhones("test phones");

        Optional<Condo> condoOptional = converter.fromEntity(entity);
        Condo condo = condoOptional.get();

        assertEquals(1L, condo.getId(), 0);
        assertEquals("test name", condo.getName());
        assertEquals("test address", condo.getAddress());
        assertEquals("test phones", condo.getPhones());
    }

    @Test
    public void fromEntity_handlesNullEntity() {

        Optional<Condo> condoOptional = converter.fromEntity(null);
        assertFalse(condoOptional.isPresent());
    }

    @Test
    public void fromModel_convertsCorrectly() {

        Condo condo = new Condo();
        condo.setId(1L);
        condo.setName("test name");
        condo.setAddress("test address");
        condo.setPhones("test phones");

        Optional<CondoEntity> entityOptional = converter.fromModel(condo);
        CondoEntity entity = entityOptional.get();

        assertEquals(1L, entity.getId(), 0);
        assertEquals("test name", entity.getName());
        assertEquals("test address", entity.getAddress());
        assertEquals("test phones", entity.getPhones());
    }

    @Test
    public void fromModel_handlesNullEntity() {

        Optional<CondoEntity> entityOptional = converter.fromModel(null);
        assertFalse(entityOptional.isPresent());
    }

}