package com.clubobsidian.dynamicgui.parser.function.tree;

import java.util.ArrayList;
import java.util.List;

import com.clubobsidian.dynamicgui.parser.function.FunctionData;

public class FunctionNode {

	private int depth;
	private FunctionData data;
	private List<FunctionNode> children;
	public FunctionNode(int depth, FunctionData data)
	{
		this.depth = depth;
		this.data = data;
		this.children = new ArrayList<>();
	}
	
	public int getDepth()
	{
		return this.depth;
	}
	
	public FunctionData getData()
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