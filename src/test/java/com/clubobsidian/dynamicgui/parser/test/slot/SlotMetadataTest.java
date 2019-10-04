package com.clubobsidian.dynamicgui.parser.test.slot;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Map;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.slot.SlotToken;
import com.clubobsidian.wrappy.Configuration;
import com.clubobsidian.wrappy.ConfigurationSection;

public class SlotMetadataTest {

	@Test
	public void testSlotMetadata()
	{
		File slotFolder = new File("test", "slot");
		File metadataFile = new File(slotFolder, "metadata.yml");
		Configuration config = Configuration.load(metadataFile);
		ConfigurationSection slot = config.getConfigurationSection("0");
		SlotToken token = new SlotToken(0, slot);
		Map<String, String> metadata = token.getMetadata();
		assertTrue(metadata.size() == 1);
		assertTrue(metadata.get("some").equals("metadata"));
	}
	
	@Test
	public void testSlotNoMetadata()
	{
		File slotFolder = new File("test", "slot");
		File metadataFile = new File(slotFolder, "metadata.yml");
		Configuration config = Configuration.load(metadataFile);
		ConfigurationSection slot = config.getConfigurationSection("1");
		SlotToken token = new SlotToken(1, slot);
		Map<String, String> metadata = token.getMetadata();
		assertTrue(metadata.size() == 0);
	}
}