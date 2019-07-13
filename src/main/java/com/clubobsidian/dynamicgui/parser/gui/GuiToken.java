package com.clubobsidian.dynamicgui.parser.gui;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.clubobsidian.dynamicgui.parser.function.tree.FunctionTree;
import com.clubobsidian.dynamicgui.parser.slot.SlotToken;
import com.clubobsidian.wrappy.ConfigurationSection;

public class GuiToken {

	private String title;
	private int rows;
	private GuiMode mode;
	private boolean closed;
	private List<Integer> npcs;
	private Map<Integer, SlotToken> slots;
	private FunctionTree globalFunctions;
	public GuiToken(ConfigurationSection section)
	{
		this.title = section.getString("title");
		this.rows = section.getInteger("rows");
		this.mode = GuiMode.valueOf(section.getString("mode").toUpperCase());
		this.closed = section.getBoolean("close");
		this.npcs = section.getIntegerList("npcs");
		this.loadSlots(section);
		
		ConfigurationSection globalSection = section.getConfigurationSection("global-functions");
		this.globalFunctions = new FunctionTree(globalSection);
	}
	
	private void loadSlots(ConfigurationSection section)
	{
		this.slots = new LinkedHashMap<>();
		
		int slots = this.rows * 9;
		
		for(int i = 0; i < slots; i++)
		{
			ConfigurationSection slotSection = section.getConfigurationSection(String.valueOf(i));
			if(!slotSection.isEmpty())
			{
				SlotToken token = new SlotToken(slotSection);
				this.slots.put(i, token);
			}
		}
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public int getRows()
	{
		return this.rows;
	}
	
	public GuiMode getMode()
	{
		return this.mode;
	}
	
	public boolean isClosed()
	{
		return this.closed;
	}
	
	public List<Integer> getNpcs()
	{
		return this.npcs;
	}
	
	public Map<Integer, SlotToken> getSlots()
	{
		return this.slots;
	}
	
	public FunctionTree getGlobalFunctions()
	{
		return this.globalFunctions;
	}
}