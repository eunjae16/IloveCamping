package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.reply.Reply;
import com.example.iluvcamping.domain.reply.ReplyRepository;
import com.example.iluvcamping.domain.reply.ReplyRequestDTO;
import com.example.iluvcamping.service.ReplyService;
import com.example.iluvcamping.util.KeyGenerator;
import com.example.iluvcamping.util.Timestamp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class ReplyController extends Timestamp {

    private final ReplyRepository replyRepository;
    private final ReplyService replyService;
    private final KeyGenerator keyGenerator;

    // create
    @PostMapping("/reply/add")
    public void addReply(Reply reply) {
        replyRepository.save(reply);
    }

    // write [ reply ]
    @PostMapping("/reply/write")
    public String replyWrite(@RequestBody ReplyRequestDTO replyDto) {
        Reply reply = new Reply(replyDto);
        String code = keyGenerator.randomKey("L");
        reply.setReplyCode(code);

        addReply(reply);

        return "communityread?writeCode=";
    }


    // read [ all ]
    @GetMapping("/reply/readall")
    public List<Reply> getReplyAll() {
        return replyRepository.findAll();
    }


    // read [ 특정 게시물에 해당하는 댓글목록 ]
    @GetMapping("/reply/readlist")
    public List<Reply> getReplyListByWriteCode(@RequestParam String writeCode) {
        return replyRepository.findByWriteCode(writeCode);
    }

    // read [ one ] by replycode
    public Reply getReplyByReplyCode(@RequestParam String replyCode) {
        Reply reply = replyRepository.getReplyByReplyCode(replyCode);
        System.out.println("delete reply: "+replyCode);
        return reply;
    }

    // update
    @PutMapping("/reply/update")
    public void updateByReplyCode(@RequestParam String replyCode, @RequestBody ReplyRequestDTO replyDto) {
        replyDto.setReplyCode(replyCode);
        replyDto.setModifiedCheck(true);
        System.out.println("modicheck: " + replyDto.isModifiedCheck());
        replyService.updateReply(replyDto);
    }

    // delete
    @DeleteMapping("/reply/delete")
    public void deleteReply(String replyCode) {
        Reply reply = getReplyByReplyCode(replyCode);
        replyService.deleteReplyByReplyCode(replyCode);
    }



}
