package com.worker.Service;

import java.util.List;

import com.worker.Payload.TeamDto;
import com.worker.Payload.TeamResponse;

public interface TeamService {

	TeamDto createTeam(TeamDto teamdto ,long workerId);
	TeamDto getTeamByWorkerId(long workerId);
	TeamDto updateTeam(TeamDto teamdto ,long Id);
	TeamDto getById(long Id);
	
	TeamResponse getAll(String leaderName,String address,String expertise,Integer pageNo,Integer pageSize,String sortBy,String direc);
	void deleteWorker(long Id);
}
