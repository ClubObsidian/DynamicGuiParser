package com.clubobsidian.dynamicgui.parser.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.function.tree.FunctionNode;
import com.clubobsidian.dynamicgui.parser.function.tree.FunctionTree;
import com.clubobsidian.dynamicgui.parser.gui.GuiMode;
import com.clubobsidian.dynamicgui.parser.gui.GuiToken;
import com.clubobsidian.dynamicgui.parser.slot.SlotToken;
import com.clubobsidian.wrappy.Configuration;

public class GuiTokenTest {

	private static GuiToken token;
	
	@BeforeClass
	public static void loadToken()
	{
		File file = new File("test.yml");
		Configuration config = Configuration.load(file);
		token = new GuiToken(config);
	}
	
	@Test
	public void testTitle()
	{
		String title = token.getTitle();
		assertTrue("Gui title is not 'test gui title'", title.equals("test gui title"));
	}
	
	@Test
	public void testRows()
	{
		int rows = token.getRows();
		assertTrue("Gui rows is not 1", rows == 1);
	}
	
	@Test
	public void testMode()
	{
		GuiMode mode = token.getMode();
		assertTrue("Gui mode is not 'set'", mode == GuiMode.SET);
	}
	
	@Test
	public void testClose()
	{
		boolean closed = token.isClosed();
		assertTrue("Gui close it not true", closed);
	}
	
	@Test
	public void testNpcs()
	{
		List<Integer> npcs = token.getNpcs();
		assertTrue("Npcs size is not 2", npcs.size() == 2);
		assertTrue("Npc at index 0 is not 5", npcs.get(0) == 5);
		assertTrue("Npc at index 1 is not 88", npcs.get(1) == 77);
	}
	
	@Test
	public void testSlots()
	{
		Map<Integer, SlotToken> slots = token.getSlots();
		assertTrue("Slots size is not 2", slots.size() == 2);
	}
	
	@Test
	public void testGlobalFunctions()
	{
		FunctionTree globalFunctions = token.getGlobalFunctions();
		List<FunctionNode> children = globalFunctions.getRootNodes();
		int childrenSize = children.size();
		assertTrue("Global functions did not load in, size is not 1", childrenSize == 1);
	}
}
