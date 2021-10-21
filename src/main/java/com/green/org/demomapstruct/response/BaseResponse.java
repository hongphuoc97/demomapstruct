package com.green.org.demomapstruct.response;

import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.green.org.demomapstruct.util.ObjectUtils.*;

@Setter
public abstract class BaseResponse<T> extends ResponseEntity<T> {

    private static final String PROPERTY_JSON_BASE_META = "meta";
    protected static final String PROPERTY_JSON_BASE_DATA = "data";

    private HttpStatus overrideStatus = HttpStatus.OK;
    private MetaResponse metaResponse = new MetaResponse();

    protected BaseResponse(HttpStatus status) {
        super(status);
        initMetaResponse();
    }

    protected BaseResponse(T body, HttpStatus status) {
        super(body, status);
        this.overrideStatus = isNullOrEmpty(getBody()) ? HttpStatus.NO_CONTENT : status;
        initMetaResponse();
    }

    protected BaseResponse(T body, HttpStatus status, int pageNumber, int pageSize) {
        super(body, status);
        this.overrideStatus = isNullOrEmpty(getBody()) ? HttpStatus.NO_CONTENT : status;
        initMetaResponse(pageNumber, pageSize);
    }

    protected BaseResponse(T body, HttpStatus status, int count, int pageNumber, int pageSize) {
        super(body, status);
        this.overrideStatus = isNullOrEmpty(getBody()) ? HttpStatus.NO_CONTENT : status;
        initMetaResponse(count, pageNumber, pageSize);
    }

    private void initMetaResponse() {
        getMetaResponse().setStatusCode(overrideStatus == HttpStatus.NO_CONTENT ? overrideStatus.value() : getStatusCodeValue());
        getMetaResponse().setMessage(overrideStatus == HttpStatus.NO_CONTENT ? overrideStatus.getReasonPhrase() : getStatusCode().getReasonPhrase());
        if (isNotNull(getBody())) {
            getMetaResponse().setCount(1);
        }
        initPaging();
    }

    private void initMetaResponse(int pageNumber, int pageSize) {
        initMetaResponse();
        initPaging(pageNumber, pageSize);
    }

    private void initMetaResponse(int count, int pageNumber, int pageSize) {
        initMetaResponse(pageNumber, pageSize);
        getMetaResponse().setCount(count);
    }

    private void initPaging() {
        if (isCollection(getBody())) {
            getMetaResponse().setCount(((Collection) getBody()).size());
            getMetaResponse().getPagingResponse().setPageNumber(1);
            getMetaResponse().getPagingResponse().setPageSize(((Collection) getBody()).size());
        }
    }

    private void initPaging(int pageNumber, int pageSize) {
        getMetaResponse().getPagingResponse().setPageNumber(pageNumber);
        getMetaResponse().getPagingResponse().setPageSize(pageSize);
    }

    /**
     * Mapper meta response to json and then add it into base response json.
     */
    protected Map<String, Object> toJson() {
        Map<String, Object> jsonResult = new LinkedHashMap<>();
        jsonResult.put(PROPERTY_JSON_BASE_META, getMetaResponse().toJson());
        return jsonResult;
    }


    private MetaResponse getMetaResponse() {
        return metaResponse;
    }
}
