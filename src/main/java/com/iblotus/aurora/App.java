package com.iblotus.aurora;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
//        System.out.println( "Hello World!" );

        String s;
        if(args.length > 0){
            s = args[0].replaceAll("\'", "");
        }else{
            s = "1+2";
        }
        CharStream input = new ANTLRInputStream(s);

        com.iblotus.aurora.PolyLexer lexer = new com.iblotus.aurora.PolyLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        com.iblotus.aurora.PolyParser parser = new com.iblotus.aurora.PolyParser(tokens);

        ParseTree tree = parser.expr();

        System.out.println(tree.toStringTree(parser));

        EvalVisitor visitor = new EvalVisitor();

        Integer result = visitor.visit(tree);

        System.out.println(result);
//
//        Integer result =  visitor.visitExpr(parser.expr());
//
//        System.out.println(result);
    }
}
