package com.clubobsidian.dynamicgui.parser.function.tree;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.clubobsidian.dynamicgui.parser.function.FunctionTokenSection;

public class FunctionNode {

	private int depth;
	private FunctionTokenSection data;
	private Collection<FunctionNode> children;
	public FunctionNode(int depth, FunctionTokenSection data)
	{
		this.depth = depth;
		this.data = data;
		this.children = new ConcurrentLinkedQueue<>();
	}
	
	public int getDepth()
	{
		return this.depth;
	}
	
	public FunctionTokenSection getData()
	{
		return this.data;
	}
	
	public Collection<FunctionNode> getChildren()
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