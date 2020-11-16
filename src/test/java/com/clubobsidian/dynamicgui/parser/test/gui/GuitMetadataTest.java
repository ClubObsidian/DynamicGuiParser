package com.clubobsidian.dynamicgui.parser.test.gui;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Map;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.gui.GuiToken;
import com.clubobsidian.dynamicgui.parser.slot.SlotToken;
import com.clubobsidian.wrappy.Configuration;
import com.clubobsidian.wrappy.ConfigurationSection;

public class GuitMetadataTest {

	@Test
	public void testSlotMetadata()
	{
		File slotFolder = new File("test", "gui");
		File metadataFile = new File(slotFolder, "metadata.yml");
		Configuration config = Configuration.load(metadataFile);
		GuiToken token = new GuiToken(config);
		Map<String, String> metadata = token.getMetadata();
		assertTrue(metadata.size() == 1);
		assertTrue(metadata.get("some").equals("metadata"));
	}
}