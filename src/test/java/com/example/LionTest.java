package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

@RunWith(Enclosed.class)
public class LionTest {
    @Mock
    private static Feline feline;

    @RunWith(Parameterized.class)
    public static class ParamTests {
        private final String sex;
        private final boolean expectedMane;

        public ParamTests(String sex, boolean expectedMane) {
            this.sex = sex;
            this.expectedMane = expectedMane;
        }

        @Parameters
        public static List<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"Самец", true},
                    {"Самка", false}
            });
        }

        @Test
        public void setMaleOrFemale() throws Exception {
            Lion lion = new Lion(sex, feline);
            Assert.assertEquals(expectedMane, lion.doesHaveMane());
        }
    }

    public static class SingleTests {
        @Test
        public void eatMeat() throws Exception {
            Feline mockFeline = Mockito.mock(Feline.class);
            Mockito.when(mockFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Lion lion = new Lion("Самец", mockFeline);
            Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
        }

        @Test
        public void kittens() throws Exception {
            Feline feline = Mockito.mock(Feline.class);
            Mockito.when(feline.getKittens()).thenReturn(1);
            Lion lion = new Lion("Самец", feline);
            Assert.assertEquals(1, lion.getKittens());
        }

        @Test
        public void testException() {
            Throwable ex = Assert.assertThrows(
                    Exception.class,
                    () -> new Lion("abcd", feline)
            );
            Assert.assertEquals(
                    "Используйте допустимые значения пола животного - самец или самка",
                    ex.getMessage()
            );
        }
    }

}
