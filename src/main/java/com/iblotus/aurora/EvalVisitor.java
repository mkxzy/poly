package com.iblotus.aurora;

import org.antlr.v4.runtime.tree.*;

public class EvalVisitor implements ParseTreeVisitor<Integer> {

    @Override
    public Integer visit(ParseTree parseTree) {
        if(parseTree instanceof TerminalNode){
            return this.visitTerminal((TerminalNode)parseTree);
        }
        if(parseTree instanceof RuleNode){
            return this.visitChildren((RuleNode)parseTree);
        }
        throw new UnsupportedOperationException(parseTree.getClass().getName() + "not handled");
    }

    @Override
    public Integer visitChildren(RuleNode ruleNode) {
        if(ruleNode.getChildCount() == 1){
            return this.getNumber(ruleNode.getChild(0));
        }
        ParseTree leftChild = ruleNode.getChild(0);
        Integer firstNumber = this.getNumber(leftChild);

        ParseTree rightChild = ruleNode.getChild(2);
        Integer rightNumber = this.getNumber(rightChild);

        TerminalNode midChild = (TerminalNode)ruleNode.getChild(1);
        String op =  midChild.getSymbol().getText();
        return this.calculate(op, firstNumber, rightNumber);
    }

    private Integer getNumber(ParseTree parseTree){
        if(parseTree instanceof TerminalNode){
            TerminalNode rightNode = (TerminalNode)parseTree;
            return this.visitTerminal(rightNode);
        }
        if (parseTree instanceof RuleNode){
            RuleNode rightNode = (RuleNode)parseTree;
            return this.visitChildren(rightNode);
        }
        throw new RuntimeException(parseTree.getClass().getName());
    }

    private Integer calculate(String op, Integer left, Integer right){
        switch (op){
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                return null;
        }
    }

    @Override
    public Integer visitTerminal(TerminalNode terminalNode) {
        return Integer.valueOf(terminalNode.getText());
    }

    @Override
    public Integer visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
