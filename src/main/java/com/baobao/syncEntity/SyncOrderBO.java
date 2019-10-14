package com.baobao.syncEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SyncOrderBO extends OrderBo{

    private List<SyncOrderSkuItemBO> orderSkuItems;
    private List<SyncPromBO> syncProms;

}
