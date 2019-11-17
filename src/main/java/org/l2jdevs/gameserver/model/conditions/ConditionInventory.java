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
package org.l2jdevs.gameserver.model.conditions;

import org.l2jdevs.gameserver.model.actor.L2Character;
import org.l2jdevs.gameserver.model.items.L2Item;
import org.l2jdevs.gameserver.model.skills.Skill;

/**
 * The Class ConditionInventory.
 * @author mkizub
 */
public abstract class ConditionInventory extends Condition
{
	
	protected final int _slot;
	
	/**
	 * Instantiates a new condition inventory.
	 * @param slot the slot
	 */
	public ConditionInventory(int slot)
	{
		_slot = slot;
	}
	
	/**
	 * Test impl.
	 * @return true, if successful
	 */
	@Override
	public abstract boolean testImpl(L2Character effector, L2Character effected, Skill skill, L2Item item);
}
