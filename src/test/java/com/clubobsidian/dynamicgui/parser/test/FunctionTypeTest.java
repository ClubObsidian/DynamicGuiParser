package com.clubobsidian.dynamicgui.parser.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.function.FunctionType;

public class FunctionTypeTest {

	@Test
	public void clickIsClickTest()
	{
		assertTrue(FunctionType.CLICK.isClick());
	}
	
	@Test
	public void leftIsClickTest()
	{
		assertTrue(FunctionType.LEFT.isClick());
	}
	
	@Test
	public void rightIsClickTest()
	{
		assertTrue(FunctionType.RIGHT.isClick());
	}
	
	@Test
	public void middleIsClickTest()
	{
		assertTrue(FunctionType.MIDDLE.isClick());
	}
	
	@Test
	public void shiftClickIsClickTest()
	{
		assertTrue(FunctionType.SHIFT_CLICK.isClick());
	}
	
	@Test
	public void shiftLeftIsClickTest()
	{
		assertTrue(FunctionType.SHIFT_LEFT.isClick());
	}
	
	@Test
	public void shiftRightIsClickTest()
	{
		assertTrue(FunctionType.SHIFT_RIGHT.isClick());
	}
	
	@Test
	public void loadIsNotClickTest()
	{
		assertFalse(FunctionType.LOAD.isClick());
	}
	
	@Test
	public void failIsNotClickTest()
	{
		assertFalse(FunctionType.FAIL.isClick());
	}
}