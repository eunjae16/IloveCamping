package com.example.iluvcamping.service;

import com.example.iluvcamping.domain.client.ClientRepository;
import com.example.iluvcamping.domain.owner.Owner;
import com.example.iluvcamping.domain.owner.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final ClientRepository clientRepository;

    public void addOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    public Optional<Owner> getOwner(String id) {
        Optional<Owner> result = ownerRepository.findById(id);

        return result;
    }


}
