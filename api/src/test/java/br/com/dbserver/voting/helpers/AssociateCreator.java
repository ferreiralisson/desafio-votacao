package br.com.dbserver.voting.helpers;

import br.com.dbserver.voting.dtos.AddressDTO;
import br.com.dbserver.voting.dtos.associate.AssociateRequestDTO;
import br.com.dbserver.voting.dtos.associate.AssociateResponseDTO;
import br.com.dbserver.voting.models.Address;
import br.com.dbserver.voting.models.Associate;

public class AssociateCreator {

    public static AssociateRequestDTO associateDTOValid(){
        return new AssociateRequestDTO(1, "user", "357.672.271-87", "", new AddressDTO());
    }

    public static AssociateRequestDTO createAssociateRequestDtoValid(){
        return new AssociateRequestDTO(null, "user", "357.672.271-87", "", new AddressDTO());
    }

    public static AssociateRequestDTO createAssociateRequestDtoInvalid(){
        return new AssociateRequestDTO(null, "user", null, "", new AddressDTO());
    }

    public static Associate associateValid(){
        return new Associate(1, "user", "357.672.271-87", new Address());
    }

    public static AssociateResponseDTO associateResponseDtoValid(){
        return new AssociateResponseDTO("1", "associado", "357.672.271-87", new AddressDTO());
    }

}
