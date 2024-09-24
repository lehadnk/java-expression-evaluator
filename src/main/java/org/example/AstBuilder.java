package org.example;

import java.util.List;

public class AstBuilder {
    private int index = 0;
    private List<Token> tokens;
    private String expession;

    public AstNode build(List<Token> tokens, String expession) {
        this.tokens = tokens;
        this.expession = expession;
        return this.expression();
    }

    public Token consume()
    {
        var token = this.tokens.get(this.index);
        this.index++;
        return token;
    }

    public Token current()
    {
        if (this.index >= this.tokens.size()) {
            return null;//new Token(TokenType.EOF);
        }

        return this.tokens.get(this.index);
    }

    private AstNode expression() {
        var node = this.term();

        while (this.current() != null && this.current().operator != null && (this.current().operator.equals("+") || this.current().operator.equals("-"))) {
            var token = this.consume();
            node = new AstNode(token.operator, node, this.term());
        }

        return node;
    }

    private AstNode term() {
        var node = this.factor();

        while (this.current() != null && this.current().operator != null && (this.current().operator.equals("*") || this.current().operator.equals("/"))) {
            var token = this.consume();
            node = new AstNode(token.operator, node, this.factor());
        }

        return node;
    }

    private AstNode factor() {
        var token = this.current();

        if (token.tokenType == TokenType.NUMBER) {
            this.consume();
            return new AstNode(token.number);
        }

        if (token.tokenType == TokenType.LPAREN) {
            this.consume();
            var node = this.expression();

            if (this.current().tokenType == TokenType.RPAREN) {
                this.consume();
            } else {
                throw new IllegalArgumentException("Missing closing parenthesis at token " + this.index + ". Expression: " + this.expession);
            }

            return node;
        }

        // Unary + and -
        if (token.operator.equals("+") || token.operator.equals("-")) {
            this.consume();
            return new AstNode(token.operator, 0d, this.factor());
        }

        throw new IllegalArgumentException("Unexpected token " + token.tokenType + ". Expression: " + this.expession);
    }
}
