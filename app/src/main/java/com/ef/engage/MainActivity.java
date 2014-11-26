package com.ef.engage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ef.engage.data.DataError;
import com.ef.engage.data.DataRequestHandler;
import com.ef.engage.data.DataResponse;
import com.ef.engage.data.DataService;
import com.ef.engage.data.cache.impl.DefaultCacheService;
import com.ef.engage.data.http.EFHttpRequestType;
import com.ef.engage.data.http.HttpService;
import com.ef.engage.data.http.ServiceProvider;
import com.ef.engage.data.http.impl.DefaultHttpService;
import com.ef.engage.data.impl.DefaultDataService;
import com.ef.engage.data.model.SessionInfo;
import com.ef.engage.data.model.StudyContext;
import com.ef.engage.data.net.WebService;
import com.ef.engage.data.net.impl.DefaultWebService;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView txtUser;
    private Button btnLogin;
    private Button btnContext;
    private Executor executor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        executor = Executors.newSingleThreadExecutor();
        txtUser = (TextView) findViewById(R.id.txtUser);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btnContext = (Button) findViewById(R.id.btnEnrollment);
        btnContext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studyContext();
            }
        });

        this.sessionInfo = getSessionInfo();
        if (sessionInfo != null) {
            txtUser.setText(sessionInfo.toString());
        }
    }

    private SessionInfo sessionInfo;

    private void login() {
        String url = "http://mobiledev.englishtown.com/services/mobile/service/login";
        final String userName = "dmobile";
        final String password = "ef";
        executor.execute(new Runnable() {
            @Override
            public void run() {
                getDataService().login(userName, password, new DataRequestHandler<SessionInfo>() {
                    @Override
                    public void onStart() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                txtUser.setText("login...");
                            }
                        });
                    }

                    @Override
                    public void onSuccess(final DataResponse<SessionInfo> dataResponse) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                sessionInfo = dataResponse.getData();
                                saveSessionInfo();
                                Log.v(TAG, "sessionInfo = " + sessionInfo);
                                txtUser.setText(dataResponse.getData().toString());
                            }
                        });


                    }

                    @Override
                    public void onError(final DataError dataError) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.v(TAG, "dataError = " + dataError);
                                txtUser.setText(dataError.toString());
                            }
                        });
                    }
                });
            }
        });


    }

    private DataService getDataService() {
        HttpService httpService = new DefaultHttpService();
        WebService webService = new DefaultWebService(httpService);
        DataService dataService = new DefaultDataService(webService, new DefaultCacheService());
        return dataService;
    }

    private void studyContext() {
        if (sessionInfo == null) {
            txtUser.setText("Please Login");
        }
        final String token = sessionInfo.getToken();
        final String cultureCode = "en";
        final String sessionId = sessionInfo.getSessionId();


        executor.execute(new Runnable() {
            @Override
            public void run() {
                getDataService().getStudyContext(token, cultureCode, sessionId, new DataRequestHandler<StudyContext>() {
                    @Override
                    public void onStart() {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Log.d(TAG, "Get StudyContext onStart");
                            }
                        });

                    }

                    @Override
                    public void onSuccess(final DataResponse<StudyContext> dataResponse) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.v(TAG, "StudyContext: " + dataResponse.getData().toString());
                            }
                        });

                    }

                    @Override
                    public void onError(final DataError dataError) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.v(TAG, "StudyContext error: " + dataError.toString());
                            }
                        });

                    }
                });
            }
        });

    }

    private void saveSessionInfo() {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        prefs.edit().putString("sessionInfo", new Gson().toJson(sessionInfo)).commit();
    }

    private SessionInfo getSessionInfo() {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String s = prefs.getString("sessionInfo", "");
        return new Gson().fromJson(s, SessionInfo.class);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }
}
