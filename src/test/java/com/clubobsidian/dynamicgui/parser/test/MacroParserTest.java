package com.clubobsidian.dynamicgui.parser.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.macro.MacroParser;
import com.clubobsidian.dynamicgui.parser.macro.MacroToken;
import com.clubobsidian.wrappy.Configuration;
import com.clubobsidian.wrappy.ConfigurationSection;

public class MacroParserTest {

	@Test
	public void testMultilineParsing()
	{
		File test = new File("test.yml");
		Configuration config = Configuration.load(test);
		
		ConfigurationSection first = config.getConfigurationSection("2");
		ConfigurationSection macros = first.getConfigurationSection("macros");
		
		List<String> lore = first.getStringList("lore");
		
		MacroToken token = new MacroToken(macros);
		
		List<MacroToken> tokens = new ArrayList<>();
		tokens.add(token);
		
		MacroParser parser = new MacroParser(tokens);
		
		List<String> newLore = parser.parseListMacros(lore);
		
		assertTrue("New lore size is not 68", newLore.size() == 8);
		assertTrue("First line is not 'This is some gui text'", newLore.get(0).equals("This is some text"));
		assertTrue("Second line is not 'Replace some text'", newLore.get(1).equals("Replace some text"));
		assertTrue("Third line is not 'and some other text test'", newLore.get(2).equals("and some other text test"));
		assertTrue("Forth line is not 'with some other text'", newLore.get(3).equals("with some other text"));
		assertTrue("Fifth line is not 'Replace some text'", newLore.get(4).equals("Replace some text"));
		assertTrue("Sixth line is not 'and some other text'", newLore.get(5).equals("and some other text"));
		assertTrue("Seventh line is not 'with some other text'", newLore.get(6).equals("with some other text"));
		assertTrue("Eigth line is not 'not-a-macro'", newLore.get(7).equals("not-a-macro"));
	}
	
	@Test
	public void testSmallMultiLine()
	{
		File test = new File("test.yml");
		Configuration config = Configuration.load(test);
		
		ConfigurationSection first = config.getConfigurationSection("3");
		ConfigurationSection macros = first.getConfigurationSection("macros");
		
		List<String> lore = first.getStringList("lore");
		
		MacroToken token = new MacroToken(macros);
		
		List<MacroToken> tokens = new ArrayList<>();
		tokens.add(token);
		
		MacroParser parser = new MacroParser(tokens);
		
		List<String> newLore = parser.parseListMacros(lore);
		
		assertTrue("Size of new lore is not 2", newLore.size() == 2);
		assertTrue("First line is not 'Replace some text", newLore.get(0).equals("Replace some text"));
		assertTrue("Second line is not 'test'", newLore.get(1).equals("test"));
	}
	
	@Test
	public void testOutOfIndexSmallMultiLine()
	{
		File test = new File("test.yml");
		Configuration config = Configuration.load(test);
		
		ConfigurationSection first = config.getConfigurationSection("4");
		ConfigurationSection macros = first.getConfigurationSection("macros");
		
		List<String> lore = first.getStringList("lore");
		
		MacroToken token = new MacroToken(macros);
		
		List<MacroToken> tokens = new ArrayList<>();
		tokens.add(token);
		
		MacroParser parser = new MacroParser(tokens);
		
		List<String> newLore = parser.parseListMacros(lore);
		
		System.out.println("New lore: " + newLore + " Size: " + newLore.size());
		
		assertTrue("Size of new lore is not 1", newLore.size() == 1);
		assertTrue("First line is not 'Replace some text", newLore.get(0).equals("Replace some text"));

	}
	
	@Test
	public void testSingleLineParsing()
	{
		File test = new File("test.yml");
		Configuration config = Configuration.load(test);
		
		ConfigurationSection first = config.getConfigurationSection("2");
		ConfigurationSection macros = first.getConfigurationSection("macros");
		
		String name = first.getString("name");
		
		MacroToken token = new MacroToken(macros);
		
		List<MacroToken> tokens = new ArrayList<>();
		tokens.add(token);
		
		MacroParser parser = new MacroParser(tokens);
		
		String newName = parser.parseStringMacros(name);
		
		assertTrue("New name is not 'A name'", newName.equals("A name"));
	}
	
	
}