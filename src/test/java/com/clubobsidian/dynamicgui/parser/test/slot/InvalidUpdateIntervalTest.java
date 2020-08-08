package com.clubobsidian.dynamicgui.parser.test.slot;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.slot.SlotToken;
import com.clubobsidian.wrappy.Configuration;
import com.clubobsidian.wrappy.ConfigurationSection;

public class InvalidUpdateIntervalTest {

	@Test
	public void lessThanZeroupdateIntervalTest()
	{
		File slotFolder = new File("test", "slot");
		File file = new File(slotFolder, "invalid-update-interval.yml");
		Configuration config = Configuration.load(file);
		ConfigurationSection section = config.getConfigurationSection("0");
		SlotToken token = new SlotToken(0, section);
		int interval = token.getUpdateInterval();
		assertTrue("Update interval is not 0", interval == 0);
	}
	
	@Test
	public void invalidIntervalTest()
	{
		File slotFolder = new File("test", "slot");
		File file = new File(slotFolder, "invalid-update-interval.yml");
		Configuration config = Configuration.load(file);
		ConfigurationSection section = config.getConfigurationSection("1");
		SlotToken token = new SlotToken(1, section);
		int interval = token.getUpdateInterval();
		assertTrue("Update interval was not invalid", interval == 0);
	}
}