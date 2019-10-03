/*
   Copyright 2019 Club Obsidian and contributors.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.clubobsidian.dynamicgui.parser.slot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.clubobsidian.dynamicgui.parser.function.tree.FunctionTree;
import com.clubobsidian.dynamicgui.parser.macro.MacroParser;
import com.clubobsidian.dynamicgui.parser.macro.MacroToken;
import com.clubobsidian.wrappy.ConfigurationSection;

public class SlotToken implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1898426889177654844L;
	
	private int index;
	private int amount;
	private String icon;
	private String name;
	private String nbt;
	private boolean closed;
	private byte data;
	private List<String> lore;
	private List<String> enchants;
	private int updateInterval;
	private MacroParser macroParser;
	private FunctionTree functionTree;
	public SlotToken(int index, ConfigurationSection section)
	{
		this(index, section, new ArrayList<MacroToken>());
	}
	
	public SlotToken(int index, ConfigurationSection section, List<MacroToken> macroTokens)
	{
		List<MacroToken> copyMacroTokens = new ArrayList<>();
		for(MacroToken macroToken : macroTokens)
		{
			copyMacroTokens.add(macroToken);
		}
		
		ConfigurationSection macrosSection = section.getConfigurationSection("macros");
		copyMacroTokens.add(new MacroToken(macrosSection));
		
		this.macroParser = new MacroParser(copyMacroTokens);
		
		this.index = index;
		this.amount = this.parseAmount(section.getInteger("amount"));
		this.icon = macroParser.parseStringMacros(section.getString("icon"));
		this.name = macroParser.parseStringMacros(section.getString("name"));
		this.nbt = macroParser.parseStringMacros(section.getString("nbt"));
		this.closed = section.getBoolean("close");
		this.data = this.parseData(macroParser, section);
		this.lore = macroParser.parseListMacros(section.getStringList("lore"));
		this.enchants = macroParser.parseListMacros(section.getStringList("enchants"));
		this.updateInterval = this.parseUpdateInterval(section);
		
		ConfigurationSection functionsSection = section.getConfigurationSection("functions");
		this.functionTree = new FunctionTree(functionsSection, this.macroParser);
		
	}
	
	private int parseAmount(int amount)
	{
		if(amount == 0)
		{
			return 1;
		}
		return amount;
	}
	
	private byte parseData(MacroParser parser, ConfigurationSection section)
	{
		String stringData = parser.parseStringMacros(section.getString("data"));
		
		try
		{
			byte bytes = Byte.parseByte(stringData);
			return bytes;
		}
		catch(Exception ex)
		{
			return 0;
		}
	}
	
	public int parseUpdateInterval(ConfigurationSection section)
	{
		int updateInterval = section.getInteger("update-interval");
		if(updateInterval < 0 || updateInterval > 20)
			return 0;
		
		return updateInterval;
	}
	
	public int getIndex()
	{
		return this.index;
	}
	
	public int getAmount()
	{
		return this.amount;
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
	
	public List<String> getLore()
	{
		return this.lore;
	}
	
	public int getUpdateInterval()
	{
		return this.updateInterval;
	}
	
	public List<String> getEnchants()
	{
		return this.enchants;
	}
	
	public FunctionTree getFunctionTree()
	{
		return this.functionTree;
	}
	
	public MacroParser getMacroParser()
	{
		return this.macroParser;
	}
}