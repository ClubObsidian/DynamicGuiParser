package com.clubobsidian.dynamicgui.parser.function.tree;

import java.util.Collection;

public class FunctionTree {

	public Collection<FunctionNode> rootNodes;
	public FunctionTree(Collection<FunctionNode> rootNodes)
	{
		this.rootNodes = rootNodes;
	}
}