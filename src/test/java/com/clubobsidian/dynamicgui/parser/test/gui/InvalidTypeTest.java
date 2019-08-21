package com.clubobsidian.dynamicgui.parser.test.gui;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.gui.GuiToken;
import com.clubobsidian.wrappy.Configuration;

public class InvalidTypeTest {

	@Test
	public void testType()
	{
		File slotFolder = new File("test", "gui");
		File file = new File(slotFolder, "invalid-type.yml");
		Configuration config = Configuration.load(file);
		GuiToken token = new GuiToken(config);
		String type = token.getType();
		assertTrue("Gui type is not 'CHEST'", type.equals("CHEST"));
	}
}