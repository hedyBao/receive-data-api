package com.baobao.dao;

import com.baobao.syncEntity.SyncOrderBO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SyncOrderMapper {

    @Insert("")
    int insertNewOrder(SyncOrderBO syncOrderBO);

}
