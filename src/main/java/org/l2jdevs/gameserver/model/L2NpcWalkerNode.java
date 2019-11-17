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
package org.l2jdevs.gameserver.model;

import org.l2jdevs.gameserver.network.NpcStringId;

/**
 * @author Rayan RPG, JIV
 * @since 927
 */
public class L2NpcWalkerNode extends Location
{
	private final String _chatString;
	private final NpcStringId _npcString;
	private final int _delay;
	private final boolean _runToLocation;
	
	public L2NpcWalkerNode(int moveX, int moveY, int moveZ, int delay, boolean runToLocation, NpcStringId npcString, String chatText)
	{
		super(moveX, moveY, moveZ);
		_delay = delay;
		_runToLocation = runToLocation;
		_npcString = npcString;
		_chatString = ((chatText == null) ? "" : chatText);
	}
	
	public String getChatText()
	{
		if (_npcString != null)
		{
			throw new IllegalStateException("npcString is defined for walker route!");
		}
		return _chatString;
	}
	
	public int getDelay()
	{
		return _delay;
	}
	
	public NpcStringId getNpcString()
	{
		return _npcString;
	}
	
	public boolean runToLocation()
	{
		return _runToLocation;
	}
}
