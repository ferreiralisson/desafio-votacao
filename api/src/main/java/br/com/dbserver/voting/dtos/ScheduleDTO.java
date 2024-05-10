package br.com.dbserver.voting.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ScheduleDTO(Integer id, @NotBlank(message = "Titulo da pauta nao pode estar em branco") String title) implements Serializable {

}
