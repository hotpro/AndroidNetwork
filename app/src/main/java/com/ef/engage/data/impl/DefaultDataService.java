package com.ef.engage.data.impl;

import com.ef.engage.data.DataError;
import com.ef.engage.data.DataRequestHandler;
import com.ef.engage.data.DataResponse;
import com.ef.engage.data.DataService;
import com.ef.engage.data.cache.CacheService;
import com.ef.engage.data.model.Course;
import com.ef.engage.data.net.WebError;
import com.ef.engage.data.net.WebRequestHandler;
import com.ef.engage.data.net.WebResponse;
import com.ef.engage.data.net.WebService;

import java.util.logging.Handler;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/18/14
 */
public class DefaultDataService implements DataService {

    private WebService webService;
    private final CacheService cacheService;

    public DefaultDataService(WebService webService, CacheService cacheService) {
        this.webService = webService;
        this.cacheService = cacheService;
    }

    @Override
    public void login() {

    }

    @Override
    public void getStudyContext() {

    }

    @Override
    public void getCourse(String id, final DataRequestHandler<Course> dataRequestHandler) {

        String course = cacheService.getCourse(id);

        if (course == null) {
            webService.getCourse(id, new WebRequestHandler<Course>() {
                @Override
                public void onStart() {
                    dataRequestHandler.onStart();
                }

                @Override
                public void onSuccess(WebResponse<Course> webResponse) {
                    DataResponse<Course> dataResponse = new DefaultDataResponse<Course>(webResponse.getCode(),
                            webResponse.getData(), webResponse.getLastUpdate());
                    dataRequestHandler.onSuccess(dataResponse);
                }

                @Override
                public void onError(WebError webError) {
                    DataError dataError = new DefaultDataError(webError.getCode(), webError.getMessage(), webError.getErrorMetaData());
                    dataRequestHandler.onError(dataError);

                }
            });

        }
    }

    @Override
    public void getCourseList() {

    }

    @Override
    public void submitProgress() {

    }
}
