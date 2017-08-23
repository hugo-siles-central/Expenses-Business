package com.expenses.business.service;

import com.expenses.business.ExpensesBusinessApplication;
import com.expenses.business.model.Condo;
import com.expenses.persistence.entities.CondoEntity;
import com.expenses.persistence.repository.CondoRepository;
import org.easymock.IAnswer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = {ExpensesBusinessApplication.class})
public class CondoServiceTest {

    private CondoRepository mockRepository;
    private CondoService condoService;

    @Before
    public void setUp() {

        mockRepository = createNiceMock(CondoRepository.class);
        condoService = new CondoService(mockRepository);

    }

    @Test
    public void registerCondo_checksPersistenceIsCalled() {
        String testName = "Test Name";
        String testAddress = "Test address";
        String testPhones = "Test phones";
        Long testID = 1234L;


        Condo aNewCondo = new Condo(testName, testAddress, testPhones);

        expect(mockRepository.save(isA(CondoEntity.class))).andAnswer(new IAnswer<CondoEntity>() {
            @Override
            public CondoEntity answer() throws Throwable {
                CondoEntity persistedCondo = (CondoEntity) getCurrentArguments()[0];
                persistedCondo.setId(testID);
                return persistedCondo;
            }
        }).once();

        replay(mockRepository);

        Condo result = condoService.registerCondo(aNewCondo);
        assertEquals(testID, result.getId());
        assertEquals(testName, result.getName());
        assertEquals(testAddress, result.getAddress());
        assertEquals(testPhones, result.getPhones());

        verify(mockRepository);

    }

    @Test (expected = IllegalArgumentException.class)
    public void registerCondo_handlesNullArgument() {

        condoService.registerCondo(null);
    }

}