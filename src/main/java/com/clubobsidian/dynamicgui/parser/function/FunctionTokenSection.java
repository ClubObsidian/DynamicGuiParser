package com.clubobsidian.dynamicgui.parser.function;

import java.util.Collection;

public class FunctionTokenSection {

	private String name;
	private Collection<FunctionType> types;
	private Collection<FunctionToken> functions;
	public FunctionTokenSection(String name, Collection<FunctionType> types, Collection<FunctionToken> functions)
	{
		this.name = name;
		this.types = types;
		this.functions = functions;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Collection<FunctionType> getTypes()
	{
		return this.types;
	}
	
	public Collection<FunctionToken> getFunctions()
	{
		return this.functions;
	}
}