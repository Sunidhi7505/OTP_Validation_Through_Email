package com.example.EmailOTP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.EmailOTP.model.OtpModel;
import com.example.EmailOTP.service.OtpService;


@RestController
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/send-otp")
    public String sendOtp(@ModelAttribute OtpModel model) {

        otpService.sendEmail(model.getEmail());

        return "otp sent successfully, please check your mail";
    }
}