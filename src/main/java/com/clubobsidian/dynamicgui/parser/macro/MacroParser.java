package com.clubobsidian.dynamicgui.parser.macro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class MacroParser {

	private List<MacroToken> tokens;
	
	public MacroParser(List<MacroToken> tokens)
	{
		this.tokens = tokens;
	}
	
	public String parseStringMacros(final String replaceIn)
	{
		if(replaceIn == null)
			return null;
		
		String replace = replaceIn;
		for(MacroToken token : this.tokens)
		{
			Iterator<Entry<String, Object>> it = token.getMacros().entrySet().iterator();
			while(it.hasNext())
			{
				Entry<String, Object> next = it.next();
				String key = next.getKey();
				Object value = next.getValue();
				if(value instanceof String)
				{
					replace = replace.replace(key, (String) value);
				}
			}
		}
		return replace;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> parseListMacros(final List<String> replaceIn)
	{
		List<String> newList = new ArrayList<>();
		
		for(String line : replaceIn)
		{
			boolean hasMacro = false;
			for(MacroToken token : this.tokens)
			{
				Iterator<Entry<String, Object>> it = token.getMacros().entrySet().iterator();
				while(it.hasNext())
				{
					Entry<String, Object> next = it.next();
					String key = next.getKey();
					
					if(line.contains(key))
					{
						hasMacro = true;
						Object value = next.getValue();
						if(value instanceof String)
						{
							String stringMacro = (String) value;
							newList.add(line.replace(key, stringMacro));
						}
						else
						{
							List<String> listMacro = (List<String>) value;
							
							int startIndex = line.indexOf(key);
							int endIndex = startIndex + key.length();
							
							String macro = listMacro.get(0);
							String firstLine = line.substring(0, endIndex)
									.replace(key, macro);
							
							newList.add(firstLine);
							
							String ending = line.substring(endIndex);
							String appended = ending;
							if(listMacro.size() >= 2)
							{
								appended = listMacro.get(1) + ending;
							}
							
							if(appended.length() > 0)
							{
								newList.add(appended);
							}
							
							for(int i = 2; i < listMacro.size(); i++)
							{
								newList.add(listMacro.get(i));
							}
						}
					}
				}
			}
			if(!hasMacro)
			{
				newList.add(line);
			}
		}
		
		return newList;
	}
}