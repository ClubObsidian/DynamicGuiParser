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

import java.util.ArrayList;
import java.util.List;

import com.clubobsidian.dynamicgui.parser.function.FunctionData;
import com.clubobsidian.dynamicgui.parser.function.FunctionToken;
import com.clubobsidian.dynamicgui.parser.function.FunctionType;
import com.clubobsidian.wrappy.ConfigurationSection;

public class FunctionTree {

	public List<FunctionNode> rootNodes;
	public FunctionTree(ConfigurationSection section)
	{
		this.rootNodes = new ArrayList<FunctionNode>();
		this.parseNodes(section);
	}
	
	public List<FunctionNode> getRootNodes()
	{
		return this.rootNodes;
	}
	
	private void parseNodes(ConfigurationSection section)
	{
		int depth = 0;
		this.walkTree(depth, section, null);
	}
	
	private List<FunctionType> parseTypes(List<String> types)
	{
		List<FunctionType> typesList = new ArrayList<>();
		for(String type : types)
		{
			typesList.add(FunctionType.valueOf(type.toUpperCase()));
		}
		return typesList;
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
		
		ar[0] = args[0];
		ar[1] = dat;
		return ar;	
	}
	
	private List<FunctionData> parseFunctionData(List<String> tokens)
	{
		List<FunctionData> functionTokens = new ArrayList<FunctionData>();
		for(String token : tokens)
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
		System.out.println(section.getKeys());
		for(String rootKey : section.getKeys())
		{
			System.out.println(rootKey);
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