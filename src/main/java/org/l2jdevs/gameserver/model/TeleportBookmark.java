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
package org.l2jdevs.gameserver.model;

/**
 * @author UnAfraid
 */
public class TeleportBookmark extends Location
{
	private final int _id;
	private int _icon;
	private String _name, _tag;
	
	public TeleportBookmark(int id, int x, int y, int z, int icon, String tag, String name)
	{
		super(x, y, z);
		_id = id;
		_icon = icon;
		_name = name;
		_tag = tag;
	}
	
	public int getIcon()
	{
		return _icon;
	}
	
	public int getId()
	{
		return _id;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public String getTag()
	{
		return _tag;
	}
	
	public void setIcon(int icon)
	{
		_icon = icon;
	}
	
	public void setName(String name)
	{
		_name = name;
	}
	
	public void setTag(String tag)
	{
		_tag = tag;
	}
}
