package org.example;

public class Token {
    public TokenType tokenType;
    public Double number;
    public String operator;

    public Token(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public Token(TokenType tokenType, Double number)
    {
        this.tokenType = tokenType;
        this.number = number;
    }

    public Token(TokenType tokenType, String operator)
    {
        this.tokenType = tokenType;
        this.operator = operator;
    }
}
