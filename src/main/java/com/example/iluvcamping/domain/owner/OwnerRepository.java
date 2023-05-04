package com.example.iluvcamping.domain.owner;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, String> {

    public List<Owner> getAllByOwnerIdAndOwnerPassword(String id, String password);

    public Owner getOwnerByOwnerId(String ownerId);

    public Owner getOwnerByOwnerNickname(String nickname);
}
