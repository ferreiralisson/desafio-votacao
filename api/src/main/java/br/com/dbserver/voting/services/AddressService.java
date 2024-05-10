package br.com.dbserver.voting.services;

import br.com.dbserver.voting.dtos.AddressDTO;

public interface AddressService {
    AddressDTO getAddress(String cep);
}
