package com.example.iluvcamping.service;

import com.uploadcare.api.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyUploadService {

    private final Client uploadcareClient;

    @Autowired
    public MyUploadService(Client uploadcareClient) {
        this.uploadcareClient = uploadcareClient;
    }

    // Uploadcare 서비스 사용 예시
    public void uploadFile() {
        // 파일 업로드 로직 구현
    }

}
