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
package org.l2jdevs.gameserver.model.actor;

import java.util.Collection;

import org.l2jdevs.gameserver.enums.InstanceType;
import org.l2jdevs.gameserver.model.actor.instance.L2PcInstance;
import org.l2jdevs.gameserver.model.actor.templates.L2CharTemplate;
import org.l2jdevs.gameserver.model.actor.templates.L2NpcTemplate;
import org.l2jdevs.gameserver.model.items.L2Weapon;
import org.l2jdevs.gameserver.model.items.instance.L2ItemInstance;
import org.l2jdevs.gameserver.network.SystemMessageId;
import org.l2jdevs.gameserver.network.serverpackets.CharInfo;
import org.l2jdevs.gameserver.network.serverpackets.L2GameServerPacket;
import org.l2jdevs.gameserver.taskmanager.DecayTaskManager;

public abstract class L2Decoy extends L2Character
{
	private final L2PcInstance _owner;
	
	/**
	 * Creates an abstract decoy.
	 * @param template the decoy template
	 * @param owner the owner
	 */
	public L2Decoy(L2CharTemplate template, L2PcInstance owner)
	{
		super(template);
		setInstanceType(InstanceType.L2Decoy);
		_owner = owner;
		setXYZInvisible(owner.getX(), owner.getY(), owner.getZ());
		setIsInvul(false);
	}
	
	public void deleteMe(L2PcInstance owner)
	{
		decayMe();
		getKnownList().removeAllKnownObjects();
		owner.setDecoy(null);
	}
	
	@Override
	public L2PcInstance getActingPlayer()
	{
		return _owner;
	}
	
	@Override
	public L2ItemInstance getActiveWeaponInstance()
	{
		return null;
	}
	
	@Override
	public L2Weapon getActiveWeaponItem()
	{
		return null;
	}
	
	@Override
	public final int getId()
	{
		return getTemplate().getId();
	}
	
	@Override
	public int getLevel()
	{
		return getTemplate().getLevel();
	}
	
	public final L2PcInstance getOwner()
	{
		return _owner;
	}
	
	@Override
	public L2ItemInstance getSecondaryWeaponInstance()
	{
		return null;
	}
	
	@Override
	public L2Weapon getSecondaryWeaponItem()
	{
		return null;
	}
	
	@Override
	public L2NpcTemplate getTemplate()
	{
		return (L2NpcTemplate) super.getTemplate();
	}
	
	@Override
	public boolean isAutoAttackable(L2Character attacker)
	{
		return _owner.isAutoAttackable(attacker);
	}
	
	@Override
	public void onDecay()
	{
		deleteMe(_owner);
	}
	
	@Override
	public void onSpawn()
	{
		super.onSpawn();
		sendPacket(new CharInfo(this));
	}
	
	@Override
	public void sendInfo(L2PcInstance activeChar)
	{
		activeChar.sendPacket(new CharInfo(this));
	}
	
	@Override
	public void sendPacket(L2GameServerPacket mov)
	{
		if (getOwner() != null)
		{
			getOwner().sendPacket(mov);
		}
	}
	
	@Override
	public void sendPacket(SystemMessageId id)
	{
		if (getOwner() != null)
		{
			getOwner().sendPacket(id);
		}
	}
	
	public void stopDecay()
	{
		DecayTaskManager.getInstance().cancel(this);
	}
	
	public synchronized void unSummon(L2PcInstance owner)
	{
		
		if (isVisible() && !isDead())
		{
			if (getWorldRegion() != null)
			{
				getWorldRegion().removeFromZones(this);
			}
			owner.setDecoy(null);
			decayMe();
			getKnownList().removeAllKnownObjects();
		}
	}
	
	@Override
	public void updateAbnormalEffect()
	{
		Collection<L2PcInstance> plrs = getKnownList().getKnownPlayers().values();
		
		for (L2PcInstance player : plrs)
		{
			if (player != null)
			{
				player.sendPacket(new CharInfo(this));
			}
		}
	}
}
