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
package org.l2jdevs.gameserver.model.events.impl.character.player.clanwh;

import org.l2jdevs.gameserver.model.actor.instance.L2PcInstance;
import org.l2jdevs.gameserver.model.events.EventType;
import org.l2jdevs.gameserver.model.events.impl.IBaseEvent;
import org.l2jdevs.gameserver.model.itemcontainer.ItemContainer;
import org.l2jdevs.gameserver.model.items.instance.L2ItemInstance;

/**
 * @author UnAfraid
 */
public class OnPlayerClanWHItemTransfer implements IBaseEvent
{
	private final String _process;
	private final L2PcInstance _activeChar;
	private final L2ItemInstance _item;
	private final long _count;
	private final ItemContainer _container;
	
	public OnPlayerClanWHItemTransfer(String process, L2PcInstance activeChar, L2ItemInstance item, long count, ItemContainer container)
	{
		_process = process;
		_activeChar = activeChar;
		_item = item;
		_count = count;
		_container = container;
	}
	
	public L2PcInstance getActiveChar()
	{
		return _activeChar;
	}
	
	public ItemContainer getContainer()
	{
		return _container;
	}
	
	public long getCount()
	{
		return _count;
	}
	
	public L2ItemInstance getItem()
	{
		return _item;
	}
	
	public String getProcess()
	{
		return _process;
	}
	
	@Override
	public EventType getType()
	{
		return EventType.ON_PLAYER_CLAN_WH_ITEM_TRANSFER;
	}
}
