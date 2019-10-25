package com.clubobsidian.dynamicgui.parser.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.clubobsidian.dynamicgui.util.ReplacerUtil;

public class ReplacerUtilTest {

	@Test
	public void testGetPatterns()
	{
		String key = "%test%";
		String value = "not test";
		String replaceIn = "%test%";
		ReplacerUtil.replace(replaceIn, key, value);
		assertTrue(ReplacerUtil.getPatterns().size() >= 1);
		ReplacerUtil.getPatterns().clear();
		assertTrue(ReplacerUtil.getPatterns().size() == 0);
	}
}