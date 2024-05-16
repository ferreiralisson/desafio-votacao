package br.com.dbserver.voting.controllers;

import br.com.dbserver.voting.dtos.AddressDTO;
import br.com.dbserver.voting.helpers.Constants;
import br.com.dbserver.voting.services.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = Constants.API_VERSION + "/address")
public class AddressController {

    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping(path = "/{cep}")
    public ResponseEntity<AddressDTO> getAddress(@PathVariable String cep) {
        logger.info("Iniciando a listagem de cep: {}", cep);
        AddressDTO address = service.getAddress(cep);
        logger.info("Listagem de cep concluída - Endereco completo: {}", address);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}
