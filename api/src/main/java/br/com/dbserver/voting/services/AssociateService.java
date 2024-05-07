package br.com.dbserver.voting.services;

import br.com.dbserver.voting.dtos.associate.AssociateRequestDTO;
import br.com.dbserver.voting.dtos.associate.AssociateResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AssociateService {
    void createAssociate(AssociateRequestDTO associateRequestDTO);

    Page<AssociateResponseDTO> listAll(Pageable pageable);
}
