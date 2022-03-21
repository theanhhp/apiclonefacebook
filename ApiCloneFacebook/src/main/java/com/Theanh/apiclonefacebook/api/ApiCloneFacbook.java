package com.Theanh.apiclonefacebook.api;

import com.Theanh.apiclonefacebook.dto.response.ModelData;
import com.Theanh.apiclonefacebook.dto.response.ModelLists;
import com.Theanh.apiclonefacebook.dto.response.ResponseCloneLongBien;
import com.Theanh.apiclonefacebook.dto.response.ResponseModel;
import com.Theanh.apiclonefacebook.servicel.ServiceFaceBook;
import com.amazonaws.util.json.Jackson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api/theanh")
public class ApiCloneFacbook {


    public static final Logger logger = LoggerFactory.getLogger(ApiCloneFacbook.class);

    @Autowired
    private ServiceFaceBook serviceFaceBook;


    @GetMapping(value = "/clone/{act}/{key}/{amount}/{id}")
    public ResponseModel getClone(@PathVariable("act") String act, @PathVariable("key") String key, @PathVariable("amount") String amount, @PathVariable("id") String id) {
        ResponseModel responseModel = new ResponseModel();

        try {
            ResponseEntity<String> response = serviceFaceBook.getResponse(act, key, amount, id);

            if (response.getStatusCode() == HttpStatus.OK) {
                ResponseCloneLongBien cloneLongBien = Jackson.fromJsonString(response.getBody(), ResponseCloneLongBien.class);
                if (cloneLongBien != null && cloneLongBien.getData() != null) {
                    responseModel.setStatus("success");
                    responseModel.setData(getModelData(cloneLongBien));
                }else {
                    responseModel.setStatus("Fail");
                }
            }else {
                responseModel.setStatus("Fail");
            }
        } catch (Exception e) {
            logger.error("error " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseModel;
    }

    private ModelData getModelData(ResponseCloneLongBien cloneLongBien) {

        ModelData modelData = new ModelData();
        List<ModelLists> lists = new ArrayList<>();
        for (String key : cloneLongBien.getData()) {
            ModelLists modelLists = new ModelLists();
            modelLists.setAccount(key);
            lists.add(modelLists);
        }
        modelData.setLists(lists);
        return modelData;
    }


}
