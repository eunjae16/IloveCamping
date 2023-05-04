package com.example.iluvcamping.domain.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, String> {

    public Client getClientByClientId(String clientId);
    public List<Client> getAllByClientIdAndClientPassword(String id, String password);

    public Client getClientByClientCode(String clientCode);

    public Client getClientByClientNickname(String nickname);
}
