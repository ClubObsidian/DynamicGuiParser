package com.clubobsidian.dynamicgui.parser.function;

import java.util.ArrayList;
import java.util.List;

import com.clubobsidian.dynamicgui.parser.macro.MacroParser;

public class FunctionTypeParser {

	private MacroParser macroParser;
	public FunctionTypeParser(MacroParser macroParser)
	{
		this.macroParser = macroParser;
	}
	
	public List<FunctionType> parseTypes(List<String> types)
	{
		types = this.macroParser.parseListMacros(types);
		List<FunctionType> typesList = new ArrayList<>();
		for(String type : types)
		{
			FunctionType parsedType = this.parseType(type);
			if(parsedType == null)
				continue; //TODO - warn
			
			typesList.add(parsedType);
		}
		return typesList;
	}
	
	public FunctionType parseType(String type)
	{
		FunctionType functionType = FunctionType.getFuzzyType(type);
		return functionType;
	}
}