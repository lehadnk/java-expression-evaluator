import org.example.AstNode;
import org.example.ExpressionEvaluator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionEvaluatorTest {
    @Test
    public void testExpression()
    {
        var ast = new AstNode("-", new AstNode("*", new AstNode("/", 2d, new AstNode("+", 2d, 3d)), 4.33d), -6d);
        var calculus = new ExpressionEvaluator();
        var result = calculus.calculate(ast);

        assertEquals(7.732, result);
    }
}
