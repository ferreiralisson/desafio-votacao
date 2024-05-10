package br.com.dbserver.voting.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CpfValidationResponseDTO(String status) {
}
