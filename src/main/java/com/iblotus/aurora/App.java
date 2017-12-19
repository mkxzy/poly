package com.iblotus.aurora;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        String s;
        if(args.length > 0){
            s = args[0].replaceAll("\'", "");
        }else{
            s = "1+2";
        }

        PolyCaculator caculator = new PolyCaculator();

        Integer result = caculator.eval(s);

        System.out.println(result);
    }
}
