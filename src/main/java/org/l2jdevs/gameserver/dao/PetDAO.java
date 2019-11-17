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
package org.l2jdevs.gameserver.dao;

import org.l2jdevs.gameserver.model.actor.instance.L2PcInstance;
import org.l2jdevs.gameserver.model.actor.instance.L2PetInstance;
import org.l2jdevs.gameserver.model.actor.templates.L2NpcTemplate;
import org.l2jdevs.gameserver.model.items.instance.L2ItemInstance;

/**
 * Pet DAO interface.
 * @author Zoey76
 */
public interface PetDAO
{
	/**
	 * Deletes a pet by item object ID.
	 * @param pet the pet
	 */
	void delete(L2PetInstance pet);
	
	/**
	 * Stores a pet into the database.
	 * @param pet the pet
	 */
	void insert(L2PetInstance pet);
	
	/**
	 * Restores a pet from the database.
	 * @param control the summoning item
	 * @param template the NPC template
	 * @param owner the owner
	 * @return the pet
	 */
	L2PetInstance load(L2ItemInstance control, L2NpcTemplate template, L2PcInstance owner);
	
	/**
	 * Updates a pet in the database.
	 * @param pet the pet
	 */
	void update(L2PetInstance pet);
	
	void updateFood(L2PcInstance player, int petId);
}
