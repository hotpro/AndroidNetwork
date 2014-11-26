package com.ef.engage.data.net.impl;

import com.ef.engage.data.ServiceResponse;
import com.ef.engage.data.http.HttpError;
import com.ef.engage.data.http.HttpRequest;
import com.ef.engage.data.http.HttpRequestHandler;
import com.ef.engage.data.http.HttpResponse;
import com.ef.engage.data.http.HttpService;
import com.ef.engage.data.http.impl.DefaultHttpRequest;
import com.ef.engage.data.model.Course;
import com.ef.engage.data.model.Enrollment;
import com.ef.engage.data.model.SessionInfo;
import com.ef.engage.data.model.StudyContext;
import com.ef.engage.data.net.WebError;
import com.ef.engage.data.net.WebRequestHandler;
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

    public static final String KEY_SERVICE_RESPONSE = "serviceResponse";

    private HttpService httpService;

    public DefaultWebService(HttpService httpService) {
        this.httpService = httpService;
    }

    @Override
    public void login(String userName, String password, WebRequestHandler<SessionInfo> webRequestHandler) {
        String url = "http://mobiledev.englishtown.com/services/mobile/service/login";

        JSONObject requestBody = new JSONObject();
        JSONObject serviceRequest = createServiceRequest();
        try {
            serviceRequest.put("userName", userName);
            serviceRequest.put("password", password);
            requestBody.put("serviceRequest", serviceRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        HttpRequest httpRequest = new DefaultHttpRequest(url, HttpService.Method.POST, requestBody.toString());

        httpService.exec(httpRequest, new DefaultHttpRequestHandler<SessionInfo>(webRequestHandler, SessionInfo.class, new BaseParser<SessionInfo>()));
    }

    @Override
    public void getStudyContext(String token, String culturecode, String sessionId, WebRequestHandler<StudyContext> webRequestHandler) {
        String url = "http://mobiledev.englishtown.com/services/mobile/service/studycontext ";

        JSONObject requestBody = new JSONObject();
        JSONObject serviceRequest = createServiceRequest();
        try {
            serviceRequest.put("token", token);
            serviceRequest.put("culturecode", culturecode);
            serviceRequest.put("sessionId", sessionId);
            requestBody.put("serviceRequest", serviceRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        HttpRequest httpRequest = new DefaultHttpRequest(url, HttpService.Method.POST, requestBody.toString());

        httpService.exec(httpRequest, new DefaultHttpRequestHandler<StudyContext>(webRequestHandler, StudyContext.class, new KeyParser<StudyContext>("context")));

    }

    private JSONObject createServiceRequest() {

        JSONObject serviceRequest = new JSONObject();

        try {
            serviceRequest.put("productId", 1);
            serviceRequest.put("platform", "Android");
            serviceRequest.put("appVersion", "1.0.0");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return serviceRequest;

    }

    @Override
    public void getCourse(String id, final WebRequestHandler<Course> webRequestHandler) {
        String url = "";
        String body = "";

        HttpRequest httpRequest = new DefaultHttpRequest("", HttpService.Method.POST, "");
        httpService.exec(httpRequest, new DefaultHttpRequestHandler<Course>(webRequestHandler, Course.class, new BaseParser<Course>()));
    }

    @Override
    public void getEnrolledCourses(String token, WebRequestHandler<Enrollment[]> webRequestHandler) {
        String url = "";
        final String body = "";

        HttpRequest httpRequest = new DefaultHttpRequest("", HttpService.Method.POST, "");

        BaseParser<Enrollment[]> parser = new BaseParser<Enrollment[]>() {
            @Override
            public Enrollment[] parse(String json, Class<Enrollment[]> clazz) {
                try {
                    JSONObject jsonObject = new JSONObject(body);
                    JSONObject j = jsonObject.getJSONObject("enrollments");
                    return new Gson().fromJson(j.toString(), clazz);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        httpService.exec(httpRequest, new DefaultHttpRequestHandler<Enrollment[]>(webRequestHandler, Enrollment[].class, parser));
    }

    class KeyParser<T> extends BaseParser <T> {
        private final String key;

        KeyParser(String key) {
            this.key = key;
        }

        @Override
        public T parse(String serviceResponse, Class<T> clazz) throws JSONException {
            JSONObject jsonObject = new JSONObject(serviceResponse);
            return new Gson().fromJson(jsonObject.get(key).toString(), clazz);
        }
    }

    class BaseParser<T> {

        /**
         * Cause some responses have entity properties just under "serviceResponse", some responses
         * put them into one json object and give it a key. So we need a custom parser.
         *
         * @param serviceResponse real inner serviceResponse json
         * @param clazz
         * @return
         */
        public T parse(String serviceResponse, Class<T> clazz) throws JSONException {
            return new Gson().fromJson(serviceResponse, clazz);
        }
    }

    class DefaultHttpRequestHandler <T> implements HttpRequestHandler {

        private WebRequestHandler webRequestHandler;
        private Class<T> clazz;
        private BaseParser<T> parser;

        DefaultHttpRequestHandler(WebRequestHandler<T> webRequestHandler, Class<T> clazz, BaseParser<T> parser) {
            this.webRequestHandler = webRequestHandler;
            this.clazz = clazz;
            this.parser = parser;
        }

        @Override
        public void onStart() {
            webRequestHandler.onStart();
        }

        @Override
        public void onSuccess(HttpResponse httpResponse) {
            try {
                String body = new String(httpResponse.getBody(), "UTF-8");
                JSONObject responseBody = new JSONObject(body);
                JSONObject serviceResponse = responseBody.getJSONObject(KEY_SERVICE_RESPONSE);

                Gson gson = new Gson();

                ServiceResponse response = gson.fromJson(serviceResponse.toString(), ServiceResponse.class);
                int code = response.getErrorCode();

                if (code == 0) {
                    T t = parser.parse(serviceResponse.toString(), clazz);
                    long lastUpdate = response.getLastUpdate();
                    webRequestHandler.onSuccess(new DefaultWebResponse<T>(code, t, lastUpdate));

                } else {
                    WebError webError = new Gson().fromJson(serviceResponse.toString(), DefaultWebError.class);
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

    }
}
