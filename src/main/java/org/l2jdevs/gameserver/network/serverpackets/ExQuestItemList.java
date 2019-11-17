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
package org.l2jdevs.gameserver.network.serverpackets;

import java.util.ArrayList;
import java.util.List;

import org.l2jdevs.gameserver.model.actor.instance.L2PcInstance;
import org.l2jdevs.gameserver.model.items.instance.L2ItemInstance;

/**
 * @author JIV
 */
public class ExQuestItemList extends AbstractItemPacket
{
	private final L2PcInstance _activeChar;
	private final List<L2ItemInstance> _items = new ArrayList<>();
	
	public ExQuestItemList(L2PcInstance activeChar)
	{
		_activeChar = activeChar;
		for (L2ItemInstance item : activeChar.getInventory().getItems())
		{
			if (item.isQuestItem())
			{
				_items.add(item);
			}
		}
	}
	
	@Override
	protected void writeImpl()
	{
		writeC(0xFE);
		writeH(0xC6);
		writeH(_items.size());
		for (L2ItemInstance item : _items)
		{
			writeItem(item);
		}
		writeInventoryBlock(_activeChar.getInventory());
	}
}
