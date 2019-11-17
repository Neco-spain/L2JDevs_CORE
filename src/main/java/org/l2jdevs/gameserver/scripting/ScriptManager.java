/*
 * Copyright © 2004-2019 L2JDevs
 * 
 * This file is part of L2JDevs.
 * 
 * L2JDevs is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * L2JDevs is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.l2jdevs.gameserver.scripting;

import java.util.Map;

import org.l2jdevs.gameserver.model.events.AbstractScript;

/**
 * @author KenM
 * @param <S>
 */
public abstract class ScriptManager<S extends AbstractScript>
{
	public abstract String getScriptManagerName();
	
	public abstract Map<String, S> getScripts();
	
	public boolean reload(S ms)
	{
		return ms.reload();
	}
	
	public void setActive(S ms, boolean status)
	{
		ms.setActive(status);
	}
	
	public boolean unload(S ms)
	{
		return ms.unload();
	}
}
