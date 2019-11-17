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
package org.l2jdevs.loginserver.network.gameserverpackets;

import java.util.logging.Logger;

import org.l2jdevs.Config;
import org.l2jdevs.loginserver.GameServerTable;
import org.l2jdevs.loginserver.GameServerThread;
import org.l2jdevs.util.network.BaseRecievePacket;

/**
 * @author -Wooden-
 */
public class PlayerLogout extends BaseRecievePacket
{
	protected static Logger _log = Logger.getLogger(PlayerLogout.class.getName());
	
	/**
	 * @param decrypt
	 * @param server
	 */
	public PlayerLogout(byte[] decrypt, GameServerThread server)
	{
		super(decrypt);
		String account = readS();
		
		server.removeAccountOnGameServer(account);
		if (Config.DEBUG)
		{
			_log.info("Player " + account + " logged out from gameserver [" + server.getServerId() + "] " + GameServerTable.getInstance().getServerNameById(server.getServerId()));
		}
		
		server.broadcastToTelnet("Player " + account + " disconnected from GameServer " + server.getServerId());
	}
}
