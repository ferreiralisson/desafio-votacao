package br.com.dbserver.voting.services.impl;

import br.com.dbserver.voting.dtos.AddressDTO;
import br.com.dbserver.voting.exceptions.NotFoundException;
import br.com.dbserver.voting.helpers.AddressCreator;
import br.com.dbserver.voting.helpers.Constants;
import br.com.dbserver.voting.services.AddressService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
class AddressServiceImplTest {

    @Autowired
    private AddressService service;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void getAddressWhenSuccessful(){
        String cep = AddressCreator.addressValid().getCep();
        when(restTemplate.getForObject(Constants.BRASIL_API_CEP + cep, AddressDTO.class)).thenReturn(AddressCreator.addressValid());

        assertThatCode(() -> service.getAddress(cep))
                .doesNotThrowAnyException();

        AddressDTO result = service.getAddress(cep);

        assertEquals(cep, result.getCep());
    }

    @Test
    public void getAddressNotFound() {
        when(restTemplate.getForObject(anyString(), eq(AddressDTO.class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        AddressDTO actualAddress = service.getAddress("00000-000");

        assertNull(actualAddress.getCep());
    }
}