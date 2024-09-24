package org.example;

public class AstNode {
    public String operation;
    public AstNode left;
    public AstNode right;
    public Double value;

    public AstNode()
    {
    }

    public AstNode(Double value) {
        this.value = value;
    }

    public AstNode(String operation, AstNode left, Double right)
    {
        this.operation = operation;
        this.left = left;
        this.right = new AstNode(right);
    }

    public AstNode(String operation, AstNode left, AstNode right)
    {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    public AstNode(String operation, Double left, Double right)
    {
        this.operation = operation;
        this.left = new AstNode(left);
        this.right = new AstNode(right);
    }

    public AstNode(String operation, Double left, AstNode right)
    {
        this.operation = operation;
        this.left = new AstNode(left);
        this.right = right;
    }
}
