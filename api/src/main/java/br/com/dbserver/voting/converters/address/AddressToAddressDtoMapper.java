package br.com.dbserver.voting.converters.address;

import br.com.dbserver.voting.converters.Mapper;
import br.com.dbserver.voting.dtos.AddressDTO;
import br.com.dbserver.voting.models.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressToAddressDtoMapper implements Mapper<Address, AddressDTO> {
    @Override
    public AddressDTO map(Address address, AddressDTO addressDTO) {

        return new AddressDTO(
                address.getId(),
                address.getCep(),
                address.getState(),
                address.getCity(),
                address.getNeighborhood(),
                address.getStreet(),
                address.getService()
        );
    }
}
