/*
 * This file is part of the L2J Mobius project.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jmobius.gameserver.model.cubic.conditions;

import com.l2jmobius.gameserver.model.actor.L2Character;
import com.l2jmobius.gameserver.model.cubic.CubicInstance;

/**
 * @author UnAfraid
 */
public class HpCondition implements ICubicCondition
{
	private final HpConditionType _type;
	private final int _hpPer;
	
	public HpCondition(HpConditionType type, int hpPer)
	{
		_type = type;
		_hpPer = hpPer;
	}
	
	@Override
	public boolean test(CubicInstance cubic, L2Character owner, L2Character target)
	{
		final double hpPer = target.getCurrentHpPercent();
		switch (_type)
		{
			case GREATER:
			{
				return hpPer > _hpPer;
			}
			case LESSER:
			{
				return hpPer < _hpPer;
			}
		}
		return true;
	}
	
	@Override
	public String toString()
	{
		return getClass().getSimpleName() + " chance: " + _hpPer;
	}
	
	public static enum HpConditionType
	{
		GREATER,
		LESSER;
	}
}
