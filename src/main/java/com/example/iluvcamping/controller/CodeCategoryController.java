package com.example.campsite.controller;


import com.example.campsite.domain.codeCategory.CodeCategory;
import com.example.campsite.domain.codeCategory.CodeCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CodeCategoryController {

    private final CodeCategoryRepository codeCategoryRepository;

    // create
    @PostMapping("/codeCategory/add")
    public void addCodeCategory(CodeCategory codeCategory) {
        codeCategoryRepository.save(codeCategory);
    }


    // read all
    @GetMapping("/codeCategory/read")
    public List<CodeCategory> getAllCodeCategory(){
        return codeCategoryRepository.findAll();
    }


    // read [ by id ]
    @GetMapping("/codeCategory/readone")
    public CodeCategory getCodeCategoryByCodeTag(String codeTag){

        CodeCategory codeCategory = null;

        codeCategory = codeCategoryRepository.findById(codeTag).orElseThrow(
                ()-> new IllegalArgumentException("존재하지 않는 코드입니다.")
        );

        return codeCategory;
    }

}
