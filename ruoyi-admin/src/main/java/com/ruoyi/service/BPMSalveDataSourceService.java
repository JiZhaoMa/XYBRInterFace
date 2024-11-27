package com.ruoyi.service;

import com.ruoyi.u9c.domain.POLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BPMSalveDataSourceService {
    public int updateCaiGouDetail(@Param("pOLineList") List<POLine> pOLineList, @Param("codeList") List<String> codeList, @Param("orderCode") String orderCode, @Param("supplier") String supplier);
}
