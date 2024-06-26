package com.worker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.worker.Payload.ApiResponse;
import com.worker.Payload.TeamDto;
import com.worker.Payload.TeamResponse;
import com.worker.Service.TeamService;

@RestController
@RequestMapping("/api/service2")
public class TeamController {

	@Autowired
	private TeamService  teamService;
	
	@PostMapping("/worker/{workerId}/team/create")
	ResponseEntity<TeamDto> createTeam(@RequestBody TeamDto teamdto,@PathVariable long workerId )
	{   
		TeamDto createdteam = this.teamService.createTeam(teamdto,workerId);
		return new ResponseEntity<TeamDto>(createdteam,HttpStatus.CREATED);
	}
	// get team By workerId
	
	@GetMapping("/worker/{workerId}/team")
	ResponseEntity<TeamDto> getTeamByWorkerId(@RequestBody @PathVariable long workerId)
	{
		TeamDto team = this.teamService.getTeamByWorkerId(workerId);
		return new ResponseEntity<TeamDto>(team,HttpStatus.OK);
	}
	
	@PutMapping("/team/update/{Id}")
	ResponseEntity<TeamDto> updateTeam(@RequestBody TeamDto teamdto ,@PathVariable long Id)
	{
		TeamDto updatedTeam = this.teamService.updateTeam(teamdto, Id);
		return new ResponseEntity<TeamDto>(updatedTeam,HttpStatus.OK);
	}
	
	@GetMapping("/team/{Id}")
	ResponseEntity<TeamDto> getById(@RequestBody @PathVariable long Id)
	{
		TeamDto team = this.teamService.getById(Id);
		return new ResponseEntity<TeamDto>(team,HttpStatus.OK);
	}
	
	@GetMapping("/team/all")
	ResponseEntity<TeamResponse> getAllTeam(@RequestBody
			    @RequestParam(name="leaderName",defaultValue="",required = false) String leaderName,
			    @RequestParam(name = "address",defaultValue ="",required = false)String address,
	            @RequestParam(name = "expertise",defaultValue = "",required = false )String expertise,
	
			    @RequestParam(name ="pageNo" ,defaultValue = "0",required = false) int pageNo,
			    @RequestParam(name="pageSize",defaultValue = "10",required = false ) int pageSize,
			    @RequestParam(name ="sortBy",defaultValue = "teamId" ,required = false) String sortBy,
			    @RequestParam(name ="direc",defaultValue = "desc" ,required = false) String direc
				)
	{
		TeamResponse allTeam = this.teamService.getAll(leaderName, address, expertise,pageNo,pageSize, sortBy, direc);
		return new ResponseEntity<TeamResponse>(allTeam,HttpStatus.OK);
	}
	
	@DeleteMapping("/team/delete/{Id}")
	ResponseEntity<ApiResponse> deleteTeam(@RequestBody @PathVariable long Id)
	{
		this.teamService.deleteWorker(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Team Deleted Successfully..",true),HttpStatus.OK);
	}
	
	
}
