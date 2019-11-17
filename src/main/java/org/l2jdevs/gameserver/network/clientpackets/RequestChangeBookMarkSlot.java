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

/**
 * @author ShanSoft Packets Structure: chddd
 */
public final class RequestChangeBookMarkSlot extends L2GameClientPacket
{
	private static final String _C__D0_51_05_REQUESCHANGEBOOKMARKSLOT = "[C] D0:51:05 RequestChangeBookMarkSlot";
	
	@Override
	public String getType()
	{
		return _C__D0_51_05_REQUESCHANGEBOOKMARKSLOT;
	}
	
	@Override
	protected void readImpl()
	{
		// There is nothing to read.
	}
	
	@Override
	protected void runImpl()
	{
		
	}
}
