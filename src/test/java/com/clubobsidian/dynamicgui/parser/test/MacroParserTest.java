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
		
		ConfigurationSection first = config.getConfigurationSection("0");
		ConfigurationSection macros = first.getConfigurationSection("macros");
		
		List<String> lore = first.getStringList("lore");
		
		MacroToken token = new MacroToken(macros);
		
		List<MacroToken> tokens = new ArrayList<>();
		tokens.add(token);
		
		MacroParser parser = new MacroParser(tokens);
		
		List<String> newLore = parser.parseListMacros(lore);
		
		assertTrue("New lore size is not 5", newLore.size() == 5);
		assertTrue("First line is not 'This is some gui text'", newLore.get(0).equals("This is some text"));
		assertTrue("Second line is not 'Replace some text'", newLore.get(1).equals("Replace some text"));
		assertTrue("Third line is not 'and some other text test'", newLore.get(2).equals("and some other text test"));
		assertTrue("Forth line is not 'Replace some text'", newLore.get(3).equals("Replace some text"));
		assertTrue("Fifth is not 'and some other text'", newLore.get(4).equals("and some other text"));
	}
}