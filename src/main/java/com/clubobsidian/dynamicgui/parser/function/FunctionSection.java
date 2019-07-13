package com.clubobsidian.dynamicgui.parser.function;

import java.util.List;

public class FunctionSection {

	private String name;
	private List<FunctionType> types;
	private List<FunctionToken> functions;
	public FunctionSection(String name, List<FunctionType> types, List<FunctionToken> functions)
	{
		this.name = name;
		this.types = types;
		this.functions = functions;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public List<FunctionType> getTypes()
	{
		return this.types;
	}
	
	public List<FunctionToken> getFunctions()
	{
		return this.functions;
	}
}