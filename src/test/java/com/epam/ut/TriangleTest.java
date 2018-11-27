package com.epam.ut;

import com.epam.ut.triangle.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleTest {

    //-----------TEST TRIANGLE TYPE GROUP

    @Test(groups = {"tst_triangle_type"})
    public void tst_equilateral_triangle() {
        Triangle equilateralTriangle = new Triangle(2, 2, 2);

        boolean isTriangle = equilateralTriangle.checkTriangle();

        Assert.assertTrue(isTriangle);
        Assert.assertEquals(3 , equilateralTriangle.detectTriangle());
    }

    @Test(groups = {"tst_triangle_type"})
    public void tst_isosceles_triangle() {
        Triangle isoscelesTriangle = new Triangle(10, 100, 100);

        boolean isTriangle = isoscelesTriangle.checkTriangle();

        Assert.assertTrue(isTriangle);
        Assert.assertEquals(2 , isoscelesTriangle.detectTriangle());
    }

    @Test(groups = {"tst_triangle_type"})
    public void tst_ordinary_triangle() {
        Triangle ordinaryTriangle = new Triangle(10, 6, 5);

        boolean isTriangle = ordinaryTriangle.checkTriangle();

        Assert.assertTrue(isTriangle);
        Assert.assertEquals(4 , ordinaryTriangle.detectTriangle());
    }

    @Test(groups = {"tst_triangle_type"})
    public void tst_rectangular_triangle() {
        Triangle rectangularTriangle = new Triangle(3, 4, 5);

        boolean isTriangle = rectangularTriangle.checkTriangle();

        Assert.assertTrue(isTriangle);
        Assert.assertEquals(8 , rectangularTriangle.detectTriangle());
    }

    //-----------TEST TRIANGLE TYPE GROUP
}
