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
package org.l2jdevs.gameserver.model.zone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import org.l2jdevs.gameserver.enums.GameTime;
import org.l2jdevs.gameserver.enums.InstanceType;
import org.l2jdevs.gameserver.instancemanager.InstanceManager;
import org.l2jdevs.gameserver.model.L2Object;
import org.l2jdevs.gameserver.model.actor.L2Character;
import org.l2jdevs.gameserver.model.actor.instance.L2PcInstance;
import org.l2jdevs.gameserver.model.events.EventDispatcher;
import org.l2jdevs.gameserver.model.events.ListenersContainer;
import org.l2jdevs.gameserver.model.events.impl.character.OnCreatureZoneEnter;
import org.l2jdevs.gameserver.model.events.impl.character.OnCreatureZoneExit;
import org.l2jdevs.gameserver.model.interfaces.ILocational;
import org.l2jdevs.gameserver.network.serverpackets.L2GameServerPacket;

/**
 * Abstract base class for any zone type handles basic operations.
 * @author durgus
 */
public abstract class L2ZoneType extends ListenersContainer
{
	protected static final Logger _log = Logger.getLogger(L2ZoneType.class.getName());
	
	private final int _id;
	protected L2ZoneForm _zone;
	protected Map<Integer, L2Character> _characterList;
	
	/** Parameters to affect specific characters */
	private boolean _checkAffected = false;
	private String _name = null;
	private int _instanceId = -1;
	private String _instanceTemplate = "";
	private int _minLvl;
	private int _maxLvl;
	private int[] _race;
	private int[] _class;
	private char _classType;
	private InstanceType _target = InstanceType.L2Character; // default all chars
	private boolean _allowStore;
	private boolean _enabled;
	private AbstractZoneSettings _settings;
	
	private GameTime _gameTime = GameTime.NONE;
	
	protected L2ZoneType(int id)
	{
		_id = id;
		_characterList = new ConcurrentHashMap<>();
		
		_minLvl = 0;
		_maxLvl = 0xFF;
		
		_classType = 0;
		
		_race = null;
		_class = null;
		_allowStore = true;
		_enabled = true;
	}
	
	/**
	 * Broadcasts packet to all players inside the zone
	 * @param packet
	 */
	public void broadcastPacket(L2GameServerPacket packet)
	{
		if (_characterList.isEmpty())
		{
			return;
		}
		
		for (L2Character character : _characterList.values())
		{
			if ((character != null) && character.isPlayer())
			{
				character.sendPacket(packet);
			}
		}
	}
	
	public boolean getAllowStore()
	{
		return _allowStore;
	}
	
	public Map<Integer, L2Character> getCharacters()
	{
		return _characterList;
	}
	
	public Collection<L2Character> getCharactersInside()
	{
		return _characterList.values();
	}
	
	public double getDistanceToZone(int x, int y)
	{
		return getZone().getDistanceToZone(x, y);
	}
	
	public double getDistanceToZone(L2Object object)
	{
		return getZone().getDistanceToZone(object.getX(), object.getY());
	}
	
	public GameTime getGameTime()
	{
		return _gameTime;
	}
	
	/**
	 * @return Returns the id.
	 */
	public int getId()
	{
		return _id;
	}
	
	/**
	 * Returns zone instanceId
	 * @return
	 */
	public int getInstanceId()
	{
		return _instanceId;
	}
	
	/**
	 * Returns zone instanceTemplate
	 * @return
	 */
	public String getInstanceTemplate()
	{
		return _instanceTemplate;
	}
	
	/**
	 * Returns zone name
	 * @return
	 */
	public String getName()
	{
		return _name;
	}
	
	public List<L2PcInstance> getPlayersInside()
	{
		List<L2PcInstance> players = new ArrayList<>();
		for (L2Character ch : _characterList.values())
		{
			if ((ch != null) && ch.isPlayer())
			{
				players.add(ch.getActingPlayer());
			}
		}
		
		return players;
	}
	
	public AbstractZoneSettings getSettings()
	{
		return _settings;
	}
	
	public InstanceType getTargetType()
	{
		return _target;
	}
	
	/**
	 * Returns this zones zone form.
	 * @return {@link #_zone}
	 */
	public L2ZoneForm getZone()
	{
		return _zone;
	}
	
