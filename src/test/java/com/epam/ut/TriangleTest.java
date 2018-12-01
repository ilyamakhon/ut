package com.epam.ut;

import com.epam.ut.dataprovider.DataProviderClass;
import com.epam.ut.triangle.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleTest {

    private boolean isTriangle;



    //----------------------TEST TRIANGLE CHECKER GROUP

    //-----------POSITIVE TESTS
    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_checker_positive_group"})
    public void tst_all_positive_sides_handling(Triangle allSidesPositiveValueTriangle) {
        isTriangle = allSidesPositiveValueTriangle.checkTriangle();
        Assert.assertTrue(isTriangle);
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_checker_positive_group"})
    public void tst_a_plus_b_side_greater_than_c_side_handling(Triangle aPlusBSideGreaterThanCSideTriangle) {
        isTriangle = aPlusBSideGreaterThanCSideTriangle.checkTriangle();
        Assert.assertTrue(isTriangle);
    }


    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_checker_positive_group"})
    public void tst_a_plus_c_side_greater_than_b_side_handling(Triangle aPlusCSideGreaterThanBSideTriangle) {
        isTriangle = aPlusCSideGreaterThanBSideTriangle.checkTriangle();
        Assert.assertTrue(isTriangle);
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_checker_positive_group"})
    public void tst_b_plus_c_side_greater_than_a_side_handling(Triangle bPlusCSideGreaterThanASideTriangle) {
        isTriangle = bPlusCSideGreaterThanASideTriangle.checkTriangle();
        Assert.assertTrue(isTriangle);
    }
    //+++++++++++POSITIVE TESTS

    //-----------NEGATIVE TESTS
    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_checker_negative_group"}, expectedExceptions = Exception.class)
    public void tst_negative_a_side_handling(Triangle aSideNegativeTriangle) {
        isTriangle = aSideNegativeTriangle.checkTriangle();
        Assert.assertFalse(isTriangle);
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_checker_negative_group"}, expectedExceptions = Exception.class)
    public void tst_negative_b_side_handling(Triangle bSideNegativeTriangle) {
        isTriangle = bSideNegativeTriangle.checkTriangle();
        Assert.assertFalse(isTriangle);
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_checker_negative_group"}, expectedExceptions = Exception.class)
    public void tst_negative_c_side_handling(Triangle cSideNegativeTriangle) {
        isTriangle = cSideNegativeTriangle.checkTriangle();
        Assert.assertFalse(isTriangle);
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_checker_negative_group"}, expectedExceptions = Exception.class)
    public void tst_all_negative_sides_handling(Triangle allSidesNegativeValueTriangle) {
        isTriangle = allSidesNegativeValueTriangle.checkTriangle();
        Assert.assertFalse(isTriangle);
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_checker_negative_group"}, expectedExceptions = Exception.class)
    public void tst_a_plus_b_side_less_than_c_side_handling(Triangle aPlusBSideLessThanCSideTriangle) {
        isTriangle = aPlusBSideLessThanCSideTriangle.checkTriangle();
        Assert.assertFalse(isTriangle);
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_checker_negative_group"}, expectedExceptions = Exception.class)
    public void tst_a_plus_c_side_less_than_b_side_handling(Triangle aPlusCSideLessThanBSideTriangle) {
        isTriangle = aPlusCSideLessThanBSideTriangle.checkTriangle();
        Assert.assertFalse(isTriangle);
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_checker_negative_group"}, expectedExceptions = Exception.class)
    public void tst_b_plus_c_side_less_than_a_side_handling(Triangle bPlusCSideLessThanASideTriangle) {
        isTriangle = bPlusCSideLessThanASideTriangle.checkTriangle();
        Assert.assertFalse(isTriangle);
    }
    //+++++++++++NEGATIVE TESTS

    //++++++++++++++++++++++TEST TRIANGLE CHECKER GROUP

    //----------------------TEST TRIANGLE DETECTOR GROUP

    //-----------POSITIVE TESTS
    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_detector_positive_group"})
    public void tst_positive_equilateral_triangle(Triangle equilateralTriangle, int expectedEquilateral) {
        Assert.assertEquals(equilateralTriangle.detectTriangle(), expectedEquilateral);
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_detector_positive_group"})
    public void tst_positive_isosceles_triangle(Triangle isoscelesTriangle, int expectedIsosceles) {
        Assert.assertEquals(isoscelesTriangle.detectTriangle(), expectedIsosceles);
    }
    
    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_detector_positive_group"})
    public void tst_positive_ordinary_triangle(Triangle ordinaryTriangle, int expectedOrdinary) {
        Assert.assertEquals(ordinaryTriangle.detectTriangle(), expectedOrdinary);
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_detector_positive_group"})
    public void tst_positive_rectangular_triangle(Triangle rectangularTriangle, int expectedRectangular) {
        Assert.assertEquals(rectangularTriangle.detectTriangle(), expectedRectangular);
    }
    //+++++++++++POSITIVE TESTS

    //-----------NEGATIVE TESTS
    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_detector_negative_group"}, expectedExceptions = Exception.class)
    public void tst_negative_sides_triangle(Triangle equilateralTriangle) {
        equilateralTriangle.detectTriangle();
    }
    //+++++++++++NEGATIVE TESTS

    //++++++++++++++++++++++TEST TRIANGLE DETECTOR GROUP


    //----------------------TEST TRIANGLE BASICS GROUP

    //-----------POSITIVE TESTS
    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_basics_positive_group"})
    public void tst_constructor(Triangle triangle, double expected, String actualMessage) {
        double actual = triangle.getSquare();
        Assert.assertEquals(actual, expected);
        Assert.assertEquals(triangle.getMessage(), actualMessage);
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_basics_positive_group"})
    public void tst_square_calculation_with_positive_triangle_sides(double actual, double expected) {
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_basics_positive_group"})
    public void tst_get_message(String actualMessage, String expectedMessage) {
        System.out.println(expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    //+++++++++++POSITIVE TESTS

    //-----------NEGATIVE TESTS
    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class, groups = {"tst_triangle_basics_negative_group"}, expectedExceptions = Exception.class)
    public void tst_square_calculation_with_negative_triangle_sides_handling(Triangle triangle) {
        triangle.getSquare();
    }
    //+++++++++++NEGATIVE TESTS

    //++++++++++++++++++++++TEST TRIANGLE BASICS GROUP
}
