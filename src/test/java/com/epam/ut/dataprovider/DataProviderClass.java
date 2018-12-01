package com.epam.ut.dataprovider;

import com.epam.ut.triangle.Triangle;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderClass {

    @DataProvider
    public Object[][] dataProvider(Method method)
    {
        switch (method.getName()) {
            //----------------TEST DATA FOR TRIANGLE DETECTOR TEST GROUP | POSITIVE TESTS
            case "tst_positive_equilateral_triangle" :
                return new Object[][] {{ new Triangle(2,2,2), 1 }};

            case "tst_positive_isosceles_triangle" :
                return new Object[][] {{ new Triangle(10, 100, 100), 2 }};

            case "tst_positive_ordinary_triangle" :
                return new Object[][] {{ new Triangle(10, 6, 5), 4 }};

            case "tst_positive_rectangular_triangle" :
                return new Object[][] {{ new Triangle(3, 4, 5), 8 }};
            //++++++++++++++++TEST DATA FOR TRIANGLE DETECTOR TEST GROUP | POSITIVE TESTS

            //----------------TEST DATA FOR TRIANGLE DETECTOR TEST GROUP | NEGATIVE TESTS
            case "tst_negative_sides_triangle" :
                return new Object[][] {
                        {new Triangle(-2.5,-2.5,-2.5)},
                        {new Triangle(2,-2,-2)},
                        {new Triangle(-2,2,-2)},
                        {new Triangle(-2,-2,2)},

                        {new Triangle(-10, -100, -100)},
                        {new Triangle(10, -100.9, -100.9)},
                        {new Triangle(-10, 100, -100)},
                        {new Triangle(-10, -100, 100)},

                        {new Triangle(-10, -6, -5)},
                        {new Triangle(10, -6, -5)},
                        {new Triangle(-10, 6, -5)},
                        {new Triangle(-10, -6, 5)},

                        {new Triangle(-3, -4, -5)},
                        {new Triangle(3, -4, -5)},
                        {new Triangle(-3, 4, -5)},
                        {new Triangle(-3, -4, 5)}};
            //++++++++++++++++TEST DATA FOR TRIANGLE DETECTOR TEST GROUP | NEGATIVE TESTS

            //----------------TEST DATA FOR TRIANGLE CHECKER TEST GROUP | POSITIVE TESTS
            case "tst_all_positive_sides_handling" :
                return new Object[][] { {new Triangle(3, 4, 5)} };

            case "tst_a_plus_b_side_greater_than_c_side_handling" :
                return new Object[][] { {new Triangle(4, 4, 6)} };

            case "tst_a_plus_c_side_greater_than_b_side_handling" :
                return new Object[][] { {new Triangle(4, 6, 4)} };

            case "tst_b_plus_c_side_greater_than_a_side_handling" :
                return new Object[][] { {new Triangle(6, 4, 4)} };
            //++++++++++++++++TEST DATA FOR TRIANGLE CHECKER TEST GROUP | POSITIVE TESTS

            //----------------TEST DATA FOR TRIANGLE CHECKER TEST GROUP | NEGATIVE TESTS
            case "tst_negative_a_side_handling" :
                return new Object[][] { {new Triangle(-3, 4, 5)} };

            case "tst_negative_b_side_handling" :
                return new Object[][] { {new Triangle(3, -4, 5)} };

            case "tst_negative_c_side_handling" :
                return new Object[][] { {new Triangle(3, 4, -5)} };

            case "tst_all_negative_sides_handling" :
                return new Object[][] { {new Triangle(-3, -4, -5)} };

            case "tst_a_plus_b_side_less_than_c_side_handling" :
                return new Object[][] { {new Triangle(4, 4, 10)} };

            case "tst_a_plus_c_side_less_than_b_side_handling" :
                return new Object[][] { {new Triangle(4, 10, 4)} };

            case "tst_b_plus_c_side_less_than_a_side_handling" :
                return new Object[][] { {new Triangle(10, 4, 4)} };
            //++++++++++++++++TEST DATA FOR TRIANGLE CHECKER TEST GROUP | NEGATIVE TESTS


            //----------------TEST TRIANGLE BASICS GROUP | POSITIVE TESTS
            case "tst_constructor" :
                return new Object[][] {{ new Triangle(3, 4, 5), 6.0, ""}};

            case "tst_square_calculation_with_positive_triangle_sides" :
                Triangle triangle = new Triangle(3, 4, 5);
                return new Object[][] {{ triangle.getSquare(), 6.0 }};

            case "tst_get_message" :
                //Setting up triangles for testing getMessage() function
                Triangle aPlusBSideLessThanCSideTriangle = new Triangle(4, 4, 10);
                Triangle aPlusCSideLessThanBSideTriangle = new Triangle(4, 10, 4);
                Triangle bPlusCSideLessThanASideTriangle = new Triangle(10, 4, 4);

                Triangle aSideLessOrEqualsZeroTriangle = new Triangle(-1, 2, 2);
                Triangle bSideLessOrEqualsZeroTriangle = new Triangle(1, -2, 2);
                Triangle cSideLessOrEqualsZeroTriangle = new Triangle(1, 2, -2);

                //After checking all triangles message will set upped
                aPlusBSideLessThanCSideTriangle.checkTriangle();
                aPlusCSideLessThanBSideTriangle.checkTriangle();
                bPlusCSideLessThanASideTriangle.checkTriangle();

                aSideLessOrEqualsZeroTriangle.checkTriangle();
                bSideLessOrEqualsZeroTriangle.checkTriangle();
                cSideLessOrEqualsZeroTriangle.checkTriangle();

                return new Object[][] {
                        { aPlusBSideLessThanCSideTriangle.getMessage(), "a+b<=c" },
                        { aPlusCSideLessThanBSideTriangle.getMessage(), "a+c<=b" },
                        { bPlusCSideLessThanASideTriangle.getMessage(), "b+c<=a" },

                        { aSideLessOrEqualsZeroTriangle.getMessage(), "a<=0"},
                        { bSideLessOrEqualsZeroTriangle.getMessage(), "b<=0"},
                        { cSideLessOrEqualsZeroTriangle.getMessage(), "c<=0"}
                };
            //++++++++++++++++TEST TRIANGLE BASICS GROUP | POSITIVE TESTS

            //----------------TEST TRIANGLE BASICS GROUP | NEGATIVE TESTS
            case "tst_square_calculation_with_negative_triangle_sides_handling" :
                return new Object[][] {{ new Triangle(-3, -4, -5) }};
            //++++++++++++++++TEST TRIANGLE BASICS GROUP | NEGATIVE TESTS

        }
        return new Object[][]{};
    }
}
