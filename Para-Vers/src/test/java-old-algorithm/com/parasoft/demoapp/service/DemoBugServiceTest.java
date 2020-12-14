package com.parasoft.demoapp.service;


import com.parasoft.demoapp.repository.global.DemoBugRepository;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for DemoBugService
 *
 * @see DemoBugService
 * @author jakubiak
 */
public class DemoBugServiceTest
{
    /**
     * Parasoft Jtest UTA: Test for removeByGlobalPreferencesId(Long)
     *
     * @author jakubiak
     * @see DemoBugService#removeByGlobalPreferencesId(Long)
     */
    @Test
    public void testRemoveByGlobalPreferencesId() throws Throwable {
        // Given
        DemoBugService underTest = new DemoBugService();
        DemoBugRepository demoBugRepositoryValue = mockDemoBugRepository();
        ReflectionTestUtils.setField(underTest, "demoBugRepository", demoBugRepositoryValue);

        // When
        Long id = 0L; // UTA: default value
        underTest.removeByGlobalPreferencesId(id);

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of DemoBugRepository
     */
    private static DemoBugRepository mockDemoBugRepository() throws Throwable {
        DemoBugRepository demoBugRepositoryValue = mock(DemoBugRepository.class);
        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                long globalPreferencesId = (Long) invocation.getArguments()[0];
                // UTA: Auto-generated answer method
                return null;
            }
        }).when(demoBugRepositoryValue).deleteByGlobalPreferencesId(anyLong());
        return demoBugRepositoryValue;
    }
}