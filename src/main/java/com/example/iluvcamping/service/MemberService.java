package com.example.iluvcamping.service;

import com.example.iluvcamping.domain.booking.Booking;
import com.example.iluvcamping.domain.booking.BookingRepository;
import com.example.iluvcamping.domain.client.Client;
import com.example.iluvcamping.domain.client.ClientRepository;
import com.example.iluvcamping.domain.community.Community;
import com.example.iluvcamping.domain.community.CommunityRepository;
import com.example.iluvcamping.domain.owner.Owner;
import com.example.iluvcamping.domain.owner.OwnerRepository;
import com.example.iluvcamping.domain.reply.Reply;
import com.example.iluvcamping.domain.reply.ReplyRepository;
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
    private final ReplyRepository replyRepository;
    private final BookingRepository bookingRepository;

    public Owner getOwnerById(String ownerId){
        Owner owner = null;

        owner = ownerRepository.findById(ownerId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 사용자 입니다.")
        );
        return owner;
    }

    public Client getClientById(String clientId){
        Client client = null;

        client = clientRepository.findById(clientId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 사용자 입니다.")
        );
        return client;
    }

    // 회원탈퇴
    @Transactional
    public void deleteOwnerByCode(String ownerCode){

        Owner owner = getOwnerById(ownerCode);


        if(owner != null) {
            String nickname = owner.getOwnerNickname();

            // community > 이 회원이 쓴 글 조회
            List<Community> communityList = communityRepository.getCommunitiesByWriterNickname(nickname);

            // 조회된 모든 글들의 닉네임 >> "탈퇴한회원" 으로 업데이트
            communityRepository.updateCommunitiesByWriterNickname(nickname);

            // reply > 이 회원이 쓴 댓글 조회
            List<Reply> replyList = replyRepository.getRepliesByReplierNickname(nickname);

            // 조회된 모든 댓글의 닉네임 >> "탈퇴한회원" 으로 업데이트
            replyRepository.updateRepliesByReplierNickname(nickname);

            // booking > 이 회원이 예약한 모든 내역 조회
            // 조회된 모든 내역의 정보 >> "탈퇴한회원" 으로 업데이트 >> client만 가능!

            ownerRepository.deleteById(ownerCode);
        }
    }

    public void deleteClientByCode(String clientCode){

        Client client = getClientById(clientCode);

        if(client != null){
            String nickname = client.getClientNickname();

            List<Community> communityList = communityRepository.getCommunitiesByWriterNickname(nickname);
            communityRepository.updateCommunitiesByWriterNickname(nickname);

            List<Reply> replyList = replyRepository.getRepliesByReplierNickname(nickname);
            replyRepository.updateRepliesByReplierNickname(nickname);

            List<Booking> bookingList = bookingRepository.getBookingsByUserCode(clientCode);
            bookingRepository.updateBookingsByWriterNickname(clientCode);

            clientRepository.deleteById(clientCode);
        }
    }

    // 회원수정

}
