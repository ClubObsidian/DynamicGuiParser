package com.clubobsidian.dynamicgui.parser.test.functiontree;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.function.tree.FunctionTree;

public class EmptyFunctionTreeTest {

	@Test
	public void testEmptyFunctionTree()
	{
		FunctionTree tree = new FunctionTree();
		assertTrue("Tree nodes are not empty", tree.getRootNodes().size() == 0);
	}
}