	/**
	 * Will scan the zones char list for the character
	 * @param character
	 * @return
	 */
	public boolean isCharacterInZone(L2Character character)
	{
		return _characterList.containsKey(character.getObjectId());
	}
	
	public boolean isEnabled()
	{
		return _enabled;
	}
	
	/**
	 * Checks if the given coordinates are within the zone, ignores instanceId check
	 * @param loc
	 * @return
	 */
	public boolean isInsideZone(ILocational loc)
	{
		return _zone.isInsideZone(loc.getX(), loc.getY(), loc.getZ());
	}
	
	/**
	 * Checks if the given coordinates are within zone's plane
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isInsideZone(int x, int y)
	{
		return _zone.isInsideZone(x, y, _zone.getHighZ());
	}
	
	/**
	 * Checks if the given coordinates are within the zone, ignores instanceId check
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public boolean isInsideZone(int x, int y, int z)
	{
		return _zone.isInsideZone(x, y, z);
	}
	
	/**
	 * Checks if the given coordinates are within the zone and the instanceId used matched the zone's instanceId
	 * @param x
	 * @param y
	 * @param z
	 * @param instanceId
	 * @return
	 */
	public boolean isInsideZone(int x, int y, int z, int instanceId)
	{
		// It will check if coords are within the zone if the given instanceId or
		// the zone's _instanceId are in the multiverse or they match
		if ((_instanceId == -1) || (instanceId == -1) || (_instanceId == instanceId))
		{
			return _zone.isInsideZone(x, y, z);
		}
		
		return false;
	}
	
	/**
	 * Checks if the given object is inside the zone.
	 * @param object
	 * @return
	 */
	public boolean isInsideZone(L2Object object)
	{
		return isInsideZone(object.getX(), object.getY(), object.getZ(), object.getInstanceId());
	}
	
	public void onDieInside(L2Character character)
	{
	}
	
	public void onPlayerLoginInside(L2PcInstance player)
	{
	}
	
	public void onPlayerLogoutInside(L2PcInstance player)
	{
	}
	
	public void onReviveInside(L2Character character)
	{
	}
	
	/**
	 * Force fully removes a character from the zone Should use during teleport / logoff
	 * @param character
	 */
	public void removeCharacter(L2Character character)
	{
		// Was the character inside this zone?
		if (_characterList.containsKey(character.getObjectId()))
		{
			// Notify to scripts.
			EventDispatcher.getInstance().notifyEventAsync(new OnCreatureZoneExit(character, this), this);
			
			// Unregister player.
			_characterList.remove(character.getObjectId());
			
			// Notify Zone implementation.
			onExit(character);
		}
	}
	
	public void revalidateInZone(L2Character character)
	{
		// If the character can't be affected by this zone return
		if (_checkAffected)
		{
			if (!isAffected(character))
			{
				return;
			}
		}
		
		// If the object is inside the zone...
		if (isInsideZone(character))
		{
			// Was the character not yet inside this zone?
			if (!_characterList.containsKey(character.getObjectId()))
			{
				// Notify to scripts.
				EventDispatcher.getInstance().notifyEventAsync(new OnCreatureZoneEnter(character, this), this);
				
				// Register player.
				_characterList.put(character.getObjectId(), character);
				
				// Notify Zone implementation.
				onEnter(character);
			}
		}
		else
		{
			removeCharacter(character);
		}
	}
	
	public void setEnabled(boolean state)
	{
		_enabled = state;
	}
	
	/**
	 * Set the zone instanceId.
	 * @param instanceId
	 */
	public void setInstanceId(int instanceId)
	{
		_instanceId = instanceId;
	}
	
	/**
	 * Set the zone name.
	 * @param name
	 */
	public void setName(String name)
	{
		_name = name;
	}
	
