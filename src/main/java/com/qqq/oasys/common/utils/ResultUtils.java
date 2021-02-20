package com.qqq.oasys.common.utils;

import com.qqq.oasys.common.code.StatusCode;
import com.qqq.oasys.common.result.ResultBase;
import com.qqq.oasys.common.result.ResultData;

public class ResultUtils {

    public static ResultBase getResultBase(){
        ResultBase resultBase = new ResultBase();
        resultBase.setSuccess(true);
        resultBase.setStatusCode(StatusCode.SUCCESS);
        resultBase.setMessage("success !");
        return resultBase;
    }

    public static <T> ResultData<T> getResultData(T data){
        ResultData<T> resultData = new ResultData<>();
        resultData.setData(data);
        resultData.setSuccess(true);
        resultData.setMessage("操作成功！");
        resultData.setStatusCode(StatusCode.SUCCESS);
        return resultData;
    }


}
