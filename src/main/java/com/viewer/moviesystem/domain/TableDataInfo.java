package com.viewer.moviesystem.domain;

import com.viewer.moviesystem.emuns.ResultCode;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TableDataInfo {
    private long total;

    private List<?> rows;

    private int code;

    private String msg;

    public TableDataInfo(){

    }

    public static TableDataInfo empty(){
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(ResultCode.SUCCESS.getCode());
        rspData.setRows(new ArrayList<>());
        rspData.setMsg(ResultCode.SUCCESS.getMeg());
        rspData.setTotal(0);
        return rspData;
    }

    public static TableDataInfo success(List<?> list, long total){
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(ResultCode.SUCCESS.getCode());
        rspData.setRows(list);
        rspData.setMsg(ResultCode.SUCCESS.getMeg());
        rspData.setTotal(total);
        return rspData;
    }

}
