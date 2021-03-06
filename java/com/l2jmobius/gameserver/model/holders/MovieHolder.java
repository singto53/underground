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
package com.l2jmobius.gameserver.model.holders;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.l2jmobius.gameserver.enums.Movie;
import com.l2jmobius.gameserver.model.actor.instance.L2PcInstance;

/**
 * @author St3eT
 */
public final class MovieHolder
{
	private final Movie _movie;
	private final List<L2PcInstance> _players;
	private final List<L2PcInstance> _votedPlayers = new CopyOnWriteArrayList<>();
	
	public MovieHolder(List<L2PcInstance> players, Movie movie)
	{
		_players = players;
		_movie = movie;
		
		getPlayers().forEach(p -> p.playMovie(this));
	}
	
	public Movie getMovie()
	{
		return _movie;
	}
	
	public void playerEscapeVote(L2PcInstance player)
	{
		if (getVotedPlayers().contains(player) || !getPlayers().contains(player) || !getMovie().isEscapable())
		{
			return;
		}
		
		getVotedPlayers().add(player);
		
		if (((getVotedPlayers().size() * 100) / getPlayers().size()) >= 50)
		{
			getPlayers().forEach(L2PcInstance::stopMovie);
		}
	}
	
	public List<L2PcInstance> getPlayers()
	{
		return _players;
	}
	
	public List<L2PcInstance> getVotedPlayers()
	{
		return _votedPlayers;
	}
}