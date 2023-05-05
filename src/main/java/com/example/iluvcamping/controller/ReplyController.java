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

        return "reply";
    }


    // read [ all ]
    @GetMapping("/reply/readall")
    public List<Reply> getReplyAll() {
        return replyRepository.findAll();
    }


//    @GetMapping("/reply/readlist")
//    // read [ find by writecode ]
//    public List<Reply> getReplyListByWriteCode(@RequestParam String writeCode) {
//        return replyRepository.findById(writeCode).orElse(
//                () -> new IllegalArgumentException("존재하지 않는 코드입니다.")
//        );
//    }



}
