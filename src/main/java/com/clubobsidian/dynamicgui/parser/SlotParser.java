package com.clubobsidian.dynamicgui.parser;

import com.clubobsidian.dynamicgui.parser.slot.SlotToken;
import com.clubobsidian.wrappy.ConfigurationSection;

public class SlotParser {

	private SlotToken slotToken;
	public SlotParser(ConfigurationSection section)
	{
		this.parse(section);
	}
	
	private void parse(ConfigurationSection section)
	{
		this.slotToken = new SlotToken(section);
	}
	
	public SlotToken getToken()
	{
		return this.slotToken;
	}
}