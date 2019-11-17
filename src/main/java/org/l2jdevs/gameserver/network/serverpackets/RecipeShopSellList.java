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

import org.l2jdevs.gameserver.model.L2ManufactureItem;
import org.l2jdevs.gameserver.model.actor.instance.L2PcInstance;

public class RecipeShopSellList extends L2GameServerPacket
{
	private final L2PcInstance _buyer, _manufacturer;
	
	public RecipeShopSellList(L2PcInstance buyer, L2PcInstance manufacturer)
	{
		_buyer = buyer;
		_manufacturer = manufacturer;
	}
	
	@Override
	protected final void writeImpl()
	{
		writeC(0xDF);
		writeD(_manufacturer.getObjectId());
		writeD((int) _manufacturer.getCurrentMp());// Creator's MP
		writeD(_manufacturer.getMaxMp());// Creator's MP
		writeQ(_buyer.getAdena());// Buyer Adena
		if (!_manufacturer.hasManufactureShop())
		{
			writeD(0x00);
		}
		else
		{
			writeD(_manufacturer.getManufactureItems().size());
			for (L2ManufactureItem temp : _manufacturer.getManufactureItems().values())
			{
				writeD(temp.getRecipeId());
				writeD(0x00); // unknown
				writeQ(temp.getCost());
			}
		}
	}
}
