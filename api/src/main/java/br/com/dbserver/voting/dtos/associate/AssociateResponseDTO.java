package br.com.dbserver.voting.dtos.associate;

import br.com.dbserver.voting.dtos.AddressDTO;

import java.io.Serializable;

public class AssociateResponseDTO implements Serializable {

    private String id;
    private String nome;
    private String cpf;
    private AddressDTO address;

    public AssociateResponseDTO() {}

    public AssociateResponseDTO(String id, String nome, String cpf, AddressDTO address) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
