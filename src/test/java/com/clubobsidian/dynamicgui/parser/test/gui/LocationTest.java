package com.clubobsidian.dynamicgui.parser.test.gui;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.gui.GuiToken;
import com.clubobsidian.wrappy.Configuration;

public class LocationTest {

	@Test
	public void testAlias()
	{
		File slotFolder = new File("test", "gui");
		File file = new File(slotFolder, "location.yml");
		Configuration config = Configuration.load(file);
		GuiToken token = new GuiToken(config);
		String location = token.getLocations().get(0);
		assertTrue("Location is not '0,0,0,world'", location.equals("0,0,0,world"));
	}
	
}