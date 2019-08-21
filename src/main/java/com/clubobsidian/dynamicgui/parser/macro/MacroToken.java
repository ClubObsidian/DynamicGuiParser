package com.clubobsidian.dynamicgui.parser.macro;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.clubobsidian.wrappy.ConfigurationSection;

public class MacroToken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6384645527099128238L;
	
	private Map<String, Object> macros;
	public MacroToken(ConfigurationSection section)
	{
		this.parse(section);
	}
	
	private void parse(ConfigurationSection section)
	{
		this.macros = new LinkedHashMap<>();
		for(String key : section.getKeys())
		{
			this.macros.put(key, section.get(key));
		}
	}
	
	public Map<String, Object> getMacros()
	{
		return this.macros;
	}
}