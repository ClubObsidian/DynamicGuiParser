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

import com.clubobsidian.dynamicgui.parser.function.tree.FunctionTree;
import com.clubobsidian.dynamicgui.parser.macro.MacroToken;
import com.clubobsidian.wrappy.ConfigurationSection;

public class SlotToken {

	private String icon;
	private String name;
	private String nbt;
	private boolean closed;
	private byte data;
	
	private FunctionTree functionTree;
	private MacroToken macroToken;
	
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
		
		ConfigurationSection macrosSection = section.getConfigurationSection("macros");
		this.macroToken = new MacroToken(macrosSection);
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
	
	public MacroToken getMacroToken()
	{
		return this.macroToken;
	}
}