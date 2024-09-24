import org.example.Lexer;
import org.example.TokenType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LexerTest {
    @Test
    public void testNumber()
    {
        var lexer = new Lexer();
        var tokens = lexer.tokenize("123");
        assertEquals(TokenType.NUMBER, tokens.get(0).tokenType);
        assertEquals(123d, tokens.get(0).number);
    }

    @Test
    public void testOnePlusOne()
    {
        var lexer = new Lexer();
        var tokens = lexer.tokenize("1+1");
        assertEquals(TokenType.NUMBER, tokens.get(0).tokenType);
        assertEquals(1d, tokens.get(0).number);

        assertEquals(TokenType.OPERATOR, tokens.get(1).tokenType);
        assertEquals("+", tokens.get(1).operator);

        assertEquals(TokenType.NUMBER, tokens.get(2).tokenType);
        assertEquals(1d, tokens.get(2).number);
    }

    @Test
    public void testAddExpression()
    {
        var lexer = new Lexer();
        var tokens = lexer.tokenize("123+ 251.3");
        assertEquals(TokenType.NUMBER, tokens.get(0).tokenType);
        assertEquals(123d, tokens.get(0).number);

        assertEquals(TokenType.OPERATOR, tokens.get(1).tokenType);
        assertEquals("+", tokens.get(1).operator);

        assertEquals(TokenType.NUMBER, tokens.get(2).tokenType);
        assertEquals(251.3d, tokens.get(2).number);
    }

    @Test
    public void testComplicatedExpression()
    {
        var lexer = new Lexer();
        var tokens = lexer.tokenize("123 + (251.3 /2 )  - -3");
        assertEquals(TokenType.NUMBER, tokens.get(0).tokenType);
        assertEquals(123d, tokens.get(0).number);

        assertEquals(TokenType.OPERATOR, tokens.get(1).tokenType);
        assertEquals("+", tokens.get(1).operator);

        assertEquals(TokenType.LPAREN, tokens.get(2).tokenType);

        assertEquals(TokenType.NUMBER, tokens.get(3).tokenType);
        assertEquals(251.3d, tokens.get(3).number);

        assertEquals(TokenType.OPERATOR, tokens.get(4).tokenType);
        assertEquals("/", tokens.get(4).operator);

        assertEquals(TokenType.NUMBER, tokens.get(5).tokenType);
        assertEquals(2d, tokens.get(5).number);

        assertEquals(TokenType.RPAREN, tokens.get(6).tokenType);

        assertEquals(TokenType.OPERATOR, tokens.get(7).tokenType);
        assertEquals("-", tokens.get(7).operator);

        assertEquals(TokenType.NUMBER, tokens.get(8).tokenType);
        assertEquals(-3d, tokens.get(8).number);
    }
}
