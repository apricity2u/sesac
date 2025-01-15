package com.example.practice.mysite.domain.team;

import com.example.practice.mysite.global.ApiResponse;
import com.example.practice.mysite.domain.team.dto.TeamRequestDto;
import com.example.practice.mysite.domain.team.dto.TeamResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    // 1. Team 만들기
    @PostMapping
    public ResponseEntity<ApiResponse<TeamResponseDto>> createTeam(@Valid @RequestBody TeamRequestDto requestDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                    ApiResponse.ok(
                        "팀이 정상적으로 생성되었습니다.",
                        "CREATED",
                        teamService.createTeam(requestDto)
                ));
    }

    // 2. Team 조회하기
    @GetMapping
    public ResponseEntity<ApiResponse<List<TeamResponseDto>>> readTeams(){
        return ResponseEntity.ok(ApiResponse.ok(teamService.readTeams()));
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<ApiResponse<TeamResponseDto>> readTeamById(@PathVariable Long teamId){
        return ResponseEntity.ok(ApiResponse.ok(teamService.readTeamById(teamId)));
    }

    // 3. Team 수정하기
    @PutMapping("/{teamId}")
    public type update


}
