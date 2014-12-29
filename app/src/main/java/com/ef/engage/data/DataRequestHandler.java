package com.ef.engage.data;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/19/14
 */
public interface DataRequestHandler<T> {
    public void onStart();
    public void onSuccess(DataResponse<T> dataResponse);
    public void onError(DataError dataError);
}
