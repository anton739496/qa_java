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

public class CatTest {

    @Mock
    private Feline feline;
    private Cat cat;

    private List<String> expectedFood;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cat = new Cat(feline);
        expectedFood = List.of("Животные", "Птицы", "Рыба");
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