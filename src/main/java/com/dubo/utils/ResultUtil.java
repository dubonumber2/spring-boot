package com.dubo.utils;

import com.dubo.entity.Result;

public class ResultUtil {
    public static Result success(Object o){
        Result result=new Result();
        result.setData(o);
        result.setCode(400);
        result.setMsg("成功");
        return result;
    }
    public static Result success(){

        return success(null);
    }
    public static Result error(Integer code,String msg){
        Result result=new Result();

        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
