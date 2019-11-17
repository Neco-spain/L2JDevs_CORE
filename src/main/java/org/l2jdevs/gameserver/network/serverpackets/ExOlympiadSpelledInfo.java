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
import org.l2jdevs.gameserver.model.skills.BuffInfo;

/**
 * @author godson
 */
public class ExOlympiadSpelledInfo extends L2GameServerPacket
{
	private final int _playerId;
	private final List<BuffInfo> _effects = new ArrayList<>();
	
	public ExOlympiadSpelledInfo(L2PcInstance player)
	{
		_playerId = player.getObjectId();
	}
	
	public void addSkill(BuffInfo info)
	{
		_effects.add(info);
	}
	
	@Override
	protected final void writeImpl()
	{
		writeC(0xFE);
		writeH(0x7B);
		writeD(_playerId);
		writeD(_effects.size());
		for (BuffInfo info : _effects)
		{
			if ((info != null) && info.isInUse())
			{
				writeD(info.getSkill().getDisplayId());
				writeH(info.getSkill().getDisplayLevel());
				writeD(info.getTime());
			}
		}
	}
}
