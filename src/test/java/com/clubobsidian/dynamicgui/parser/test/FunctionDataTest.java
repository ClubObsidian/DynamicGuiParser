package com.clubobsidian.dynamicgui.parser.test;

import com.clubobsidian.dynamicgui.parser.function.FunctionData;
import com.clubobsidian.dynamicgui.parser.function.FunctionModifier;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FunctionDataTest {

    private static final String NAME = "name";
    private static final String DATA = "data";
    private static final FunctionModifier MODIFIER = FunctionModifier.NONE;

    private FunctionData data;


    @Before
    public void setup()
    {
        this.data = new FunctionData(NAME, DATA, MODIFIER);
    }

    @Test
    public void testName()
    {
        assertEquals(this.data.getName(), NAME);
    }

    @Test
    public void testData()
    {
        assertEquals(this.data.getData(), DATA);
    }

    @Test
    public void testModifier()
    {
        assertEquals(this.data.getModifier(), MODIFIER);
    }
}