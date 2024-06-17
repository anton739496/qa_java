package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {
    Feline feline = new Feline();
    @Test
    public void family() {
        String family = feline.getFamily();
        Assert.assertEquals("Кошачьи", family);
    }
    @Test
    public void kittens() {
        int kittens = feline.getKittens();
        Assert.assertEquals(1, kittens);
    }
    @Test
    public void kittensWithParam() {
        int countKittens = 2;
        int kittens = feline.getKittens(countKittens);
        Assert.assertEquals(countKittens, kittens);
    }
    @Test
    public void eatMeat() throws Exception {
        Assert.assertEquals(feline.eatMeat(), List.of("Животные", "Птицы", "Рыба"));
    }
}
