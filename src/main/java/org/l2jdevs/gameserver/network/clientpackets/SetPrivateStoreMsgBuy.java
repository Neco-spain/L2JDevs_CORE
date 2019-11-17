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
package org.l2jdevs.gameserver.network.clientpackets;

import org.l2jdevs.Config;
import org.l2jdevs.gameserver.model.actor.instance.L2PcInstance;
import org.l2jdevs.gameserver.network.serverpackets.PrivateStoreMsgBuy;
import org.l2jdevs.gameserver.util.Util;

/**
 * This class ...
 * @version $Revision: 1.2.4.2 $ $Date: 2005/03/27 15:29:30 $
 */
public final class SetPrivateStoreMsgBuy extends L2GameClientPacket
{
	private static final String _C__9D_SETPRIVATESTOREMSGBUY = "[C] 9D SetPrivateStoreMsgBuy";
	
	private static final int MAX_MSG_LENGTH = 29;
	
	private String _storeMsg;
	
	@Override
	public String getType()
	{
		return _C__9D_SETPRIVATESTOREMSGBUY;
	}
	
	@Override
	protected void readImpl()
	{
		_storeMsg = readS();
	}
	
	@Override
	protected void runImpl()
	{
		final L2PcInstance player = getClient().getActiveChar();
		if ((player == null) || (player.getBuyList() == null))
		{
			return;
		}
		
		if ((_storeMsg != null) && (_storeMsg.length() > MAX_MSG_LENGTH))
		{
			Util.handleIllegalPlayerAction(player, "Player " + player.getName() + " tried to overflow private store buy message", Config.DEFAULT_PUNISH);
			return;
		}
		
		player.getBuyList().setTitle(_storeMsg);
		player.sendPacket(new PrivateStoreMsgBuy(player));
	}
}
