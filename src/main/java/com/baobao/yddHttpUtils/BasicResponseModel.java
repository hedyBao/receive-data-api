package com.baobao.yddHttpUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicResponseModel {

    private VendorMappingApi content;

    private int code;

    private String msg;


}
