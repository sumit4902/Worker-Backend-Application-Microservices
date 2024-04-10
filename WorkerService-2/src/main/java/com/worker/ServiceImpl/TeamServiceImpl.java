package com.worker.ServiceImpl;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.worker.Entities.Team;
import com.worker.Entities.Worker;
import com.worker.Payload.TeamDto;
import com.worker.Payload.TeamResponse;
import com.worker.Repositories.TeamRepo;
import com.worker.Repositories.WorkerRepo;
import com.worker.Service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepo teamrepo;
	@Autowired
	private WorkerRepo workerRepo;
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private TeamResponse teamresponse;
	
	
	@Override
	public TeamDto createTeam(TeamDto teamdto,long workerId) {
		
		
		Worker worker = this.workerRepo.findById(workerId).orElseThrow(()-> new RuntimeException("Worker Not Found"));
		
		Team team = this.modelmapper.map(teamdto, Team.class);
		team.setWorker(worker);
		team.setDate(new Date());
	  Team SavedTeam =	this.teamrepo.save(team);
		return this.modelmapper.map(SavedTeam,TeamDto.class);
	}
	
	//  get Team by worker Id
	@Override
	public TeamDto getTeamByWorkerId(long workerId) {
		Worker worker = this.workerRepo.findById(workerId).orElseThrow(()-> new RuntimeException("Worker Not Found"));
		Team team = this.teamrepo.findByWorker(worker);
		return this.modelmapper.map(team, TeamDto.class);
	}
	
	
	
	@Override
	public TeamDto updateTeam(TeamDto teamdto, long Id) {
		Team team = this.teamrepo.findById(Id).orElseThrow(()-> new RuntimeException("Team Not Found "));
		team.setName(teamdto.getName());
		team.setLeaderName(teamdto.getLeaderName());
		team.setTmOne(teamdto.getTmOne());
		team.setTmTwo(teamdto.getTmTwo());
		team.setTmThree(teamdto.getTmThree());
		team.setTmFour(teamdto.getTmFour());
		team.setAddress(teamdto.getAddress());
		team.setExpertise(teamdto.getExpertise());
		team.setExtramember(teamdto.getExtramember());
		team.setRate(teamdto.getRate());
		Team updatedteam = this.teamrepo.save(team);
		return this.modelmapper.map(updatedteam, TeamDto.class);
	}
	
	
	@Override
	public TeamDto getById(long Id) {
		Team team = this.teamrepo.findById(Id).orElseThrow(()-> new RuntimeException("Team Not Found "));
		return this.modelmapper.map(team, TeamDto.class);
	}
	
	
	@Override
	public TeamResponse getAll(String leaderName,String address,String expertise,Integer pageNo,Integer pageSize,String sortBy,String direc) {
		  Pageable p;
		if(direc.equalsIgnoreCase("desc"))
		{
			   p =   PageRequest.of(pageNo, pageSize,Sort.by(sortBy).descending());
		      
		}
		else {
			  p =   PageRequest.of(pageNo, pageSize,Sort.by(sortBy).ascending());
		      
		}
		  Page<Team> teampages = this.teamrepo.findByLeaderNameContainingIgnoreCaseAndAddressContainingIgnoreCaseAndExpertiseContainingIgnoreCase(leaderName,address, expertise, p);
		 List<Team> teams  = teampages.getContent();
     
    List<TeamDto> convertedteam = teams.stream().map((team)-> this.modelmapper.map(team, TeamDto.class)).collect(Collectors.toList());
		 teamresponse.setContent(convertedteam);
		 teamresponse.setPageNo(teampages.getNumber());
		 teamresponse.setPageSize(teampages.getSize());
		 teamresponse.setTotalElements(teampages.getTotalElements());
		 teamresponse.setTotalPages(teampages.getTotalPages());
		 teamresponse.setLastpage(teampages.isLast());
    
       return teamresponse;
	}
	
	
	@Override
	public void deleteWorker(long Id) {
	
		Team team = this.teamrepo.findById(Id).orElseThrow(()-> new RuntimeException("Team Not Found "));
		this.teamrepo.delete(team);
		
	}

	
	
	
	
}
