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
package org.l2jdevs.gameserver.model.stats.functions.formulas;

import java.util.HashMap;
import java.util.Map;

import org.l2jdevs.gameserver.data.xml.impl.ArmorSetsData;
import org.l2jdevs.gameserver.model.L2ArmorSet;
import org.l2jdevs.gameserver.model.actor.L2Character;
import org.l2jdevs.gameserver.model.actor.instance.L2PcInstance;
import org.l2jdevs.gameserver.model.items.instance.L2ItemInstance;
import org.l2jdevs.gameserver.model.skills.Skill;
import org.l2jdevs.gameserver.model.stats.Stats;
import org.l2jdevs.gameserver.model.stats.functions.AbstractFunction;

/**
 * @author UnAfraid
 */
public class FuncArmorSet extends AbstractFunction
{
	private static final Map<Stats, FuncArmorSet> _fh_instance = new HashMap<>();
	
	private FuncArmorSet(Stats stat)
	{
		super(stat, 1, null, 0, null);
	}
	
	public static AbstractFunction getInstance(Stats st)
	{
		if (!_fh_instance.containsKey(st))
		{
			_fh_instance.put(st, new FuncArmorSet(st));
		}
		return _fh_instance.get(st);
	}
	
	@Override
	public double calc(L2Character effector, L2Character effected, Skill skill, double initVal)
	{
		double value = initVal;
		L2PcInstance player = effector.getActingPlayer();
		if (player != null)
		{
			L2ItemInstance chest = player.getChestArmorInstance();
			if (chest != null)
			{
				L2ArmorSet set = ArmorSetsData.getInstance().getSet(chest.getId());
				if ((set != null) && set.containAll(player))
				{
					switch (getStat())
					{
						case STAT_STR:
							value += set.getSTR();
							break;
						case STAT_DEX:
							value += set.getDEX();
							break;
						case STAT_INT:
							value += set.getINT();
							break;
						case STAT_MEN:
							value += set.getMEN();
							break;
						case STAT_CON:
							value += set.getCON();
							break;
						case STAT_WIT:
							value += set.getWIT();
							break;
					}
				}
			}
		}
		return value;
	}
}