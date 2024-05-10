package br.com.dbserver.voting.services.impl;

import br.com.dbserver.voting.converters.address.AddressDtoToAddressMapper;
import br.com.dbserver.voting.converters.address.AddressToAddressDtoMapper;
import br.com.dbserver.voting.converters.associate.AssociateDtoToAssociateMapper;
import br.com.dbserver.voting.dtos.AddressDTO;
import br.com.dbserver.voting.dtos.associate.AssociateRequestDTO;
import br.com.dbserver.voting.dtos.associate.AssociateResponseDTO;
import br.com.dbserver.voting.exceptions.InvalidCpfException;
import br.com.dbserver.voting.helpers.Util;
import br.com.dbserver.voting.models.Address;
import br.com.dbserver.voting.models.Associate;
import br.com.dbserver.voting.repositories.AssociateRepository;
import br.com.dbserver.voting.services.AddressService;
import br.com.dbserver.voting.services.AssociateService;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssociateServiceImpl implements AssociateService {

    private final AssociateRepository associateRepository;
    private final AssociateDtoToAssociateMapper associateDtoToAssociateMapper;
    private final AddressToAddressDtoMapper addressToAddressDtoMapper;
    private final AddressDtoToAddressMapper addressDtoToAddressMapper;
    private final AddressService addressService;

    public AssociateServiceImpl(AssociateRepository associateRepository, AssociateDtoToAssociateMapper associateDtoToAssociateMapper, AddressToAddressDtoMapper addressToAddressDtoMapper, AddressDtoToAddressMapper addressDtoToAddressMapper, AddressService addressService) {
        this.associateRepository = associateRepository;
        this.associateDtoToAssociateMapper = associateDtoToAssociateMapper;
        this.addressToAddressDtoMapper = addressToAddressDtoMapper;
        this.addressDtoToAddressMapper = addressDtoToAddressMapper;
        this.addressService = addressService;
    }

    @Override
    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "associate", allEntries = true),
            @CacheEvict(value = {"associates"}, allEntries = true)
    })
    public void createAssociate(AssociateRequestDTO associateRequestDTO) {

        if (!Util.validCpf(associateRequestDTO.cpf())) {
            throw new InvalidCpfException("CPF invalido");
        }

        Associate associate = associateDtoToAssociateMapper.map(associateRequestDTO, new Associate());
        saveAddress(associateRequestDTO, associate);
        associateRepository.save(associate);
    }

    private void saveAddress(AssociateRequestDTO associateRequestDTO, Associate associate) {
        AddressDTO addressAssociate = addressService.getAddress(associateRequestDTO.cep());
        associate.setAddress(null);
        if (addressAssociate.getCep() != null) {
            Address address = addressDtoToAddressMapper.map(addressAssociate, new Address());
            associate.setAddress(address);
        }
    }

    @Override
    @Cacheable(value = "associates")
    public Page<AssociateResponseDTO> listAll(Pageable pageable) {
        Page<Associate> associatePage = associateRepository.findAll(pageable);

        List<AssociateResponseDTO> associates = associatePage
                .stream()
                .map(associate -> new AssociateResponseDTO(
                        associate.getId().toString(),
                        associate.getName(),
                        associate.getCpf(),
                        associate.getAddress() != null ?
                                addressToAddressDtoMapper.map(associate.getAddress(), new AddressDTO())
                                : new AddressDTO()))
                .collect(Collectors.toList());

        return new PageImpl<>(associates, pageable, associatePage.getTotalPages());
    }
}
