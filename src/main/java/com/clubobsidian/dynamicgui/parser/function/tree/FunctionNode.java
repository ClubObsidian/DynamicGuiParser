package com.clubobsidian.dynamicgui.parser.function.tree;

import java.util.ArrayList;
import java.util.List;

import com.clubobsidian.dynamicgui.parser.function.FunctionToken;

public class FunctionNode {

	private int depth;
	private FunctionToken token;
	private List<FunctionNode> children;
	public FunctionNode(int depth, FunctionToken token)
	{
		this.depth = depth;
		this.token = token;
		this.children = new ArrayList<>();
	}
	
	public int getDepth()
	{
		return this.depth;
	}
	
	public FunctionToken getToken()
	{
		return this.token;
	}
	
	public List<FunctionNode> getChildren()
	{
		return this.children;
	}
	
	public boolean addChild(FunctionNode child)
	{
		if(this.children.contains(child))
		{
			return false;
		}
		return this.children.add(child);
	}
}