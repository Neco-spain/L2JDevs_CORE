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
package org.l2jdevs.gameserver.model.actor.instance;

import org.l2jdevs.gameserver.ai.L2CharacterAI;
import org.l2jdevs.gameserver.enums.InstanceType;
import org.l2jdevs.gameserver.model.Location;
import org.l2jdevs.gameserver.model.actor.L2Character;
import org.l2jdevs.gameserver.model.actor.knownlist.StaticObjectKnownList;
import org.l2jdevs.gameserver.model.actor.stat.StaticObjStat;
import org.l2jdevs.gameserver.model.actor.status.StaticObjStatus;
import org.l2jdevs.gameserver.model.actor.templates.L2CharTemplate;
import org.l2jdevs.gameserver.model.items.L2Weapon;
import org.l2jdevs.gameserver.model.items.instance.L2ItemInstance;
import org.l2jdevs.gameserver.model.skills.Skill;
import org.l2jdevs.gameserver.network.serverpackets.ShowTownMap;
import org.l2jdevs.gameserver.network.serverpackets.StaticObject;

/**
 * Static Object instance.
 * @author godson
 */
public final class L2StaticObjectInstance extends L2Character
{
	/** The interaction distance of the L2StaticObjectInstance */
	public static final int INTERACTION_DISTANCE = 150;
	
	private final int _staticObjectId;
	private int _meshIndex = 0; // 0 - static objects, alternate static objects
	private int _type = -1; // 0 - map signs, 1 - throne , 2 - arena signs
	private ShowTownMap _map;
	
	/**
	 * Creates a static object.
	 * @param template the static object
	 * @param staticId the static ID
	 */
	public L2StaticObjectInstance(L2CharTemplate template, int staticId)
	{
		super(template);
		setInstanceType(InstanceType.L2StaticObjectInstance);
		_staticObjectId = staticId;
	}
	
	@Override
	public void doAttack(L2Character target)
	{
	}
	
	@Override
	public void doCast(Skill skill)
	{
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
	
	/**
	 * Gets the static object ID.
	 * @return the static object ID
	 */
	@Override
	public int getId()
	{
		return _staticObjectId;
	}
	
	@Override
	public final StaticObjectKnownList getKnownList()
	{
		return (StaticObjectKnownList) super.getKnownList();
	}
	
	@Override
	public final int getLevel()
	{
		return 1;
	}
	
	public ShowTownMap getMap()
	{
		return _map;
	}
	
	/**
	 * <B><U> Values </U> :</B>
	 * <ul>
	 * <li>default textures : 0</li>
	 * <li>alternate textures : 1</li>
	 * </ul>
	 * @return the meshIndex of the object
	 */
	public int getMeshIndex()
	{
		return _meshIndex;
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
	public final StaticObjStat getStat()
	{
		return (StaticObjStat) super.getStat();
	}
	
	@Override
	public final StaticObjStatus getStatus()
	{
		return (StaticObjStatus) super.getStatus();
	}
	
	public int getType()
	{
		return _type;
	}
	
	@Override
	public void initCharStat()
	{
		setStat(new StaticObjStat(this));
	}
	
	@Override
	public void initCharStatus()
	{
		setStatus(new StaticObjStatus(this));
	}
	
	@Override
	public void initKnownList()
	{
		setKnownList(new StaticObjectKnownList(this));
	}
	
	@Override
	public boolean isAutoAttackable(L2Character attacker)
	{
		return false;
	}
	
	@Override
	public void moveToLocation(int x, int y, int z, int offset)
	{
	}
	
	@Override
	public void sendInfo(L2PcInstance activeChar)
	{
		activeChar.sendPacket(new StaticObject(this));
	}
	
	public void setMap(String texture, int x, int y)
	{
		_map = new ShowTownMap("town_map." + texture, x, y);
	}
	
	/**
	 * Set the meshIndex of the object.<br>
	 * <B><U> Values </U> :</B>
	 * <ul>
	 * <li>default textures : 0</li>
	 * <li>alternate textures : 1</li>
	 * </ul>
	 * @param meshIndex
	 */
	public void setMeshIndex(int meshIndex)
	{
		_meshIndex = meshIndex;
		this.broadcastPacket(new StaticObject(this));
	}
	
	public void setType(int type)
	{
		_type = type;
	}
	
	@Override
	public void stopMove(Location loc)
	{
	}
	
	@Override
	public void updateAbnormalEffect()
	{
	}
	
	@Override
	protected L2CharacterAI initAI()
	{
		return null;
	}
}
