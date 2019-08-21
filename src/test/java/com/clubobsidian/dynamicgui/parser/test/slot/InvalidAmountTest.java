package com.clubobsidian.dynamicgui.parser.test.slot;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.slot.SlotToken;
import com.clubobsidian.wrappy.Configuration;
import com.clubobsidian.wrappy.ConfigurationSection;

public class InvalidAmountTest {

	@Test
	public void amountTest()
	{
		File slotFolder = new File("test", "gui");
		File file = new File(slotFolder, "type.yml");
		Configuration config = Configuration.load(file);
		ConfigurationSection section = config.getConfigurationSection("0");
		SlotToken token = new SlotToken(0, section);
		int amount = token.getAmount();
		assertTrue("Amount is not 1", amount == 1);
	}
}