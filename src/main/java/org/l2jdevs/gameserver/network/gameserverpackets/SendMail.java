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
package org.l2jdevs.gameserver.network.gameserverpackets;

import org.l2jdevs.util.network.BaseSendablePacket;

/**
 * @author mrTJO
 */
public class SendMail extends BaseSendablePacket
{
	public SendMail(String accountName, String mailId, String... args)
	{
		writeC(0x09);
		writeS(accountName);
		writeS(mailId);
		writeC(args.length);
		for (String arg : args)
		{
			writeS(arg);
		}
	}
	
	@Override
	public byte[] getContent()
	{
		return getBytes();
	}
}
