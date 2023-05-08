package com.example.iluvcamping.service;


import com.example.iluvcamping.domain.community.Community;
import com.example.iluvcamping.domain.community.CommunityRepository;
import com.example.iluvcamping.domain.community.CommunityRequestDTO;
import com.example.iluvcamping.domain.reply.Reply;
import com.example.iluvcamping.domain.reply.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommunityService {

    private final CommunityRepository communityRepository;
    private final ReplyRepository replyRepository;

    // update
    @Transactional
    public void updateCommunity(CommunityRequestDTO communityDto) {
        String writeCode = communityDto.getWriteCode();
        String writeCategoryCode = communityDto.getWriteCategoryCode();
        System.out.println("edit cate: " + communityDto.getWriteCategoryCode());

        Community community = communityRepository.findById(writeCode).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 회원입니다.")
        );

        community.setWriteCategoryCode(writeCategoryCode);
        community.updateCommunity(communityDto);
        System.out.println("edit cate: " + communityDto.getWriteCategoryCode());
        System.out.println("edit comu: " + community.getWriteCategoryCode());
    }

    // delete [ owner ]
    @Transactional
    public void deleteWriteByWritecode(String writeCode) {

        List<Reply> replyList = replyRepository.findByWriteCode(writeCode);

        for (Reply reply : replyList) {
            replyRepository.delete(reply);
        }
        communityRepository.deleteById(writeCode);
    }

    // 페이징처리
    public List<Community> getCommunityWithPage(Pageable pageable) {
        return communityRepository.findAll(pageable).getContent();
    }




}
