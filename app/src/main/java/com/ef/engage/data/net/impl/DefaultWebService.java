package com.ef.engage.data.net.impl;

import com.ef.engage.data.http.HttpError;
import com.ef.engage.data.http.HttpRequest;
import com.ef.engage.data.http.HttpRequestHandler;
import com.ef.engage.data.http.HttpResponse;
import com.ef.engage.data.http.HttpService;
import com.ef.engage.data.http.impl.DefaultHttpRequest;
import com.ef.engage.data.model.Course;
import com.ef.engage.data.net.CourseReponse;
import com.ef.engage.data.net.WebError;
import com.ef.engage.data.net.WebRequestHandler;
import com.ef.engage.data.net.WebResponse;
import com.ef.engage.data.net.WebService;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/18/14
 */
public class DefaultWebService implements WebService {

    class DefaultHttpRequestHandler <T> implements HttpRequestHandler {

        private WebRequestHandler webRequestHandler;
        private Class<T> clazz;

        DefaultHttpRequestHandler(WebRequestHandler webRequestHandler, Class<T> clazz) {
            this.webRequestHandler = webRequestHandler;
            this.clazz = clazz;
        }

        @Override
        public void onStart() {
            webRequestHandler.onStart();

        }

        @Override
        public void onSuccess(HttpResponse httpResponse) {
            try {
                String body = new String(httpResponse.getBody(), "UTF-8");
                Gson gson = new Gson();
                CourseReponse response = gson.fromJson(body, CourseReponse.class);
                int code = response.getErrorCode();

                if (code == 0) {
                    T t = gson.fromJson(body, clazz);
                    long lastUpdate = response.getLastUpdate();
                    webRequestHandler.onSuccess(new DefaultWebResponse<T>(code, t, lastUpdate));

                } else {
                    // TODO
                    WebError webError = new Gson().fromJson(body, DefaultWebError.class);
                    webRequestHandler.onError(webError);
                }

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onError(HttpError httpError) {

        }

    }

    private HttpService httpService;

    public DefaultWebService(HttpService httpService) {
        this.httpService = httpService;
    }

    @Override
    public void getCourse(String id, final WebRequestHandler<Course> webRequestHandler) {
        String url = "";
        String body = "";

        HttpRequest httpRequest = new DefaultHttpRequest("", HttpService.Method.POST, "");
        httpService.exec(httpRequest, new HttpRequestHandler() {
            @Override
            public void onStart() {
                webRequestHandler.onStart();
            }

            @Override
            public void onSuccess(HttpResponse httpResponse) {

                try {
                    String body = new String(httpResponse.getBody(), "UTF-8");
                    JSONObject jsonObject = new JSONObject(body);
                    int code = jsonObject.getInt("errorCode");
                    if (code == 0) {
                        Course course = new Gson().fromJson(jsonObject.getString("course"), Course.class);
                        long lastUpdate = jsonObject.getLong("lastUpdate");
                        webRequestHandler.onSuccess(new DefaultWebResponse<Course>(code, course, lastUpdate));
                    } else {
                        WebError webError = new Gson().fromJson(body, DefaultWebError.class);
                        webRequestHandler.onError(webError);
                    }

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onError(HttpError httpError) {
                WebError webError = new DefaultWebError(httpError.getStatusCode(), httpError.getMessage(), null);
                webRequestHandler.onError(webError);

            }
        });
    }
}
