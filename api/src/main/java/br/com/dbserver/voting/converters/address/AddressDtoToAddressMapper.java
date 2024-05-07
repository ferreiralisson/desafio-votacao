package br.com.dbserver.voting.converters.address;

import br.com.dbserver.voting.converters.Mapper;
import br.com.dbserver.voting.dtos.AddressDTO;
import br.com.dbserver.voting.models.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoToAddressMapper implements Mapper<AddressDTO, Address> {

    @Override
    public Address map(AddressDTO addressDTO, Address address) {
        return new Address(
                addressDTO.getId(),
                addressDTO.getCep(),
                addressDTO.getState(),
                addressDTO.getCity(),
                addressDTO.getNeighborhood(),
                addressDTO.getStreet(),
                addressDTO.getService()
        );
    }
}
