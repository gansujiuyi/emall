package com.jiuyi.jyplant.store;

import org.springframework.core.io.Resource;

public interface StoreConnector {
    StoreDTO save(String baseDir ,String model, Resource resource, String originName)
            throws Exception;

    StoreDTO get(String baseDir  ,String model, String key) throws Exception;

    void remove(String baseDir  ,String model, String key) throws Exception;
}
