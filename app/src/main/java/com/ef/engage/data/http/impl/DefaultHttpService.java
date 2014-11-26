package com.ef.engage.data.http.impl;


import com.ef.engage.data.http.HttpError;
import com.ef.engage.data.http.HttpRequest;
import com.ef.engage.data.http.HttpRequestHandler;
import com.ef.engage.data.http.HttpResponse;
import com.ef.engage.data.http.HttpService;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/14/14
 */
public class DefaultHttpService implements HttpService {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    @Override
    public void exec(HttpRequest request, HttpRequestHandler httpRequestHandler) {
        httpRequestHandler.onStart();

        RequestBody body = RequestBody.create(JSON, request.getBody());
        OkHttpClient client = new OkHttpClient();
        Request.Builder builder = new Request.Builder().url(request.getUrl());

        switch (request.getMethod()) {
            case GET:
                builder.get();
                break;
            case POST:
                builder.post(body);
                break;
            default:
                builder.post(body);
        }
        Request okHttpRequest = builder.build();

        Response okHttpResponse;
        try {
            okHttpResponse = client.newCall(okHttpRequest).execute();
            int statusCode = okHttpResponse.code();

            if (statusCode == 200) {
                byte[] bytes = okHttpResponse.body().bytes();

                HttpResponse httpResponse = new DefaultHttpResponse(statusCode, bytes);
                httpRequestHandler.onSuccess(request, httpResponse);
            } else {
                HttpError httpError = new DefaultHttpError(statusCode, okHttpResponse.message());
                httpRequestHandler.onError(request, httpError);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // TODO consider blurbs
            HttpError httpError = new DefaultHttpError(0, e.getMessage());
            httpRequestHandler.onError(request, httpError);
        }
    }

}
