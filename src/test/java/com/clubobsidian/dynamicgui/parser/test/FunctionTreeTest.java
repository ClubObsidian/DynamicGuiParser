package com.clubobsidian.dynamicgui.parser.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.function.FunctionToken;
import com.clubobsidian.dynamicgui.parser.function.FunctionTokenSection;
import com.clubobsidian.dynamicgui.parser.function.tree.FunctionNode;
import com.clubobsidian.dynamicgui.parser.function.tree.FunctionTree;
import com.clubobsidian.wrappy.Configuration;
import com.clubobsidian.wrappy.ConfigurationSection;

public class FunctionTreeTest {

	private static FunctionTree tree;
	
	@BeforeClass
	public static void loadTree()
	{
		File testFile = new File("test.yml");
		Configuration config = Configuration.load(testFile);
		ConfigurationSection firstSlotSection = config.getConfigurationSection("0");
		ConfigurationSection functionSection = firstSlotSection.getConfigurationSection("functions");
		tree = new FunctionTree(functionSection);
	}
	
	@Test
	public void testRootNodeSize()
	{
		int rootNodeSize = tree.getRootNodes().size();
		assertTrue("Root node size is not three", rootNodeSize == 3);
	}
	
	@Test
	public void testDescend()
	{
		List<FunctionNode> childrenNodes = tree.getRootNodes().get(0).getChildren();
		int childrenNodeSize = childrenNodes.size();
		FunctionTokenSection data = childrenNodes.get(0).getData();
		FunctionToken token = data.getFunctions().get(0);
		assertTrue("Children node size for descend is not one", childrenNodeSize == 1);
		assertTrue("Function is not function", token.getName().equals("function"));
		assertTrue("Function data for child not is not 'with other data'", token.getData().equals("with other data"));
	}
	
	@Test
	public void testDescendTwoFunctions()
	{
		List<FunctionNode> childrenNodes = tree.getRootNodes().get(1).getChildren();
		int childrenNodeSize = childrenNodes.size();
		assertTrue("Children node size for descend is not two", childrenNodeSize == 2);
	}
	
	@Test
	public void testDepthTwo()
	{
		List<FunctionNode> childrenNodes = tree.getRootNodes().get(1).getChildren().get(0).getChildren();
		int childrenNodeSize = childrenNodes.size();
		FunctionNode node = childrenNodes.get(0);
		FunctionTokenSection data = node.getData();
		FunctionToken token = data.getFunctions().get(0);
		assertTrue("Children node size for depth two is not one", childrenNodeSize == 1);
		assertTrue("Invalid data for depth-2-left node", token.getData().equals("some other data"));
	}
	
	@Test
	public void testColonParsing()
	{
		FunctionNode node = tree.getRootNodes().get(2);
		FunctionTokenSection data = node.getData();
		FunctionToken token = data.getFunctions().get(1);
		String functionDataStr = token.getData();
		assertTrue("Function data is not 'with:a colon'", functionDataStr.equals("with:a colon"));
	}
	
	@Test
	public void testTrimming()
	{
		FunctionNode node = tree.getRootNodes().get(2);
		FunctionTokenSection data = node.getData();
		FunctionToken token = data.getFunctions().get(2);
		String functionDataStr = token.getData();
		assertTrue("Function data is not 'test trimming'", functionDataStr.equals("test trimming"));
	}
}