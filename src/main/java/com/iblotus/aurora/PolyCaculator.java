package com.iblotus.aurora;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class PolyCaculator {

    public Integer eval(String expression){

        CharStream input = new ANTLRInputStream(expression);com.iblotus.aurora.PolyLexer lexer = new com.iblotus.aurora.PolyLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        com.iblotus.aurora.PolyParser parser = new com.iblotus.aurora.PolyParser(tokens);
        ParseTree tree = parser.expr();
        System.out.println(tree.toStringTree(parser));
        EvalVisitor visitor = new EvalVisitor();
        Integer result = visitor.visit(tree);
        return result;
    }
}
