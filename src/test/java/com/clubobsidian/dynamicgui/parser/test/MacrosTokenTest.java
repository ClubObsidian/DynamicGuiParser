package com.clubobsidian.dynamicgui.parser.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.macro.MacroToken;
import com.clubobsidian.wrappy.Configuration;
import com.clubobsidian.wrappy.ConfigurationSection;

public class MacrosTokenTest {

	@Test
	public void testGuiMacroToken()
	{
		File file = new File("test.yml");
		Configuration config = Configuration.load(file);
		ConfigurationSection section = config
				.getConfigurationSection("macros");
		MacroToken token = new MacroToken(section);
		Map<String, Object> macros = token.getMacros();
		
		assertTrue("Macros did not load in for gui macros, size is not 1", macros.size() == 1);
	}
	
	@Test
	@SuppressWarnings("rawtypes")
	public void testSlotMacroToken()
	{
		File file = new File("test.yml");
		Configuration config = Configuration.load(file);
		ConfigurationSection section = config
				.getConfigurationSection("0")
				.getConfigurationSection("macros");
		
		System.out.println(section.getKeys());
		
		MacroToken token = new MacroToken(section);
		Map<String, Object> macros = token.getMacros();
		
		Object firstMacro = macros.get("%test%");
		assertTrue("First line of slot macro is not a string", firstMacro instanceof String);
		assertTrue("First macro is not 'This is some text'", ((String) firstMacro).equals("This is some text"));
		
		Object secondMacro = macros.get("%multiline-test%");
		assertTrue("Second line of slot macro is not a list", secondMacro instanceof List);
		
		List listMacro = ((List) secondMacro);
		
		assertTrue("Second line of slot macro's first line is not a string", listMacro.get(0) instanceof String);
		assertTrue("Second line of slot macro's size is not 2", listMacro.size() == 2);
		
	}
	
	@Test
	public void testEmptyMacroToken()
	{
		File file = new File("test.yml");
		Configuration config = Configuration.load(file);
		ConfigurationSection section = config
				.getConfigurationSection("1")
				.getConfigurationSection("macros");
		
		MacroToken token = new MacroToken(section);
		Map<String, Object> macros = token.getMacros();
		
		assertTrue("Macros is null on an empty slot, it should just be empty", macros != null);
		assertTrue("Macros is not empty when it should be empty", macros.size() == 0);
	}
}