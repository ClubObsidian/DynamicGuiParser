/*
   Copyright 2019 Club Obsidian and contributors.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.clubobsidian.dynamicgui.parser.function;

public enum FunctionType {
	
	CLICK(true),
	LEFT(true),
	RIGHT(true),
	MIDDLE(true),
	SHIFT_CLICK(true),
	SHIFT_LEFT(true),
	SHIFT_RIGHT(true),
	SHIFT_MIDDLE(true),
	LOAD(false),
	FAIL(false);
	
	private boolean isClick;
	private FunctionType(boolean isClick)
	{
		this.isClick = isClick;
	}
	
	public boolean isClick()
	{
		return this.isClick;
	}
}