package com.clubobsidian.dynamicgui.parser.slot;

import com.clubobsidian.wrappy.ConfigurationSection;

public class SlotToken {

	private int index;
	private String icon;
	private String name;
	private boolean close;
	private byte data;
	private String nbt;
	
	public SlotToken(ConfigurationSection section)
	{
		this.parse(section);
	}
	
	private void parse(ConfigurationSection section)
	{
		this.icon = section.getString("icon");
		this.name = section.getString("name");
		this.nbt = section.getString("nbt");
		this.close = section.getBoolean("close");
		this.data = (byte) section.getInteger("data");
		this.nbt = section.getString("nbt");
	}
}