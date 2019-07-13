package com.clubobsidian.dynamicgui.parser.function.tree;

import java.util.ArrayList;
import java.util.List;

import com.clubobsidian.dynamicgui.parser.function.FunctionSection;

public class FunctionNode {

	private int depth;
	private FunctionSection data;
	private List<FunctionNode> children;
	public FunctionNode(int depth, FunctionSection data)
	{
		this.depth = depth;
		this.data = data;
		this.children = new ArrayList<>();
	}
	
	public int getDepth()
	{
		return this.depth;
	}
	
	public FunctionSection getData()
	{
		return this.data;
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
	
	public boolean removeChild(FunctionNode child)
	{
		return this.children.remove(child);
	}
}