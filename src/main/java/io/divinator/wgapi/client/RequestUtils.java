package io.divinator.wgapi.client;

import java.util.HashMap;
import java.util.Map;


public class RequestUtils {

    private RequestUtils () {}

    public static Map<String, Object> parseRequestParams(String[] params) {
        HashMap<String, Object> paramMap = new HashMap<>();

        for(String param : params) {
            String[] split = param.split("=");

            if (split.length == 2) {
                paramMap.put(split[0], split[1]);
            }
        }

        return paramMap;
    }
}
