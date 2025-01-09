package com.example.practice.mysite.domain.team;

import com.example.practice.mysite.domain.team.dto.TeamRequestDto;
import com.example.practice.mysite.domain.team.dto.TeamResponseDto;
import com.example.practice.mysite.domain.user.User;
import com.example.practice.mysite.domain.user.UserRepository;
import com.example.practice.mysite.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
