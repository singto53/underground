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
package com.l2jmobius.gameserver.network.serverpackets.adenadistribution;

import com.l2jmobius.commons.network.PacketWriter;
import com.l2jmobius.gameserver.network.client.OutgoingPackets;
import com.l2jmobius.gameserver.network.serverpackets.IClientOutgoingPacket;

/**
 * @author Sdw
 */
public class ExDivideAdenaStart implements IClientOutgoingPacket
{
	public static final ExDivideAdenaStart STATIC_PACKET = new ExDivideAdenaStart();
	
	private ExDivideAdenaStart()
	{
	}
	
	@Override
	public boolean write(PacketWriter packet)
	{
		OutgoingPackets.EX_DIVIDE_ADENA_START.writeId(packet);
		return true;
	}
}