/*
 * Copyright © 2004-2019 L2J Server
 * 
 * This file is part of L2J Server.
 * 
 * L2J Server is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * L2J Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.l2jdevs.gameserver.network.clientpackets;

import org.l2jdevs.gameserver.data.xml.impl.SecondaryAuthData;
import org.l2jdevs.gameserver.network.serverpackets.Ex2ndPasswordCheck;

/**
 * Format: (ch)
 * @author mrTJO
 */
public class RequestEx2ndPasswordCheck extends L2GameClientPacket
{
	private static final String _C__D0_AD_REQUESTEX2NDPASSWORDCHECK = "[C] D0:AD RequestEx2ndPasswordCheck";
	
	@Override
	public String getType()
	{
		return _C__D0_AD_REQUESTEX2NDPASSWORDCHECK;
	}
	
	@Override
	protected void readImpl()
	{
		
	}
	
	@Override
	protected void runImpl()
	{
		if (!SecondaryAuthData.getInstance().isEnabled() || getClient().getSecondaryAuth().isAuthed())
		{
			sendPacket(new Ex2ndPasswordCheck(Ex2ndPasswordCheck.PASSWORD_OK));
			return;
		}
		
		getClient().getSecondaryAuth().openDialog();
	}
}
