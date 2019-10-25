package com.clubobsidian.dynamicgui.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public final class ReplacerUtil {

	private ReplacerUtil() {}
	
	private static Map<String, Pattern> patterns = new ConcurrentHashMap<>();
	
	public static String replace(String replaceIn, String key, String value)
	{
		Pattern pattern = ReplacerUtil.getPattern(key);
		return pattern.matcher(replaceIn).replaceAll(value);
	}
	
	public static Map<String, Pattern> getPatterns()
	{
		return ReplacerUtil.patterns;
	}
	
	private static Pattern getPattern(String key)
	{
		Pattern pattern = ReplacerUtil.patterns.get(key);
		if(pattern == null)
		{
			pattern = Pattern.compile(key);
			ReplacerUtil.patterns.put(key, pattern);
		}
		
		return pattern;
	}
}