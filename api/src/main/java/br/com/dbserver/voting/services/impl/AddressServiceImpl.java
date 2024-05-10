package br.com.dbserver.voting.services.impl;

import br.com.dbserver.voting.dtos.AddressDTO;
import br.com.dbserver.voting.exceptions.NotFoundException;
import br.com.dbserver.voting.helpers.Constants;
import br.com.dbserver.voting.services.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
public class AddressServiceImpl implements AddressService {

    private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Override
    public AddressDTO getAddress(String cep) {
        AddressDTO addressDTO = new AddressDTO();
        try {
            RestTemplate restTemplate = new RestTemplate();
            addressDTO = restTemplate.getForObject(Constants.BRASIL_API_CEP + cep, AddressDTO.class);
        } catch (HttpClientErrorException e) {
            logger.error("CEP {} não encontrado", cep);
        }

        return addressDTO;
    }
}
