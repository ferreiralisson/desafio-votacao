package br.com.dbserver.voting.converters.associate;

import br.com.dbserver.voting.converters.Mapper;
import br.com.dbserver.voting.dtos.AddressDTO;
import br.com.dbserver.voting.dtos.associate.AssociateRequestDTO;
import br.com.dbserver.voting.helpers.Util;
import br.com.dbserver.voting.models.Address;
import br.com.dbserver.voting.models.Associate;
import org.springframework.stereotype.Component;

@Component
public class AssociateDtoToAssociateMapper implements Mapper<AssociateRequestDTO, Associate> {
    @Override
    public Associate map(AssociateRequestDTO associateRequestDTO, Associate associate) {
        String cpfWithoutCharacter = Util.removeNonNumericCharacterFromCpf(associateRequestDTO.cpf());

        return new Associate(
                null,
                associateRequestDTO.name(),
                cpfWithoutCharacter,
                associateRequestDTO.addressDTO() != null ? getAddress(associateRequestDTO.addressDTO()) : new Address());
    }

    private Address getAddress(AddressDTO addressDTO){
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
