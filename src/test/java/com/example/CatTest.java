package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class CatTest {

    @Mock
    Feline feline;

    Cat cat;

    private final List<String> expectedFood;

    public CatTest(List<String> expectedFood) {
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { List.of("Животные", "Птицы", "Рыба") }
        });
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cat = new Cat(feline);
    }

    @Test
    public void sound() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void eatMeat() throws Exception {
        when(feline.eatMeat()).thenReturn(expectedFood);
        Assert.assertEquals(expectedFood, cat.getFood());
    }
}