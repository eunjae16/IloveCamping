package com.example.iluvcamping.service;

import com.example.iluvcamping.domain.booking.Booking;
import com.example.iluvcamping.domain.booking.BookingRepository;
import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.campSite.CampSite;
import com.example.iluvcamping.domain.campSite.CampSiteRepository;
import com.example.iluvcamping.domain.client.Client;
import com.example.iluvcamping.domain.client.ClientRepository;
import com.example.iluvcamping.domain.client.ClientRequestDTO;
import com.example.iluvcamping.domain.community.Community;
import com.example.iluvcamping.domain.community.CommunityRepository;
import com.example.iluvcamping.domain.owner.Owner;
import com.example.iluvcamping.domain.owner.OwnerRepository;
import com.example.iluvcamping.domain.owner.OwnerRequestDTO;
import com.example.iluvcamping.domain.reply.Reply;
import com.example.iluvcamping.domain.reply.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final OwnerRepository ownerRepository;
    private final ClientRepository clientRepository;
    private final CommunityRepository communityRepository;
    private final ReplyRepository replyRepository;
    private final BookingRepository bookingRepository;
    private final CampRepository campRepository;
    private final CampSiteRepository campSiteRepository;

    public Owner getOwnerById(String ownerCode){
        Owner owner = null;

        owner = ownerRepository.findById(ownerCode).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 사용자 입니다.")
        );

        return owner;
    }

    public Client getClientById(String clientCode){
        Client client = null;

        client = clientRepository.findById(clientCode).orElseThrow(
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
            List<Community> communityList = communityRepository.getAllByWriterNickname(nickname);
            if(!communityList.isEmpty()){
                communityRepository.updateCommunityByWriterNickname(nickname);
            }

            List<Reply> replyList = replyRepository.getAllByReplierNickname(nickname);
            if(!replyList.isEmpty()){
                replyRepository.updateReplyByReplierNickname(nickname);
            }

            List<Camp> campList = campRepository.getAllByCampOwner(ownerCode);

            if(!campList.isEmpty()){
                for(Camp camp : campList){
                    String campCode = camp.getCampCode();

                    List<CampSite> campSiteList = campSiteRepository.getAllByCampCode(campCode);

                    if(!campSiteList.isEmpty()){
                        campSiteRepository.deleteCampSiteByCampCode(campCode);
                    }
                }

                campRepository.deleteCampByCampOwner(ownerCode);
            }

            ownerRepository.deleteById(ownerCode);
        }
    }

    @Transactional
    public void deleteClientByCode(String clientCode){

        Client client = getClientById(clientCode);

        if(client != null){
            String nickname = client.getClientNickname();

            List<Community> communityList = communityRepository.getAllByWriterNickname(nickname);
            if (!communityList.isEmpty()) {
                communityRepository.updateCommunityByWriterNickname(nickname);
            }


            List<Reply> replyList = replyRepository.getAllByReplierNickname(nickname);
            if(!replyList.isEmpty()){
                replyRepository.updateReplyByReplierNickname(nickname);
            }


            List<Booking> bookingList = bookingRepository.getAllByUserCode(clientCode);
            if(!bookingList.isEmpty()){
                bookingRepository.updateBookingByUserCode(clientCode);
            }

            clientRepository.deleteById(clientCode);
        }
    }

    // 회원수정

    @Transactional
    public void updateOwnerByCode(String ownerCode, OwnerRequestDTO ownerRequestDTO) {
        Owner owner = getOwnerById(ownerCode);

        if (owner == null) {
            throw new EntityNotFoundException("Owner not found with code: " + ownerCode);
        }

        if (ownerRequestDTO.getOwnerPassword() != null) {
            owner.setOwnerPassword(ownerRequestDTO.getOwnerPassword());
        }
        if (ownerRequestDTO.getOwnerNickname() != null) {
            owner.setOwnerNickname(ownerRequestDTO.getOwnerNickname());
        }
        if (ownerRequestDTO.getAccount() != null) {
            owner.setAccount(ownerRequestDTO.getAccount());
        }

        ownerRepository.save(owner);
    }

    @Transactional
    public void updateClientByCode(String clientCode, ClientRequestDTO clientDto){
        Client client = getClientById(clientCode);

        if(client == null){
            throw new EntityNotFoundException("Client not found with code: " + clientCode);
        }

        if(clientDto.getClientPassword() != null)
            client.setClientPassword(clientDto.getClientPassword());

        if(clientDto.getClientNickname() != null)
            client.setClientNickname(clientDto.getClientNickname());

        if(clientDto.getClientPhone() != null)
            client.setClientPhone(clientDto.getClientPhone());

        if(clientDto.getClientEmail() != null)
            client.setClientEmail(clientDto.getClientEmail());

        if(clientDto.getAddressCode() != null)
            client.setAddressCode(clientDto.getAddressCode());

        if(clientDto.getAddress() != null)
            client.setAddress(clientDto.getAddress());

        clientRepository.save(client);
    }


}
