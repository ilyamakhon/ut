package com.epam.ut;

import com.epam.ut.triangle.Triangle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TriangleTest {


    @DataProvider
    public Object[][] dataProvider(Method method)
    {
        switch (method.getName()) {
            case "tst_equilateral_triangle" :
                return new Object[][] {{new Triangle(2,2,2)}};
            case "tst_isosceles_triangle" :
                return new Object[][] {{new Triangle(10, 100, 100)}};
            case "tst_ordinary_triangle" :
                return new Object[][] {{new Triangle(10, 6, 5)}};
            case "tst_rectangular_triangle" :
                return new Object[][] {{new Triangle(3, 4, 5)}};
            case "tst_negative_a_side_handling" :
                return new Object[][] {{new Triangle(-3, 4, 5)}};
            case "tst_negative_b_side_handling" :
                return new Object[][] {{new Triangle(3, -4, 5)}};
            case "tst_negative_c_side_handling" :
                return new Object[][] {{new Triangle(3, 4, -5)}};
        }
        return new Object[][]{};
    }

    //-----------TEST TRIANGLE DETECTOR GROUP

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_detector"})
    public void tst_equilateral_triangle(Triangle equilateralTriangle) {
        Assert.assertEquals(3 , equilateralTriangle.detectTriangle());
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_detector"})
    public void tst_isosceles_triangle(Triangle isoscelesTriangle) {
        Assert.assertEquals(2 , isoscelesTriangle.detectTriangle());
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_detector"})
    public void tst_ordinary_triangle(Triangle ordinaryTriangle) {
        Assert.assertEquals(4 , ordinaryTriangle.detectTriangle());
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_detector"})
    public void tst_rectangular_triangle(Triangle rectangularTriangle) {
        Assert.assertEquals(8 , rectangularTriangle.detectTriangle());
    }

    //-----------TEST TRIANGLE DETECTOR GROUP

    //-----------TEST TRIANGLE CHECKER GROUP

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_checker"})
    public void tst_negative_a_side_handling(Triangle aSideNegativeTriangle) {
        boolean checkASide = aSideNegativeTriangle.checkTriangle();
        Assert.assertFalse(checkASide);
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_checker"})
    public void tst_negative_b_side_handling(Triangle bSideNegativeTriangle) {
        boolean checkBSide = bSideNegativeTriangle.checkTriangle();
        Assert.assertFalse(checkBSide);
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_checker"})
    public void tst_negative_c_side_handling(Triangle cSideNegativeTriangle) {
        boolean checkCSide = cSideNegativeTriangle.checkTriangle();
        Assert.assertFalse(checkCSide);
    }

    //-----------TEST TRIANGLE CHECKER GROUP
}
