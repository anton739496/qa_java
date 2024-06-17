package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class LionTest {
    Feline feline = new Feline();
    @Test
    public void setMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void setFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testException() throws Exception {
        Throwable ex = Assert.assertThrows(
                new Exception("Используйте допустимые значения пола животного - самец или самка").getClass(),
                ()->{Lion lion = new Lion("abcd", feline);}
        );
    }
    @Test
    public void eatMeat() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", mockFeline);
        Assert.assertEquals(lion.getFood(), List.of("Животные", "Птицы", "Рыба"));
    }
    @Test
    public void kittens() throws Exception {
        int kittens = (new Lion("Самец", feline)).getKittens();
        Assert.assertEquals(1, kittens);
    }
}
