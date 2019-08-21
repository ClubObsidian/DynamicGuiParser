package com.clubobsidian.dynamicgui.parser.test.gui;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.gui.GuiToken;
import com.clubobsidian.wrappy.Configuration;

public class ValidTypeTest {

	@Test
	public void testType()
	{
		File slotFolder = new File("test", "gui");
		File file = new File(slotFolder, "valid-type.yml");
		Configuration config = Configuration.load(file);
		GuiToken token = new GuiToken(config);
		String type = token.getType();
		assertTrue("Gui type is not 'DISPENSER'", type.equals("DISPENSER"));
	}
}