package org.example;

public class MathEvaluator {
    public double calculate(String expression) {
        var lexer = new Lexer();
        var tokens = lexer.tokenize(expression);
        var astBuilder = new AstBuilder();
        var ast = astBuilder.build(tokens, expression);
        var expressionEvaluator = new ExpressionEvaluator();
        return expressionEvaluator.calculate(ast);
    }
}
