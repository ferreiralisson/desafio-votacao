package br.com.dbserver.voting.dtos.associate;

import br.com.dbserver.voting.dtos.AddressDTO;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record AssociateRequestDTO(
        Integer id,
        @NotBlank(message = "Nome do associado nao pode estar em branco") String name,
        @NotBlank(message = "CPF do associado nao pode estar em branco") String cpf,
        @NotBlank(message = "CEP do associado nao pode estar em branco") String cep,
        AddressDTO addressDTO
) implements Serializable {
}
