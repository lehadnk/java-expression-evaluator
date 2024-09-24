package org.example;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private int index = 0;
    private List<Token> output = new ArrayList<>();
    private String input;

    public List<Token> tokenize(String input)
    {
        this.input = input;

        while(this.index < input.length()) {
            this.consume();
            this.index++;
        }

        return output;
    }

    private void consume()
    {
        var currentChar = input.charAt(this.index);
        switch (currentChar) {
            case '(':
                this.output.add(new Token(TokenType.LPAREN));
                break;
            case ')':
                this.output.add(new Token(TokenType.RPAREN));
                break;
            case '+':
            case '/':
            case '*':
                this.output.add(new Token(TokenType.OPERATOR, String.valueOf(currentChar)));
                break;
            case '-':
                this.consumeMinus();
                break;
        }

        if (Character.isDigit(currentChar)) {
            this.output.add(new Token(TokenType.NUMBER, Double.valueOf(this.consumeNumber())));
        }
    }

    private void consumeMinus() {
        var buffer = "-";
        this.index++;
        var currentChar = input.charAt(this.index);
        if (Character.isDigit(currentChar)) {
            buffer += this.consumeNumber();
            this.output.add(new Token(TokenType.NUMBER, Double.valueOf(buffer)));
        } else {
            this.output.add(new Token(TokenType.OPERATOR, "-"));
        }
    }

    private String consumeNumber() {
        StringBuilder buffer = new StringBuilder();
        var currentChar = input.charAt(this.index);
        while((Character.isDigit(currentChar) || currentChar == '.')) {
            buffer.append(currentChar);

            this.index++;
            if (this.index >= this.input.length()) {
                break;
            }

            currentChar = input.charAt(this.index);
        }
        this.index--; // Navigate back since we've done extra step

        return buffer.toString();
    }
}
