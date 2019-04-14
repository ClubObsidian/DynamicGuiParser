package com.clubobsidian.dynamicgui.parser.function;

public class FunctionToken {

	private String name;
	private String data;
	public FunctionToken(String name, String data)
	{
		this.name = name;
		this.data = data;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getData()
	{
		return this.data;
	}
}