package com.clubobsidian.dynamicgui.parser.function;

import java.util.List;

public class FunctionToken {

	private String name;
	private List<FunctionType> types;
	private List<FunctionData> functions;
	public FunctionToken(String name, List<FunctionType> types, List<FunctionData> functions)
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
	
	public List<FunctionData> getFunctions()
	{
		return this.functions;
	}
}