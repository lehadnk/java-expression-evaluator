import org.example.AstBuilder;
import org.example.Token;
import org.example.TokenType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AstBuilderTest {
    @Test
    public void testBuildAst()
    {
        var tokens = List.of(
                new Token(TokenType.NUMBER, 2d),
                new Token(TokenType.OPERATOR, "/"),
                new Token(TokenType.LPAREN),
                new Token(TokenType.NUMBER, 2d),
                new Token(TokenType.OPERATOR, "+"),
                new Token(TokenType.NUMBER, 3d),
                new Token(TokenType.RPAREN),
                new Token(TokenType.OPERATOR, "*"),
                new Token(TokenType.NUMBER, 4.33d),
                new Token(TokenType.OPERATOR, "-"),
                new Token(TokenType.NUMBER, -6d)
        );

        var astBuilder = new AstBuilder();
        var ast = astBuilder.build(tokens);

        assertEquals("-", ast.operation);
        assertEquals(-6d, ast.right.value);
        assertEquals("*", ast.left.operation);
        assertEquals(4.33, ast.left.right.value);
        assertEquals("/", ast.left.left.operation);
        assertEquals(2d, ast.left.left.left.value);
        assertEquals("+", ast.left.left.right.operation);
        assertEquals(2, ast.left.left.right.left.value);
        assertEquals(3, ast.left.left.right.right.value);
    }

    @Test
    public void testBuildAst2()
    {
        var tokens = List.of(
            new Token(TokenType.NUMBER, 2d),
            new Token(TokenType.OPERATOR, "/"),
            new Token(TokenType.NUMBER, 2d),
            new Token(TokenType.OPERATOR, "+"),
            new Token(TokenType.NUMBER, 3d),
            new Token(TokenType.OPERATOR, "*"),
            new Token(TokenType.NUMBER, 4.75d),
            new Token(TokenType.OPERATOR, "-"),
            new Token(TokenType.NUMBER, -6d)
        );

        var astBuilder = new AstBuilder();
        var ast = astBuilder.build(tokens);

        assertEquals("-", ast.operation);
        assertEquals(-6d, ast.right.value);
        assertEquals("+", ast.left.operation);
        assertEquals("/", ast.left.left.operation);
        assertEquals(2d, ast.left.left.left.value);
        assertEquals(2d, ast.left.left.right.value);
        assertEquals("*", ast.left.right.operation);
        assertEquals(3d, ast.left.right.left.value);
        assertEquals(4.75d, ast.left.right.right.value);
    }
}
