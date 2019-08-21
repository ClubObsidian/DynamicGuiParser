package com.clubobsidian.dynamicgui.parser.test.slot;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.slot.SlotToken;
import com.clubobsidian.wrappy.Configuration;
import com.clubobsidian.wrappy.ConfigurationSection;

public class InvalidSlotDataMacroTest {

	
	@Test
	public void loadSlotToken()
	{
		File slotFolder = new File("test", "slot");
		File file = new File(slotFolder, "invalid-slot-data-macro.yml");
		Configuration config = Configuration.load(file);
		ConfigurationSection section = config.getConfigurationSection("0");
		SlotToken token = new SlotToken(0, section);
		byte data = token.getData();
		assertTrue("Slot data was not parsed correctly, data is not 0", data == 0);
	}
}