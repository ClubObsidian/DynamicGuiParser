package com.clubobsidian.dynamicgui.parser.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.function.FunctionType;

public class FunctionTypeTest {

	@Test
	public void allIsClickTest()
	{
		assertTrue("All click is not a click", FunctionType.ALL.isClick());
	}
	
	@Test
	public void leftIsClickTest()
	{
		assertTrue("Left click is not a click", FunctionType.LEFT.isClick());
	}
	
	@Test
	public void rightIsClickTest()
	{
		assertTrue("Right click is not a click", FunctionType.RIGHT.isClick());
	}
	
	@Test
	public void middleIsClickTest()
	{
		assertTrue("Middle click is not a click", FunctionType.MIDDLE.isClick());
	}
	
	@Test
	public void loadIsNotClickTest()
	{
		assertFalse("Load is a click", FunctionType.LOAD.isClick());
	}
	
	@Test
	public void failIsNotClickTest()
	{
		assertFalse("Fail is a click", FunctionType.FAIL.isClick());
	}
}