package com.clubobsidian.dynamicgui.parser.test.slot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.slot.SlotToken;
import com.clubobsidian.wrappy.Configuration;
import com.clubobsidian.wrappy.ConfigurationSection;

public class MoveableTest {

	@Test
	public void testSlotMoveable()
	{
		File slotFolder = new File("test", "slot");
		File metadataFile = new File(slotFolder, "moveable.yml");
		Configuration config = Configuration.load(metadataFile);
		ConfigurationSection slot = config.getConfigurationSection("0");
		SlotToken token = new SlotToken(0, slot);
		assertTrue(token.isMoveable());
	}
	
	@Test
	public void testSlotNotMoveable()
	{
		File slotFolder = new File("test", "slot");
		File metadataFile = new File(slotFolder, "moveable.yml");
		Configuration config = Configuration.load(metadataFile);
		ConfigurationSection slot = config.getConfigurationSection("1");
		SlotToken token = new SlotToken(1, slot);
		assertFalse(token.isMoveable());
	}
}