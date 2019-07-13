package com.clubobsidian.dynamicgui.parser.function;

public class FunctionData {

	private String name;
	private String data;
	public FunctionData(String name, String data)
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