package net.tospay.auth.remote.service;

import androidx.lifecycle.LiveData;

import net.tospay.auth.remote.request.LoginRequest;
import net.tospay.auth.remote.request.OtpRequest;
import net.tospay.auth.remote.request.RefreshTokenRequest;
import net.tospay.auth.remote.request.RegisterRequest;
import net.tospay.auth.remote.request.ResendEmailRequest;
import net.tospay.auth.remote.request.VerifyEmailRequest;
import net.tospay.auth.remote.request.VerifyPhoneRequest;
import net.tospay.auth.remote.response.ApiResponse;
import net.tospay.auth.remote.response.QrResponse;
import net.tospay.auth.remote.response.Result;
import net.tospay.auth.model.Token;
import net.tospay.auth.model.TospayUser;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {

    @POST("v3/user/login")
    LiveData<ApiResponse<Result<TospayUser>>> login(@Body LoginRequest request);

    @POST("v3/user/register")
    LiveData<ApiResponse<Result<TospayUser>>> register(@Body RegisterRequest request);

    @POST("v3/user/verify/email")
    LiveData<ApiResponse<Result>> verifyEmail(@Body VerifyEmailRequest request);

    @POST("v3/user/verify/email/resend")
    LiveData<ApiResponse<Result>> resendEmailToken(@Body ResendEmailRequest request);

    @POST("v3/user/verify/phone")
    LiveData<ApiResponse<Result>> verifyPhone(@Body VerifyPhoneRequest request);

    @POST("v3/user/verify/phone/resend")
    LiveData<ApiResponse<Result>> resendOtp(@Body OtpRequest request);

    @GET("v3/user/profile")
    LiveData<ApiResponse<Result<TospayUser>>> user();

    @POST("v3/user/token/refresh")
    LiveData<ApiResponse<Result<Token>>> refreshToken(@Body RefreshTokenRequest request);

    @POST("v3/account/info/qr")
    LiveData<ApiResponse<Result<QrResponse>>> qrInfo(@Body Map<String, String> request);

}