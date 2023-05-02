package com.example.iluvcamping.util;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KeyGenerator {

    // 1. 카테고리 코드값을 받아서
    // 2. 코드값에 부합하는 문자열 2개와
    // 3. 6자리 랜덤 숫자를 조합한
    // 4. 키를 발행하고
    // 5. 중복 검사 후 리턴

    private final com.example.campsite.controller.CodeCategoryController codeCategoryController;

    @Autowired
    private ClientRepository clientRepository;

    public String randomKey(String tag) {
        String first = codeCategoryController.getCodeCategoryByCodeTag(tag).getCodeName();
        int randomNum = (int) (Math.random() * 900000);

        String code = first + String.format("%06d", randomNum);
        // 중복 체크
        while (isClientCodeExists(code)) {
            randomNum = (int) (Math.random() * 900000);
            code = first + String.format("%06d", randomNum);
        }

        return code;
    }

    private boolean isClientCodeExists(String clientCode) {
        return clientRepository.getClientByClientCode(clientCode) != null;
    }


}
