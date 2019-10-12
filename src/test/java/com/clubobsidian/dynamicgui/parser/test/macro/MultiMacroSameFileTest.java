package com.clubobsidian.dynamicgui.parser.test.macro;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.clubobsidian.dynamicgui.parser.macro.MacroParser;
import com.clubobsidian.dynamicgui.parser.macro.MacroToken;
import com.clubobsidian.wrappy.Configuration;

public class MultiMacroSameFileTest {

	@Test
	public void stringTest()
	{
		File testFolder = new File("test");
		File macroFolder = new File(testFolder, "macro"); 
		File sameFileMacroFile = new File(macroFolder, "multi-same-file-macro.yml");
		System.out.println(sameFileMacroFile.exists());
		Configuration config = Configuration.load(sameFileMacroFile);

		List<MacroToken> tokens = new ArrayList<>();
		for(String key : config.getKeys())
		{
			MacroToken token = new MacroToken(config.getConfigurationSection(key));
			tokens.add(token);
		}
		
		MacroParser parser = new MacroParser(tokens);
		String toParse = "%uses-test%";
		String parsed = parser.parseStringMacros(toParse);
		System.out.println(parsed);
		assertTrue(parsed.equals("test"));
	}
	
	@Test
	public void listTest()
	{
		File testFolder = new File("test");
		File macroFolder = new File(testFolder, "macro"); 
		File sameFileMacroFile = new File(macroFolder, "multi-same-file-macro.yml");
		System.out.println(sameFileMacroFile.exists());
		Configuration config = Configuration.load(sameFileMacroFile);

		List<MacroToken> tokens = new ArrayList<>();
		for(String key : config.getKeys())
		{
			MacroToken token = new MacroToken(config.getConfigurationSection(key));
			tokens.add(token);
		}
		
		MacroParser parser = new MacroParser(tokens);
		List<String> replaceIn = new ArrayList<>();
		String toParse = "%uses-multiline-macro%";
		replaceIn.add(toParse);
		List<String> parsed = parser.parseListMacros(replaceIn);
		System.out.println(parsed);
		assertTrue(parsed.size() == 2);
		assertTrue(parsed.get(0).equals("test1"));
		assertTrue(parsed.get(1).equals("test2"));
	}
	
}