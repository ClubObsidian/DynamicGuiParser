package com.clubobsidian.dynamicgui.parser.test.slot;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.slot.SlotToken;
import com.clubobsidian.wrappy.Configuration;
import com.clubobsidian.wrappy.ConfigurationSection;

public class LoreTest {

	@Test
	public void loreTest()
	{
		File slotFolder = new File("test", "slot");
		File file = new File(slotFolder, "lore.yml");
		Configuration config = Configuration.load(file);
		ConfigurationSection section = config.getConfigurationSection("0");
		SlotToken token = new SlotToken(0, section);
		List<String> lore = token.getLore();
		assertTrue("Slot lore size is not 2", lore.size() == 2);
	}
}