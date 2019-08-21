package com.clubobsidian.dynamicgui.parser.test.slot;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.slot.SlotToken;
import com.clubobsidian.wrappy.Configuration;
import com.clubobsidian.wrappy.ConfigurationSection;

public class EnchantTest {

	@Test
	public void enchantTest()
	{
		File slotFolder = new File("test", "slot");
		File file = new File(slotFolder, "enchants.yml");
		Configuration config = Configuration.load(file);
		ConfigurationSection section = config.getConfigurationSection("0");
		SlotToken token = new SlotToken(0, section);
		List<String> enchants = token.getEnchants();
		assertTrue("Slot enchants size is not 3", enchants.size() == 3);
	}
}