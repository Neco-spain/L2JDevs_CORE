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
package org.l2jdevs.gameserver.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.l2jdevs.Config;
import org.l2jdevs.gameserver.enums.Race;
import org.l2jdevs.util.Rnd;

/**
 * @author Nyaran
 */
public class L2MapRegion
{
	private final String _name;
	private final String _town;
	private final int _locId;
	private final int _castle;
	private final int _bbs;
	private List<int[]> _maps = null;
	
	private List<Location> _spawnLocs = null;
	private List<Location> _otherSpawnLocs = null;
	private List<Location> _chaoticSpawnLocs = null;
	private List<Location> _banishSpawnLocs = null;
	
	private final Map<Race, String> _bannedRace = new HashMap<>();
	
	public L2MapRegion(String name, String town, int locId, int castle, int bbs)
	{
		_name = name;
		_town = town;
		_locId = locId;
		_castle = castle;
		_bbs = bbs;
	}
	
	public final void addBanishSpawn(int x, int y, int z)
	{
		if (_banishSpawnLocs == null)
		{
			_banishSpawnLocs = new ArrayList<>();
		}
		
		_banishSpawnLocs.add(new Location(x, y, z));
	}
	
	public final void addBannedRace(String race, String point)
	{
		_bannedRace.put(Race.valueOf(race), point);
	}
	
	public final void addChaoticSpawn(int x, int y, int z)
	{
		if (_chaoticSpawnLocs == null)
		{
			_chaoticSpawnLocs = new ArrayList<>();
		}
		
		_chaoticSpawnLocs.add(new Location(x, y, z));
	}
	
	public final void addMap(int x, int y)
	{
		if (_maps == null)
		{
			_maps = new ArrayList<>();
		}
		
		_maps.add(new int[]
		{
			x,
			y
		});
	}
	
	public final void addOtherSpawn(int x, int y, int z)
	{
		if (_otherSpawnLocs == null)
		{
			_otherSpawnLocs = new ArrayList<>();
		}
		
		_otherSpawnLocs.add(new Location(x, y, z));
	}
	
	// Respawn
	public final void addSpawn(int x, int y, int z)
	{
		if (_spawnLocs == null)
		{
			_spawnLocs = new ArrayList<>();
		}
		
		_spawnLocs.add(new Location(x, y, z));
	}
	
	public final Location getBanishSpawnLoc()
	{
		if (_banishSpawnLocs != null)
		{
			if (Config.RANDOM_RESPAWN_IN_TOWN_ENABLED)
			{
				return _banishSpawnLocs.get(Rnd.get(_banishSpawnLocs.size()));
			}
			return _banishSpawnLocs.get(0);
		}
		return getSpawnLoc();
	}
	
	public final Map<Race, String> getBannedRace()
	{
		return _bannedRace;
	}
	
	public final int getBbs()
	{
		return _bbs;
	}
	
	public final int getCastle()
	{
		return _castle;
	}
	
	public final Location getChaoticSpawnLoc()
	{
		if (_chaoticSpawnLocs != null)
		{
			if (Config.RANDOM_RESPAWN_IN_TOWN_ENABLED)
			{
				return _chaoticSpawnLocs.get(Rnd.get(_chaoticSpawnLocs.size()));
			}
			return _chaoticSpawnLocs.get(0);
		}
		return getSpawnLoc();
	}
	
	public final int getLocId()
	{
		return _locId;
	}
	
	public final List<int[]> getMaps()
	{
		return _maps;
	}
	
	public final String getName()
	{
		return _name;
	}
	
	public final Location getOtherSpawnLoc()
	{
		if (_otherSpawnLocs != null)
		{
			if (Config.RANDOM_RESPAWN_IN_TOWN_ENABLED)
			{
				return _otherSpawnLocs.get(Rnd.get(_otherSpawnLocs.size()));
			}
			return _otherSpawnLocs.get(0);
		}
		return getSpawnLoc();
	}
	
	public final Location getSpawnLoc()
	{
		if (Config.RANDOM_RESPAWN_IN_TOWN_ENABLED)
		{
			return _spawnLocs.get(Rnd.get(_spawnLocs.size()));
		}
		return _spawnLocs.get(0);
	}
	
	public final List<Location> getSpawns()
	{
		return _spawnLocs;
	}
	
	public final String getTown()
	{
		return _town;
	}
	
	public final boolean isZoneInRegion(int x, int y)
	{
		if (_maps == null)
		{
			return false;
		}
		
		for (int[] map : _maps)
		{
			if ((map[0] == x) && (map[1] == y))
			{
				return true;
			}
		}
		return false;
	}
}
