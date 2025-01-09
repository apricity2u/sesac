package com.example.practice.mysite.domain.team;

import com.example.practice.mysite.ApiResponse;
import com.example.practice.mysite.domain.team.dto.TeamRequestDto;
import com.example.practice.mysite.domain.team.dto.TeamResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
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

}
