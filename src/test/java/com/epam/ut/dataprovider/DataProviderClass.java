package com.epam.ut.dataprovider;

import com.epam.ut.triangle.Triangle;

import java.lang.reflect.Method;

public class DataProviderClass {
    @org.testng.annotations.DataProvider
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
}
