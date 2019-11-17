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
package org.l2jdevs.gameserver.handler;

/**
 * Handler Interface.
 * @author UnAfraid
 * @author Zoey76
 * @param <K>
 * @param <V>
 */
public interface IHandler<K, V>
{
	public K getHandler(V val);
	
	public void registerHandler(K object);
	
	public void removeHandler(K handler);
	
	public int size();
	
	@SuppressWarnings("unchecked")
	default void registerByClass(Class<?> clazz) throws Exception
	{
		final Object object = clazz.getDeclaredConstructor().newInstance();
		registerHandler((K) object);
	}
}
