package com.worker.Service;

import java.util.List;

import com.worker.Payload.TeamDto;

public interface TeamService {

	TeamDto createTeam(TeamDto teamdto ,long workerId);
	TeamDto getTeamByWorkerId(long workerId);
	TeamDto updateTeam(TeamDto teamdto ,long Id);
	TeamDto getById(long Id);
	List<TeamDto> getAll();
	void deleteWorker(long Id);
}
