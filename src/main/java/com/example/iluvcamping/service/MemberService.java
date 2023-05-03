package com.example.iluvcamping.service;

import com.example.iluvcamping.domain.client.ClientRepository;
import com.example.iluvcamping.domain.community.Community;
import com.example.iluvcamping.domain.community.CommunityRepository;
import com.example.iluvcamping.domain.owner.Owner;
import com.example.iluvcamping.domain.owner.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final OwnerRepository ownerRepository;
    private final ClientRepository clientRepository;
    private final CommunityRepository communityRepository;

    public Owner getOwnerById(String ownerId){
        Owner owner = null;

        owner = ownerRepository.findById(ownerId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 사용자 입니다.")
        );
        return owner;
    }

    // 회원탈퇴
    @Transactional
    public void deleteOwnerByCode(String ownerCode){

        Owner owner = getOwnerById(ownerCode);

        if(owner != null) {
            // community > 이 회원이 쓴 글 조회
            List<Community> communityList = communityRepository.getCommunitiesByWriterNickname(owner.getOwnerNickname());

            // 조회된 모든 글들의 닉네임 >> "탈퇴한회원" 으로 업데이트
//            for(Community community : communityList){
//
//            }

            String nick = owner.getOwnerNickname();
            // updateCommutyNicknameByClientCode
            // UPDATE cmmunity SET nick='anoymous' WHERE nick=nick

            // reply > 이 회원이 쓴 댓글 조회
            // 조회된 모든 댓글의 닉네임 >> "탈퇴한회원" 으로 업데이트

            // booking > 이 회원이 예약한 모든 내역 조회
            // 조회된 모든 내역의 정보 >> "탈퇴한회원" 으로 업데이트

            ownerRepository.deleteById(ownerCode);
        }
    }

    // 회원수정

}
