package cn.edu.aynu.utils;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

public class CommonsUtils {

    public static <T> T toBean(Map<String, ?> data, Class<T> clazz){
        try{
            T bean = clazz.newInstance();
            BeanUtils.populate(bean, data);
            return bean;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();  
    }
    
}