package com.clubobsidian.dynamicgui.parser.function.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.clubobsidian.dynamicgui.parser.function.FunctionToken;
import com.clubobsidian.dynamicgui.parser.function.FunctionTokenSection;
import com.clubobsidian.dynamicgui.parser.function.FunctionType;
import com.clubobsidian.wrappy.ConfigurationSection;

public class FunctionTree {

	public Collection<FunctionNode> rootNodes;
	public FunctionTree(ConfigurationSection section)
	{
		this.rootNodes = new ArrayList<FunctionNode>();
		this.parseNodes(section);
	}
	
	public Collection<FunctionNode> getRootNodes()
	{
		return this.rootNodes;
	}
	
	private void parseNodes(ConfigurationSection section)
	{
		int depth = 0;
		this.walkTree(depth, section, null);
	}
	
	private Collection<FunctionType> parseTypes(List<String> types)
	{
		Collection<FunctionType> typesList = new ArrayList<>();
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
		
		if(functionData.charAt(functionData.indexOf(":") + 1) == ' ')
		{
			dat = args[1].substring(1);
		}
		else 
		{
			System.out.println("args: " + args.length);
			System.out.println("out of bound: " + functionData);
			dat = args[1];
		}
		if(args.length > 2)
		{
			for(int i = 2; i < args.length; i++)
				dat +=  ":" + args[i];
		}
		
		ar[0] = args[0];
		ar[1] = dat;
		return ar;	
	}
	
	private Collection<FunctionToken> parseTokens(List<String> tokens)
	{
		Collection<FunctionToken> functionTokens = new ArrayList<FunctionToken>();
		for(String token : tokens)
		{
			String[] parsedFunctionData = this.parseFunctionData(token);
			String functionName = parsedFunctionData[0];
			String functionData = parsedFunctionData[1];
			functionTokens.add(new FunctionToken(functionName, functionData));
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
				return;
			}
			
			String name = rootKey;
			Collection<FunctionType> types = this.parseTypes(rootSection.getStringList("type"));
			Collection<FunctionToken> functionTokens = this.parseTokens(rootSection.getStringList("functions"));
			
			FunctionTokenSection data = new FunctionTokenSection(name, types, functionTokens);
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