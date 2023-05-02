package com.example.iluvcamping.service;

@RequiredArgsConstructor
@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public void addOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    public Optional<Owner> getOwner(String id) {
        Optional<Owner> result = ownerRepository.findById(id);

        return result;
    }

}
