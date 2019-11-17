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

import org.l2jdevs.gameserver.model.interfaces.IUniqueId;

/**
 * @author xban1x
 */
public final class AbsorberInfo implements IUniqueId
{
	private int _objectId;
	private double _absorbedHp;
	
	public AbsorberInfo(int objectId, double pAbsorbedHp)
	{
		_objectId = objectId;
		_absorbedHp = pAbsorbedHp;
	}
	
	@Override
	public final boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		
		if (obj instanceof AbsorberInfo)
		{
			return (((AbsorberInfo) obj).getObjectId() == _objectId);
		}
		
		return false;
	}
	
	public double getAbsorbedHp()
	{
		return _absorbedHp;
	}
	
	@Override
	public int getObjectId()
	{
		return _objectId;
	}
	
	@Override
	public final int hashCode()
	{
		return _objectId;
	}
	
	public void setAbsorbedHp(double absorbedHp)
	{
		_absorbedHp = absorbedHp;
	}
	
	public void setObjectId(int objectId)
	{
		_objectId = objectId;
	}
}
