package com.example.iluvcamping.service;

import com.example.iluvcamping.domain.client.Client;
import com.example.iluvcamping.domain.owner.Owner;
import com.example.iluvcamping.domain.owner.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public void addOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    public List<Owner> getOwnerAllByIdAndPassword(String id, String password){
        return ownerRepository.getAllByOwnerIdAndOwnerPassword(id, password);
    }

    public Optional<Owner> getOwner(String id) {
        Optional<Owner> result = ownerRepository.findById(id);

        return result;
    }

}
