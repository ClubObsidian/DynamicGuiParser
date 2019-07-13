package com.clubobsidian.dynamicgui.parser.slot;

import com.clubobsidian.dynamicgui.parser.function.tree.FunctionTree;
import com.clubobsidian.wrappy.ConfigurationSection;

public class SlotToken {

	private String icon;
	private String name;
	private String nbt;
	private boolean closed;
	private byte data;
	
	private FunctionTree functionTree;
	
	public SlotToken(ConfigurationSection section)
	{
		this.parse(section);
	}
	
	private void parse(ConfigurationSection section)
	{
		this.icon = section.getString("icon");
		this.name = section.getString("name");
		this.nbt = section.getString("nbt");
		this.closed = section.getBoolean("close");
		this.data = (byte) section.getInteger("data");
		
		ConfigurationSection functionsSection = section.getConfigurationSection("functions");
		this.functionTree = new FunctionTree(functionsSection);
	}
	
	public String getIcon()
	{
		return this.icon;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getNbt()
	{
		return this.nbt;
	}
	
	public boolean isClosed()
	{
		return this.closed;
	}
	
	public byte getData()
	{
		return this.data;
	}
	
	public FunctionTree getFunctionTree()
	{
		return this.functionTree;
	}
}