package com.example.practice.mysite.domain.team.dto;

import com.example.practice.mysite.domain.team.Team;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TeamRequestDto {

    @NotBlank
    private String teamName;

    public Team toEntity(){
        return Team.builder()
                .teamName(this.teamName)
                .build();
    }

}
