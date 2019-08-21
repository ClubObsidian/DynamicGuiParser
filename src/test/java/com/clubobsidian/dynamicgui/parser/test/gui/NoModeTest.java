package com.clubobsidian.dynamicgui.parser.test.gui;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.gui.GuiMode;
import com.clubobsidian.dynamicgui.parser.gui.GuiToken;
import com.clubobsidian.wrappy.Configuration;

public class NoModeTest {

	@Test
	public void testAlias()
	{
		File slotFolder = new File("test", "gui");
		File file = new File(slotFolder, "no-mode.yml");
		Configuration config = Configuration.load(file);
		GuiToken token = new GuiToken(config);
		GuiMode alias = token.getMode();
		assertTrue("Gui mode was null but is set by default", alias == GuiMode.SET);
	}
	
}