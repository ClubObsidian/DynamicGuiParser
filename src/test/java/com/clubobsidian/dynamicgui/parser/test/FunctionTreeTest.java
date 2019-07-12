package com.clubobsidian.dynamicgui.parser.test;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.function.tree.FunctionTree;
import com.clubobsidian.wrappy.Configuration;
import com.clubobsidian.wrappy.ConfigurationSection;

public class FunctionTreeTest {

	@Test
	public void testRootNodeSize()
	{
		File testFile = new File("test.yml");
		Configuration config = Configuration.load(testFile);
		ConfigurationSection slotsSection = config.getConfigurationSection("slots");
		ConfigurationSection firstSlotSection = slotsSection.getConfigurationSection("0");
		ConfigurationSection functionSection = firstSlotSection.getConfigurationSection("functions");
		FunctionTree tree = new FunctionTree(functionSection);
		int rootNodeSize = tree.getRootNodes().size();
		System.out.println(rootNodeSize);
		assertTrue("Root node size is not three", rootNodeSize == 3);
	}
}