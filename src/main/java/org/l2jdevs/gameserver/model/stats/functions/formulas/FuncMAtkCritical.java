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
package org.l2jdevs.gameserver.model.stats.functions.formulas;

import org.l2jdevs.gameserver.model.actor.L2Character;
import org.l2jdevs.gameserver.model.skills.Skill;
import org.l2jdevs.gameserver.model.stats.BaseStats;
import org.l2jdevs.gameserver.model.stats.Stats;
import org.l2jdevs.gameserver.model.stats.functions.AbstractFunction;

/**
 * @author UnAfraid
 */
public class FuncMAtkCritical extends AbstractFunction
{
	private static final FuncMAtkCritical _fac_instance = new FuncMAtkCritical();
	
	private FuncMAtkCritical()
	{
		super(Stats.MCRITICAL_RATE, 1, null, 0, null);
	}
	
	public static AbstractFunction getInstance()
	{
		return _fac_instance;
	}
	
	@Override
	public double calc(L2Character effector, L2Character effected, Skill skill, double initVal)
	{
		// CT2: The magic critical rate has been increased to 10 times.
		if (!effector.isPlayer() || (effector.getActiveWeaponInstance() != null))
		{
			return initVal * BaseStats.WIT.calcBonus(effector) * 10;
		}
		return initVal;
	}
}