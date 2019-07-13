package com.clubobsidian.dynamicgui.parser.test;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.function.tree.FunctionTree;
import com.clubobsidian.dynamicgui.parser.slot.SlotToken;
import com.clubobsidian.wrappy.Configuration;
import com.clubobsidian.wrappy.ConfigurationSection;

public class SlotTokenTest {

	private static SlotToken token;
	
	@BeforeClass
	public static void loadSlotToken()
	{
		File file = new File("test.yml");
		Configuration config = Configuration.load(file);
		ConfigurationSection section = config.getConfigurationSection("1");
		token = new SlotToken(section);
	}
	
	@Test
	public void testSlotName()
	{
		String name = token.getName();
		assertTrue("Name was not test for slot token", name.equals("test"));
	}
	
	@Test
	public void testSlotIcon()
	{
		String icon = token.getIcon();
		assertTrue("Icon was not dirt", icon.equals("DIRT"));
	}
	
	@Test
	public void testSlotNbt()
	{
		String nbt = token.getNbt();
		assertTrue("Nbt was not '{SomeKey:\"some value\"}'", nbt.equals("{SomeKey:\"some value\"}"));
	}
	
	@Test
	public void testSlotClose()
	{
		boolean close = token.isClosed();
		assertTrue("Close not was true", close);
	}
	
	@Test
	public void testSlotData()
	{
		byte data = token.getData();
		assertTrue("Data was not 1", data == 1);
	}
	
	@Test
	public void testSlotFunctionTree()
	{
		FunctionTree tree = token.getFunctionTree();
		int nodeSize = tree.getRootNodes().size();
		assertTrue("Node were not parsed for the function tree", nodeSize == 1);
	}
}