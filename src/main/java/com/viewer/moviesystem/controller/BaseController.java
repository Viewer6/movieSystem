package com.viewer.moviesystem.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.github.pagehelper.PageInfo;
import com.viewer.moviesystem.domain.Result;
import com.viewer.moviesystem.domain.TableDataInfo;
import com.viewer.moviesystem.emuns.ResultCode;

import java.util.List;

public class BaseController {
    //    if(result > 1){
//        return Result.success(null);
//    }
//    return Result.error(null);
    public Result<Void> getResult(int result){
        return result >= 1 ? Result.success(null) : Result.fail(ResultCode.FAILED, null);
    }

    //    if(result > 1){
//        return Result.success(null);
//    }
//    return Result.error(null);
    public Result<Void> getResult(boolean result){
        return result ? Result.success(null) : Result.fail(ResultCode.FAILED, null);
    }

    public TableDataInfo getTableDataInfo(List<?> list){
        if(CollectionUtil.isEmpty(list)){
            return TableDataInfo.empty();
        }
        return TableDataInfo.success(list, new PageInfo<>(list).getTotal());
    }

}
