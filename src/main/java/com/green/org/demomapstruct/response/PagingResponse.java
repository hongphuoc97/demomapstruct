package com.green.org.demomapstruct.response;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class PagingResponse {
    private static final String PROPERTY_JSON_META_PAGING_NUMBER = "page";
    private static final String PROPERTY_JSON_META_PAGING_SIZE = "size";

    private int pageNumber = 1;
    private int pageSize = 1;

    /**
     * Mapper paging response to json
     */
    public Map<String, Object> toJson() {
        Map<String, Object> jsonResult = new LinkedHashMap<>();

        jsonResult.put(PROPERTY_JSON_META_PAGING_NUMBER, getPageNumber());
        jsonResult.put(PROPERTY_JSON_META_PAGING_SIZE, getPageSize());

        return jsonResult;
    }
}
