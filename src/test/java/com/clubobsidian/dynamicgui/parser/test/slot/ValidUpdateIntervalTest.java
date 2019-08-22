package com.clubobsidian.dynamicgui.parser.test.slot;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.slot.SlotToken;
import com.clubobsidian.wrappy.Configuration;
import com.clubobsidian.wrappy.ConfigurationSection;

public class ValidUpdateIntervalTest {

	@Test
	public void updateIntervalTest()
	{
		File slotFolder = new File("test", "slot");
		File file = new File(slotFolder, "valid-update-interval.yml");
		Configuration config = Configuration.load(file);
		ConfigurationSection section = config.getConfigurationSection("0");
		SlotToken token = new SlotToken(0, section);
		int interval = token.getUpdateInterval();
		assertTrue("Update interval is not 5", interval == 5);
	}
}