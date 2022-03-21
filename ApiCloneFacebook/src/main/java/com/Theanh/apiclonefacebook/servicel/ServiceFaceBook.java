package com.Theanh.apiclonefacebook.servicel;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ServiceFaceBook {

    ResponseEntity<String> getResponse(String act, String key, String amount, String id);
}
