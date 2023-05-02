package com.example.iluvcamping.service;



@RequiredArgsConstructor
@RestController
public class CommunityService {

    private final CommunityRepository communityRepository;

    // update
    @Transactional
    @PutMapping("updateCommunity")
    public void updateByWriteCode(Community newcommunity) {
        Community community =
                communityRepository.getReferenceById(newcommunity.getWriteCode());

        if(community != null) {
            community.setCommunity(newcommunity);
        }
    }

    public List<Community> getCommunityWithPage(Pageable pageable) {
        return communityRepository.findAll(pageable).getContent();
    }


    // delete
    @Transactional
    @DeleteMapping("/community/delete")
    public void deleteByWriteCode(String writeCode) {
        Community community =
                communityRepository.getCommunitiesByWriteCode(writeCode);

        if(community != null) {
            communityRepository.deleteById(community.getWriteCategoryCode());
        }
    }

}
