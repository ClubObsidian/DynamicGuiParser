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
package com.clubobsidian.dynamicgui.parser.function.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.clubobsidian.dynamicgui.parser.function.FunctionData;
import com.clubobsidian.dynamicgui.parser.function.FunctionToken;
import com.clubobsidian.dynamicgui.parser.function.FunctionType;
import com.clubobsidian.dynamicgui.parser.macro.MacroParser;
import com.clubobsidian.dynamicgui.parser.macro.MacroToken;
import com.clubobsidian.fuzzutil.StringFuzz;
import com.clubobsidian.wrappy.ConfigurationSection;

public class FunctionTree implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3700259615018247686L;
	
	private List<FunctionNode> rootNodes;
	private MacroParser macroParser;
	public FunctionTree(ConfigurationSection section)
	{
		this(section, new MacroParser(new ArrayList<MacroToken>()));
	}
	
	public FunctionTree(ConfigurationSection section, MacroParser macroParser)
	{
		this.rootNodes = new ArrayList<FunctionNode>();
		this.macroParser = macroParser;
		this.parseNodes(section);
	}
	
	public List<FunctionNode> getRootNodes()
	{
		return this.rootNodes;
	}
	
	public MacroParser getMacroParser()
	{
		return this.macroParser;
	}
	
	private void parseNodes(ConfigurationSection section)
	{
		int depth = 0;
		this.walkTree(depth, section, null);
	}
	
	private List<FunctionType> parseTypes(List<String> types)
	{;
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
	
	private FunctionType parseType(String type)
	{
		try
		{
			FunctionType functionType = FunctionType.valueOf(type.toUpperCase());
			return functionType;
		}
		catch(Exception ex)
		{
			return null;
		}
	}
	
	private String[] parseFunctionData(String functionData)
	{
		if(!functionData.contains(":"))
		{
			String[] args = new String[2];
			args[0] = functionData;
			args[1] = null;
			return args;
		}
		
		String[] ar = new String[2];
		String dat = null;
		String[] args = functionData.split(":");
		
		dat = args[1].trim();
		
		if(args.length > 2)
		{
			for(int i = 2; i < args.length; i++)
				dat +=  ":" + args[i];
		}
		
		ar[0] = StringFuzz.normalize(args[0]);
		ar[1] = dat;
		return ar;	
	}
	
	private List<FunctionData> parseFunctionData(final List<String> tokens)
	{
		List<String> parsedTokens = this.macroParser.parseListMacros(tokens);
		
		List<FunctionData> functionTokens = new ArrayList<FunctionData>();
		for(String token : parsedTokens)
		{
			String[] parsedFunctionData = this.parseFunctionData(token);
			String functionName = parsedFunctionData[0];
			String functionData = parsedFunctionData[1];
			functionTokens.add(new FunctionData(functionName, functionData));
		}
		return functionTokens;
	}
	
	private void walkTree(int depth, ConfigurationSection section, FunctionNode parentNode)
	{
		for(String rootKey : section.getKeys())
		{
			ConfigurationSection rootSection = section.getConfigurationSection(rootKey);
			if(rootSection.get("functions") == null)
			{
				continue;
			}
			
			String name = rootKey;
			List<FunctionType> types = this.parseTypes(rootSection.getStringList("type"));
			List<FunctionData> functionTokens = this.parseFunctionData(rootSection.getStringList("functions"));
			List<FunctionData> failFunctions = this.parseFunctionData(rootSection.getStringList("fail-on"));
			
			FunctionToken data = new FunctionToken(name, types, functionTokens, failFunctions);
			FunctionNode childNode = new FunctionNode(depth, data);
			
			if(depth == 0)
			{
				this.rootNodes.add(childNode);
			}
			else
			{
				parentNode.addChild(childNode);
			}
			
			int newDepth = depth + 1;
			walkTree(newDepth, rootSection, childNode);
		}
	}
}