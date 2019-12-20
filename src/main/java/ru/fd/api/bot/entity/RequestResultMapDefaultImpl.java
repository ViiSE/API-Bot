package ru.fd.api.bot.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("requestResultMapDefault")
@Scope("prototype")
public class RequestResultMapDefaultImpl implements RequestResult<Map<String, Object>> {

    private final Map<String, Object> dataMap;

    public RequestResultMapDefaultImpl(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    @Override
    public Object findObjectByKey(Object key) {
        if(key instanceof String)
            return dataMap.get(key);
        else
            return "Unknown object";
    }

    @Override
    public Map<String, Object> data() {
        return dataMap;
    }
}
