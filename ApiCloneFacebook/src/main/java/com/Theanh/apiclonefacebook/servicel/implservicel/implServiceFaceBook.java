package com.Theanh.apiclonefacebook.servicel.implservicel;

import com.Theanh.apiclonefacebook.servicel.ServiceFaceBook;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class implServiceFaceBook implements ServiceFaceBook {

    @Autowired
    RestTemplate restTemplate;

    String url = "https://clonelongbien.com/api/orders_api.php?";

    @Override
    public ResponseEntity<String> getResponse(String act, String key, String amount, String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        String replaceFirst = key.replaceFirst("he","");
        map.add("act", act);
        map.add("api_key", replaceFirst);
        map.add("amount",amount);
        map.add("service_id",id);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);


        return  restTemplate.postForEntity( url, request , String.class );
    }
}
