package com.green.org.demomapstruct.response;


import com.google.common.base.Strings;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
public class MetaResponse {
    private static final String PROPERTY_JSON_META_STATUS_CODE = "statusCode";
    private static final String PROPERTY_JSON_META_MESSAGE = "message";
    private static final String PROPERTY_JSON_META_TOTAL = "count";
    private static final String PROPERTY_JSON_META_PAGING = "paging";

    private int statusCode;
    private String message;
    private int count = 0;
    private PagingResponse pagingResponse = new PagingResponse();

    /**
     * Mapper meta response to json
     */
    public Map<String, Object> toJson() {
        Map<String, Object> jsonResult = new LinkedHashMap<>();

        if (Objects.nonNull(getStatusCode())) {
            jsonResult.put(PROPERTY_JSON_META_STATUS_CODE, getStatusCode());
        }

        if (!Strings.isNullOrEmpty(getMessage())) {
            jsonResult.put(PROPERTY_JSON_META_MESSAGE, getMessage());
        }

        jsonResult.put(PROPERTY_JSON_META_TOTAL, getCount());

        if (getCount() > 1) {
            jsonResult.put(PROPERTY_JSON_META_PAGING, getPagingResponse().toJson());
        }

        return jsonResult;
    }
}
