package com.clubobsidian.dynamicgui.parser;

import com.clubobsidian.dynamicgui.parser.function.tree.FunctionTree;
import com.clubobsidian.wrappy.ConfigurationSection;

public class FunctionParser {

	private FunctionTree tree;
	public FunctionParser(ConfigurationSection section)
	{
		this.parse(section);
	}
	
	private void parse(ConfigurationSection section)
	{
		
	}
	
	public FunctionTree getTree()
	{
		return this.tree;
	}
}