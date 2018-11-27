package com.epam.ut;

import com.epam.ut.triangle.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleTest {

    @Test
    public void tst_equilateral_triangle() {
        Triangle equilateralTriangle = new Triangle(2, 2, 2);

        boolean isTriangle = equilateralTriangle.checkTriangle();

        Assert.assertTrue(isTriangle);
        System.out.println(equilateralTriangle.detectTriangle());
        Assert.assertEquals(1 , equilateralTriangle.detectTriangle());
    }

}
