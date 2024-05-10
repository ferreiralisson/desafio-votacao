package br.com.dbserver.voting.dtos.vote;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record VoteRequestDTO(@NotBlank(message = "Id da sessao de votacao nao pode estar em branco")  String idSessionVoting,
                             @NotBlank(message = "CPF nao pode estar em branco") String cpf,
                             @NotBlank(message = "Voto nao pode estar em branco") String vote) implements Serializable {
}
