package com.clubobsidian.dynamicgui.parser.test.gui;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.gui.GuiToken;
import com.clubobsidian.wrappy.Configuration;;

public class InvalidUpdateIntervalTest {

	@Test
	public void lessThanZeroupdateIntervalTest()
	{
		File slotFolder = new File("test", "gui");
		File file = new File(slotFolder, "invalid-update-interval.yml");
		Configuration config = Configuration.load(file);
		GuiToken token = new GuiToken(config);
		int interval = token.getUpdateInterval();
		assertTrue("Update interval is not 0", interval == 0);
	}
	
	@Test
	public void greaterThanTwentyupdateIntervalTest()
	{
		File slotFolder = new File("test", "gui");
		File file = new File(slotFolder, "invalid-update-interval2.yml");
		Configuration config = Configuration.load(file);
		GuiToken token = new GuiToken(config);
		int interval = token.getUpdateInterval();
		assertTrue("Update interval is not 0", interval == 0);
	}
}