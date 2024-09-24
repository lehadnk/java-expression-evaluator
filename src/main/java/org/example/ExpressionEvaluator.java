package org.example;

public class ExpressionEvaluator {
    public double calculate(AstNode ast)
    {
        if (ast.value != null) {
            return ast.value;
        }

        return switch (ast.operation) {
            case "+" -> this.calculate(ast.left) + this.calculate(ast.right);
            case "-" -> this.calculate(ast.left) - this.calculate(ast.right);
            case "/" -> this.calculate(ast.left) / this.calculate(ast.right);
            case "*" -> this.calculate(ast.left) * this.calculate(ast.right);
            default -> throw new RuntimeException("Unknown operation: " + ast.operation);
        };
    }
}
