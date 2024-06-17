package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;
public class CatTest {
    Feline feline = new Feline();
    @Mock
    Cat cat = new Cat(feline);
    @Test
    public void sound() {
        Assert.assertEquals("Мяу", cat.getSound());
    }
    @Test
    public void eatMeat() throws Exception {
        Assert.assertEquals(cat.getFood(), List.of("Животные", "Птицы", "Рыба"));
    }
}
