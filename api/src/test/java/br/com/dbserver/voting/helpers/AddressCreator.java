package br.com.dbserver.voting.helpers;

import br.com.dbserver.voting.dtos.AddressDTO;

public class AddressCreator {

    public static AddressDTO addressValid(){
        return new AddressDTO(
                null,
                "55606195",
                "PE",
                "Vitória de Santo Antão",
                "São Vicente de Paulo",
                "Rua Severino Alexandre da Silva",
                "open-cep"
        );
    }
}
