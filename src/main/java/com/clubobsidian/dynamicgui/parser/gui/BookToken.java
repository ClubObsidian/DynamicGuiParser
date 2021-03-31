/*
 *    Copyright 2021 Club Obsidian and contributors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.clubobsidian.dynamicgui.parser.gui;

import com.clubobsidian.dynamicgui.parser.macro.MacroParser;
import com.clubobsidian.dynamicgui.parser.macro.MacroToken;
import com.clubobsidian.wrappy.ConfigurationSection;

import java.io.Serializable;
import java.util.List;

public class BookToken implements Serializable {

    private static final long serialVersionUID = 4781613146790142017L;

    private final String title;
    private final String author;
    private final List<String> pages;
    public BookToken(ConfigurationSection section, List<MacroToken> macroTokens)
    {
        this(section.getString("title"),
                section.getString("author"),
                parsePages(section),
                macroTokens);
    }

    public BookToken(String title, String author, List<String> pages, List<MacroToken> macroTokens)
    {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public List<String> getPages()
    {
        return this.pages;
    }

    private static List<String> parsePages(ConfigurationSection section)
    {

    }
}