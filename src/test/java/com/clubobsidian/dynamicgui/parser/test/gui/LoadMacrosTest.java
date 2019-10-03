package com.clubobsidian.dynamicgui.parser.test.gui;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.gui.GuiToken;
import com.clubobsidian.wrappy.Configuration;

public class LoadMacrosTest {

	@Test
	public void testLoadMacros()
	{
		File slotFolder = new File("test", "gui");
		File file = new File(slotFolder, "load-macros.yml");
		Configuration config = Configuration.load(file);
		GuiToken token = new GuiToken(config);
		List<String> loadMacros = token.getLoadMacros();
		assertTrue(loadMacros.size() == 1);
		assertTrue(loadMacros.get(0).equals("test"));
	}
}