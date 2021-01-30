package com.clubobsidian.dynamicgui.parser.test;

import com.clubobsidian.dynamicgui.parser.function.FunctionModifier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FunctionModifierTest {

    @Test
    public void testHasNotModifier()
    {
        FunctionModifier modifier = FunctionModifier.findModifier("!aaa");
        assertEquals(modifier, FunctionModifier.NOT);
    }


    @Test
    public void testNoModifier()
    {
        FunctionModifier modifier = FunctionModifier.findModifier("aaa");
        assertEquals(modifier, FunctionModifier.NONE);
    }

}
