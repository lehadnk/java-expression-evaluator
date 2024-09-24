import org.example.MathEvaluator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTests {
    @Test
    public void testAddition() {
        assertEquals(2d, new MathEvaluator().calculate("1+1"), 0.01);
    }

    @Test public void testSubtraction() {
        assertEquals(0d, new MathEvaluator().calculate("1 - 1"), 0.01);
    }

    @Test public void testMultiplication() {
        assertEquals(1d, new MathEvaluator().calculate("1* 1"), 0.01);
    }

    @Test public void testDivision() {
        assertEquals(1d, new MathEvaluator().calculate("1 /1"), 0.01);
    }

    @Test public void testNegative() {
        assertEquals(-123d, new MathEvaluator().calculate("-123"), 0.01);
    }

    @Test public void testLiteral() {
        assertEquals(123d, new MathEvaluator().calculate("123"), 0.01);
    }

    @Test public void testExpression() {
        assertEquals(21.25, new MathEvaluator().calculate("2 /2+3 * 4.75- -6"), 0.01);
    }

    @Test public void testSimple() {
        assertEquals(1476d, new MathEvaluator().calculate("12* 123"), 0.01);
    }

    @Test public void testComplex() {
        assertEquals(7.732, new MathEvaluator().calculate("2 / (2 + 3) * 4.33 - -6"), 0.01);
    }

    @Test public void testFailedCata1() {
        assertEquals(3, new MathEvaluator().calculate("(1 - 2) + -(-(-(-4)))"), 0.01);
    }

    @Test public void testFailedCata2() {
        assertEquals(492, new MathEvaluator().calculate("12* 123/-(-5 + 2)"), 0.01);
    }

    @Test public void testFailedCata3() {
        assertEquals(-3, new MathEvaluator().calculate("1 - -(-(-(-4)))"), 0.01);
    }

    @Test public void testFailedCata4() {
        assertEquals(-12042.76, new MathEvaluator().calculate("123.45*(678.90 / (-2.5+ 11.5)-(80 -19) *33.25) / 20 + 11"), 0.01);
    }
}
