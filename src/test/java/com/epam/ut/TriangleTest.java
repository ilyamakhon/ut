package com.epam.ut;

import com.epam.ut.triangle.Triangle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TriangleTest {

    private boolean isTriangle;

    @DataProvider
    public Object[][] dataProvider(Method method)
    {
        switch (method.getName()) {
            //----------------TEST DATA FOR TRIANGLE DETECTOR TEST GROUP | POSITIVE TESTS
            case "tst_positive_equilateral_triangle" :
                return new Object[][] {{new Triangle(2,2,2)}};
            case "tst_positive_isosceles_triangle" :
                return new Object[][] {{new Triangle(10, 100, 100)}};
            case "tst_positive_ordinary_triangle" :
                return new Object[][] {{new Triangle(10, 6, 5)}};
            case "tst_positive_rectangular_triangle" :
                return new Object[][] {{new Triangle(3, 4, 5)}};
            //----------------TEST DATA FOR TRIANGLE DETECTOR TEST GROUP | POSITIVE TESTS

            //----------------TEST DATA FOR TRIANGLE DETECTOR TEST GROUP | NEGATIVE TESTS
            case "tst_negative_equilateral_triangle" :
                return new Object[][] {
                    {new Triangle(-2,-2,-2)},
                    {new Triangle(2,-2,-2)},
                    {new Triangle(-2,2,-2)},
                    {new Triangle(-2,-2,2)}};

            case "tst_negative_isosceles_triangle" :
                return new Object[][] {
                    {new Triangle(-10, -100, -100)},
                    {new Triangle(10, -100, -100)},
                    {new Triangle(-10, 100, -100)},
                    {new Triangle(-10, -100, 100)}};
            case "tst_negative_ordinary_triangle" :
                return new Object[][] {
                    {new Triangle(-10, -6, -5)},
                    {new Triangle(10, -6, -5)},
                    {new Triangle(-10, 6, -5)},
                    {new Triangle(-10, -6, 5)}};
            case "tst_negative_rectangular_triangle" :
                return new Object[][] {
                    {new Triangle(-3, -4, -5)},
                    {new Triangle(3, -4, -5)},
                    {new Triangle(-3, 4, -5)},
                    {new Triangle(-3, -4, 5)}};
            //----------------TEST DATA FOR TRIANGLE DETECTOR TEST GROUP | NEGATIVE TESTS

            //----------------TEST DATA FOR TRIANGLE CHECKER TEST GROUP | POSITIVE TESTS
            case "tst_all_positive_sides_handling" :
                return new Object[][] {{new Triangle(3, 4, 5)}};
            case "tst_a_plus_b_side_greater_than_c_side_handling" :
                return new Object[][] {{new Triangle(4, 4, 6)}};
            case "tst_a_plus_c_side_greater_than_b_side_handling" :
                return new Object[][] {{new Triangle(4, 6, 4)}};
            case "tst_b_plus_c_side_greater_than_a_side_handling" :
                return new Object[][] {{new Triangle(6, 4, 4)}};
            //----------------TEST DATA FOR TRIANGLE CHECKER TEST GROUP | POSITIVE TESTS

            //----------------TEST DATA FOR TRIANGLE CHECKER TEST GROUP | NEGATIVE TESTS
            case "tst_negative_a_side_handling" :
                return new Object[][] {{new Triangle(-3, 4, 5)}};
            case "tst_negative_b_side_handling" :
                return new Object[][] {{new Triangle(3, -4, 5)}};
            case "tst_negative_c_side_handling" :
                return new Object[][] {{new Triangle(3, 4, -5)}};
            case "tst_all_negative_sides_handling" :
                return new Object[][] {{new Triangle(-3, -4, -5)}};
            case "tst_a_plus_b_side_less_than_c_side_handling" :
                return new Object[][] {{new Triangle(4, 4, 10)}};
            case "tst_a_plus_c_side_less_than_b_side_handling" :
                return new Object[][] {{new Triangle(4, 10, 4)}};
            case "tst_b_plus_c_side_less_than_a_side_handling" :
                return new Object[][] {{new Triangle(10, 4, 4)}};
            //----------------TEST DATA FOR TRIANGLE CHECKER TEST GROUP | NEGATIVE TESTS

        }
        return new Object[][]{};
    }

    //----------------------TEST TRIANGLE CHECKER GROUP

    //-----------POSITIVE TESTS
    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_checker_positive_group"})
    public void tst_all_positive_sides_handling(Triangle allSidesPositiveValueTriangle) {
        isTriangle = allSidesPositiveValueTriangle.checkTriangle();
        Assert.assertTrue(isTriangle);
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_checker_positive_group"})
    public void tst_a_plus_b_side_greater_than_c_side_handling(Triangle aPlusBSideGreaterThanCSideTriangle) {
        isTriangle = aPlusBSideGreaterThanCSideTriangle.checkTriangle();
        Assert.assertTrue(isTriangle);
    }


    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_checker_positive_group"})
    public void tst_a_plus_c_side_greater_than_b_side_handling(Triangle aPlusCSideGreaterThanBSideTriangle) {
        isTriangle = aPlusCSideGreaterThanBSideTriangle.checkTriangle();
        Assert.assertTrue(isTriangle);
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_checker_positive_group"})
    public void tst_b_plus_c_side_greater_than_a_side_handling(Triangle bPlusCSideGreaterThanASideTriangle) {
        isTriangle = bPlusCSideGreaterThanASideTriangle.checkTriangle();
        Assert.assertTrue(isTriangle);
    }
    //-----------POSITIVE TESTS

    //-----------NEGATIVE TESTS
    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_checker_negative_group"}, expectedExceptions = Exception.class)
    public void tst_negative_a_side_handling(Triangle aSideNegativeTriangle) {
        isTriangle = aSideNegativeTriangle.checkTriangle();
        Assert.assertFalse(isTriangle);
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_checker_negative_group"}, expectedExceptions = Exception.class)
    public void tst_negative_b_side_handling(Triangle bSideNegativeTriangle) {
        isTriangle = bSideNegativeTriangle.checkTriangle();
        Assert.assertFalse(isTriangle);
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_checker_negative_group"}, expectedExceptions = Exception.class)
    public void tst_negative_c_side_handling(Triangle cSideNegativeTriangle) {
        isTriangle = cSideNegativeTriangle.checkTriangle();
        Assert.assertFalse(isTriangle);
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_checker_negative_group"}, expectedExceptions = Exception.class)
    public void tst_all_negative_sides_handling(Triangle allSidesNegativeValueTriangle) {
        isTriangle = allSidesNegativeValueTriangle.checkTriangle();
        Assert.assertFalse(isTriangle);
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_checker_negative_group"}, expectedExceptions = Exception.class)
    public void tst_a_plus_b_side_less_than_c_side_handling(Triangle aPlusBSideLessThanCSideTriangle) {
        isTriangle = aPlusBSideLessThanCSideTriangle.checkTriangle();
        Assert.assertEquals("a+b<=c", aPlusBSideLessThanCSideTriangle.getMessage());
        Assert.assertFalse(isTriangle);
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_checker_negative_group"}, expectedExceptions = Exception.class)
    public void tst_a_plus_c_side_less_than_b_side_handling(Triangle aPlusCSideLessThanBSideTriangle) {
        isTriangle = aPlusCSideLessThanBSideTriangle.checkTriangle();
        Assert.assertEquals("a+c<=b", aPlusCSideLessThanBSideTriangle.getMessage());
        Assert.assertFalse(isTriangle);
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_checker_negative_group"}, expectedExceptions = Exception.class)
    public void tst_b_plus_c_side_less_than_a_side_handling(Triangle bPlusCSideLessThanASideTriangle) {
        isTriangle = bPlusCSideLessThanASideTriangle.checkTriangle();
        Assert.assertEquals("b+c<=a", bPlusCSideLessThanASideTriangle.getMessage());
        Assert.assertFalse(isTriangle);
    }
    //-----------NEGATIVE TESTS

    //----------------------TEST TRIANGLE CHECKER GROUP

    //----------------------TEST TRIANGLE DETECTOR GROUP

    //-----------POSITIVE TESTS
    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_detector_positive_group"})
    public void tst_positive_equilateral_triangle(Triangle equilateralTriangle) {
        Assert.assertEquals(1 , equilateralTriangle.detectTriangle());
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_detector_positive_group"})
    public void tst_positive_isosceles_triangle(Triangle isoscelesTriangle) {
        Assert.assertEquals(2 , isoscelesTriangle.detectTriangle());
    }
    
    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_detector_positive_group"})
    public void tst_positive_ordinary_triangle(Triangle ordinaryTriangle) {
        Assert.assertEquals(4 , ordinaryTriangle.detectTriangle());
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_detector_positive_group"})
    public void tst_positive_rectangular_triangle(Triangle rectangularTriangle) {
        Assert.assertEquals(8 , rectangularTriangle.detectTriangle());
    }
    //-----------POSITIVE TESTS

    //-----------NEGATIVE TESTS
    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_detector_negative_group"}, expectedExceptions = Exception.class)
    public void tst_negative_equilateral_triangle(Triangle equilateralTriangle) {
        Assert.assertEquals(1 , equilateralTriangle.detectTriangle());
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_detector_negative_group"}, expectedExceptions = Exception.class)
    public void tst_negative_isosceles_triangle(Triangle isoscelesTriangle) {
        Assert.assertEquals(2 , isoscelesTriangle.detectTriangle());
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_detector_negative_group"}, expectedExceptions = Exception.class)
    public void tst_negative_ordinary_triangle(Triangle ordinaryTriangle) {
        Assert.assertEquals(4 , ordinaryTriangle.detectTriangle());
    }

    @Test(dataProvider = "dataProvider", groups = {"tst_triangle_detector_negative_group"}, expectedExceptions = Exception.class)
    public void tst_negative_rectangular_triangle(Triangle rectangularTriangle) {
        Assert.assertEquals(8 , rectangularTriangle.detectTriangle());
    }
    //-----------NEGATIVE TESTS

    //----------------------TEST TRIANGLE DETECTOR GROUP

}
