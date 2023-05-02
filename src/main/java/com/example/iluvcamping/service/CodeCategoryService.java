package com.example.iluvcamping.service;


import com.example.iluvcamping.controller.CodeCategoryController;
import com.example.iluvcamping.domain.codeCategory.CodeCategory;
import com.example.iluvcamping.domain.codeCategory.CodeCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CodeCategoryService {

    public final CodeCategoryRepository codeCategoryRepository;
    public final CodeCategoryController codeCategoryController;

    //update
    public  void updateByCodeTag(CodeCategory newCodeCategory) {
        CodeCategory codeCategory =
                codeCategoryController.getCodeCategoryByCodeTag(newCodeCategory.getCodeTag());

        if(codeCategory != null) {
            codeCategory.setCodeCategory(newCodeCategory);
        }

    }


    // delete
    public void deleteByCodeTag(String codeTag) {
        CodeCategory codeCategory =
                codeCategoryController.getCodeCategoryByCodeTag(codeTag);

        if (codeCategory != null) {
            codeCategoryRepository.deleteById(codeTag);
        }
    }
}
