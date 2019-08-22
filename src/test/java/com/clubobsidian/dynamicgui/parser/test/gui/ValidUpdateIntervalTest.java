package com.clubobsidian.dynamicgui.parser.test.gui;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.gui.GuiToken;
import com.clubobsidian.wrappy.Configuration;

public class ValidUpdateIntervalTest {

	@Test
	public void updateIntervalTest()
	{
		File slotFolder = new File("test", "gui");
		File file = new File(slotFolder, "valid-update-interval.yml");
		Configuration config = Configuration.load(file);
		GuiToken token = new GuiToken(config);
		int interval = token.getUpdateInterval();
		assertTrue("Update interval is not 5", interval == 5);
	}
}