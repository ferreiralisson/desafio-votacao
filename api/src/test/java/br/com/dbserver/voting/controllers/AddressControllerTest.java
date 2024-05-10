package br.com.dbserver.voting.controllers;

import br.com.dbserver.voting.dtos.AddressDTO;
import br.com.dbserver.voting.helpers.AddressCreator;
import br.com.dbserver.voting.services.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private AddressController addressController;

    @Mock
    private AddressService addressService;

    @BeforeEach
    void setUp() {
        when(addressService.getAddress(anyString())).thenReturn(AddressCreator.addressValid());
    }

    @Test
    public void shouldGetAddressSuccessfully() {
        String cep = AddressCreator.addressValid().getCep();
        assertThatCode(() -> addressController.getAddress(cep)).doesNotThrowAnyException();

        ResponseEntity<AddressDTO> entity = addressController.getAddress(cep);

        assertThat(entity).isNotNull();
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}