	/**
	 * Setup new parameters for this zone
	 * @param name
	 * @param value
	 */
	public void setParameter(String name, String value)
	{
		_checkAffected = true;
		
		// Zone name
		if (name.equals("name"))
		{
			_name = value;
		}
		else if (name.equals("instanceId"))
		{
			_instanceId = Integer.parseInt(value);
		}
		else if (name.equals("instanceTemplate"))
		{
			_instanceTemplate = value;
			_instanceId = InstanceManager.getInstance().createDynamicInstance(value);
		}
		// Minimum level
		else if (name.equals("affectedLvlMin"))
		{
			_minLvl = Integer.parseInt(value);
		}
		// Maximum level
		else if (name.equals("affectedLvlMax"))
		{
			_maxLvl = Integer.parseInt(value);
		}
		// Affected Races
		else if (name.equals("affectedRace"))
		{
			// Create a new array holding the affected race
			if (_race == null)
			{
				_race = new int[1];
				_race[0] = Integer.parseInt(value);
			}
			else
			{
				int[] temp = new int[_race.length + 1];
				
				int i = 0;
				for (; i < _race.length; i++)
				{
					temp[i] = _race[i];
				}
				
				temp[i] = Integer.parseInt(value);
				
				_race = temp;
			}
		}
		// Affected classes
		else if (name.equals("affectedClassId"))
		{
			// Create a new array holding the affected classIds
			if (_class == null)
			{
				_class = new int[1];
				_class[0] = Integer.parseInt(value);
			}
			else
			{
				int[] temp = new int[_class.length + 1];
				
				int i = 0;
				for (; i < _class.length; i++)
				{
					temp[i] = _class[i];
				}
				
				temp[i] = Integer.parseInt(value);
				
				_class = temp;
			}
		}
		// Affected class type
		else if (name.equals("affectedClassType"))
		{
			if (value.equals("Fighter"))
			{
				_classType = 1;
			}
			else
			{
				_classType = 2;
			}
		}
		else if (name.equals("targetClass"))
		{
			_target = Enum.valueOf(InstanceType.class, value);
		}
		else if (name.equals("allowStore"))
		{
			_allowStore = Boolean.parseBoolean(value);
		}
		else if (name.equals("default_enabled"))
		{
			_enabled = Boolean.parseBoolean(value);
		}
		else if (name.equals("time"))
		{
			_gameTime = Enum.valueOf(GameTime.class, value);
		}
		else
		{
			_log.info(getClass().getSimpleName() + ": Unknown parameter - " + name + " in zone: " + getId());
		}
	}
	
	public void setSettings(AbstractZoneSettings settings)
	{
		if (_settings != null)
		{
			_settings.clear();
		}
		_settings = settings;
	}
	
	public void setTargetType(InstanceType type)
	{
		_target = type;
		_checkAffected = true;
	}
	
	/**
	 * Set the zone for this L2ZoneType Instance
	 * @param zone
	 */
	public void setZone(L2ZoneForm zone)
	{
		if (_zone != null)
		{
			throw new IllegalStateException("Zone already set");
		}
		_zone = zone;
	}
	
	@Override
	public String toString()
	{
		return getClass().getSimpleName() + "[" + _id + "]";
	}
	
	public void visualizeZone(int z)
	{
		getZone().visualizeZone(z);
	}
	
	protected abstract void onEnter(L2Character character);
	
	protected abstract void onExit(L2Character character);
	
	/**
	 * @param character the player to verify.
	 * @return {@code true} if the given character is affected by this zone, {@code false} otherwise.
	 */
	private boolean isAffected(L2Character character)
	{
		// Check lvl
		if ((character.getLevel() < _minLvl) || (character.getLevel() > _maxLvl))
		{
			return false;
		}
		
		// check obj class
		if (!character.isInstanceTypes(_target))
		{
			return false;
		}
		
		if (character instanceof L2PcInstance)
		{
			// Check class type
			if (_classType != 0)
			{
				if (((L2PcInstance) character).isMageClass())
				{
					if (_classType == 1)
					{
						return false;
					}
				}
				else if (_classType == 2)
				{
					return false;
				}
			}
			
			// Check race
			if (_race != null)
			{
				boolean ok = false;
				
				for (int element : _race)
				{
					if (character.getRace().ordinal() == element)
					{
						ok = true;
						break;
					}
				}
				
				if (!ok)
				{
					return false;
				}
			}
			
			// Check class
			if (_class != null)
			{
				boolean ok = false;
				
				for (int _clas : _class)
				{
					if (((L2PcInstance) character).getClassId().ordinal() == _clas)
					{
						ok = true;
						break;
					}
				}
				
				if (!ok)
				{
					return false;
				}
			}
		}
		return true;
	}
}