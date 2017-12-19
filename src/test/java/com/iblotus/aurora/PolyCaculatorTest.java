package com.iblotus.aurora;

import junit.framework.Assert;
import junit.framework.TestCase;

public class PolyCaculatorTest extends TestCase {

    public void testEval(){

        String[] exps = {
                "1+2+3",
                "1+5*3-4/2"
        };

        Integer[] expecteds = {
                6,
                14
        };

        PolyCaculator caculator = new PolyCaculator();

        for(int i = 0; i < exps.length; i++){
            Assert.assertEquals(expecteds[i], caculator.eval(exps[i]));
        }
    }
}
