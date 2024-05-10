package br.com.dbserver.voting.dtos.votingsession;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record VotingSessionRequestDTO (
        @NotBlank(message = "Id da pauta nao pode estar em branco")  String scheduleId,
        String votingEndTime
) implements Serializable { }
