package com.example.practice.mysite.domain.team;

import com.example.practice.mysite.domain.team.dto.TeamRequestDto;
import com.example.practice.mysite.domain.team.dto.TeamResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public TeamResponseDto createTeam(TeamRequestDto teamRequestDto){
        Team team = teamRequestDto.toEntity();

        return TeamResponseDto.from(teamRepository.save(team));
    }

    public List<TeamResponseDto> readTeams(){
        return teamRepository.findAll().stream().map(TeamResponseDto :: from).toList();
    }

    public TeamResponseDto readTeamById(Long teamId){
        Team team = teamRepository.findById(teamId).orElseThrow(()-> new RuntimeException("존재하지 않는 팀입니다."));
        return TeamResponseDto.from(team);
    }

}
