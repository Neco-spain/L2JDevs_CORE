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
package org.l2jdevs.gameserver.model.items.enchant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.l2jdevs.gameserver.model.items.L2Item;

/**
 * @author UnAfraid
 */
public final class EnchantScrollGroup
{
	private final int _id;
	private List<EnchantRateItem> _rateGroups;
	
	public EnchantScrollGroup(int id)
	{
		_id = id;
	}
	
	/**
	 * Adds new rate group.
	 * @param group
	 */
	public void addRateGroup(EnchantRateItem group)
	{
		if (_rateGroups == null)
		{
			_rateGroups = new ArrayList<>();
		}
		_rateGroups.add(group);
	}
	
	/**
	 * @return id of current enchant scroll group.
	 */
	public int getId()
	{
		return _id;
	}
	
	/**
	 * @param item
	 * @return {@link EnchantRateItem}, {@code NULL} in case non of rate items can be used with.
	 */
	public EnchantRateItem getRateGroup(L2Item item)
	{
		for (EnchantRateItem group : getRateGroups())
		{
			if (group.validate(item))
			{
				return group;
			}
		}
		return null;
	}
	
	/**
	 * @return {@code List} of all enchant rate items, Empty list if none.
	 */
	public List<EnchantRateItem> getRateGroups()
	{
		return _rateGroups != null ? _rateGroups : Collections.<EnchantRateItem> emptyList();
	}
}
