package com.example.iluvcamping.service;

import com.example.iluvcamping.domain.reply.Reply;
import com.example.iluvcamping.domain.reply.ReplyRepository;
import com.example.iluvcamping.domain.reply.ReplyRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class ReplyService {

    private  final ReplyRepository replyRepository;

    // update
    @Transactional
    public void updateReply(ReplyRequestDTO replyDto) {
        String replyCode = replyDto.getReplyCode();
//        boolean modifiedCheck = replyDto.isModifiedCheck();

        Reply reply = replyRepository.findById(replyCode).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 코드입니다."));

        reply.setModifiedCheck(true);
        reply.updateReply(replyDto);
    }

    // delete
    @Transactional
    public void deleteReplyByReplyCode(String replyCode) {
        replyRepository.deleteById(replyCode);
    }

}
