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
package org.l2jdevs.gameserver.data.xml.impl;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import org.l2jdevs.gameserver.model.StatsSet;
import org.l2jdevs.gameserver.model.fishing.L2FishingRod;
import org.l2jdevs.util.data.xml.IXmlReader;

/**
 * This class holds the Fishing Rods information.
 * @author nonom
 */
public final class FishingRodsData implements IXmlReader
{
	private final Map<Integer, L2FishingRod> _fishingRods = new HashMap<>();
	
	/**
	 * Instantiates a new fishing rods data.
	 */
	protected FishingRodsData()
	{
		load();
	}
	
	/**
	 * Gets the single instance of FishingRodsData.
	 * @return single instance of FishingRodsData
	 */
	public static FishingRodsData getInstance()
	{
		return SingletonHolder._instance;
	}
	
	/**
	 * Gets the fishing rod.
	 * @param itemId the item id
	 * @return A fishing Rod by Item Id
	 */
	public L2FishingRod getFishingRod(int itemId)
	{
		return _fishingRods.get(itemId);
	}
	
	@Override
	public void load()
	{
		_fishingRods.clear();
		parseDatapackFile("data/stats/fishing/fishingRods.xml");
		LOG.info("{}: Loaded {} Fishing Rods.", getClass().getSimpleName(), _fishingRods.size());
	}
	
	@Override
	public void parseDocument(Document doc)
	{
		for (Node n = doc.getFirstChild(); n != null; n = n.getNextSibling())
		{
			if ("list".equalsIgnoreCase(n.getNodeName()))
			{
				for (Node d = n.getFirstChild(); d != null; d = d.getNextSibling())
				{
					if ("fishingRod".equalsIgnoreCase(d.getNodeName()))
					{
						final NamedNodeMap attrs = d.getAttributes();
						final StatsSet set = new StatsSet();
						for (int i = 0; i < attrs.getLength(); i++)
						{
							final Node att = attrs.item(i);
							set.set(att.getNodeName(), att.getNodeValue());
						}
						
						final L2FishingRod fishingRod = new L2FishingRod(set);
						_fishingRods.put(fishingRod.getFishingRodItemId(), fishingRod);
					}
				}
			}
		}
	}
	
	private static class SingletonHolder
	{
		protected static final FishingRodsData _instance = new FishingRodsData();
	}
}
