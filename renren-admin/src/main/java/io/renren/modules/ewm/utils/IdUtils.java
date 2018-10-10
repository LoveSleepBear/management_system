package io.renren.modules.ewm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * id工具类
 * @author suyibo
 * @date 2018/10/10 19:17
 */
public class IdUtils {

    public static String getUUId(){
        return UUID.randomUUID().toString().replace("-","");
    }


    public static String getUUIdAndTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String time = format.format(new Date());
        return getUUId()+time;
    }



}
