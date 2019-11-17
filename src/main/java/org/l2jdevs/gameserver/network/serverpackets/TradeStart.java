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

import org.l2jdevs.Config;
import org.l2jdevs.gameserver.model.PcCondOverride;
import org.l2jdevs.gameserver.model.actor.instance.L2PcInstance;
import org.l2jdevs.gameserver.model.items.instance.L2ItemInstance;

public final class TradeStart extends AbstractItemPacket
{
	private final L2PcInstance _activeChar;
	private final L2ItemInstance[] _itemList;
	
	public TradeStart(L2PcInstance player)
	{
		_activeChar = player;
		_itemList = _activeChar.getInventory().getAvailableItems(true, (_activeChar.canOverrideCond(PcCondOverride.ITEM_CONDITIONS) && Config.GM_TRADE_RESTRICTED_ITEMS), false);
	}
	
	@Override
	protected final void writeImpl()
	{
		if ((_activeChar.getActiveTradeList() == null) || (_activeChar.getActiveTradeList().getPartner() == null))
		{
			return;
		}
		
		writeC(0x14);
		writeD(_activeChar.getActiveTradeList().getPartner().getObjectId());
		writeH(_itemList.length);
		for (L2ItemInstance item : _itemList)
		{
			writeItem(item);
		}
	}
}
