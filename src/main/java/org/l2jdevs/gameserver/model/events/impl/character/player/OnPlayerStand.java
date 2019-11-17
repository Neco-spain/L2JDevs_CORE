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
package org.l2jdevs.gameserver.model.events.impl.character.player;

import org.l2jdevs.gameserver.model.actor.instance.L2PcInstance;
import org.l2jdevs.gameserver.model.events.EventType;
import org.l2jdevs.gameserver.model.events.impl.IBaseEvent;

/**
 * @author Zealar
 * @since 2.6.0.0
 */
public class OnPlayerStand implements IBaseEvent
{
	private final L2PcInstance _activeChar;
	
	public OnPlayerStand(L2PcInstance activeChar)
	{
		_activeChar = activeChar;
	}
	
	public L2PcInstance getActiveChar()
	{
		return _activeChar;
	}
	
	@Override
	public EventType getType()
	{
		return EventType.ON_PLAYER_STAND;
	}
}
