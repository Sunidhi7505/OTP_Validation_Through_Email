package com.example.EmailOTP.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.EmailOTP.model.OtpModel;
import com.example.EmailOTP.repository.OtpRepository;

@Service
public class OtpService {

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private JavaMailSender mailSender;

	public void sendEmail(String email) {
		// ✅ 4-digit OTP
        String otp = String.valueOf(1000 + new Random().nextInt(9000));

        // check if email already exists
        OtpModel existing = otpRepository.findByEmail(email);
        if (existing == null) {
            existing = new OtpModel();
            existing.setEmail(email);
        }

        existing.setOtp(otp);
        otpRepository.save(existing);

        // send mail
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Email OTP Verification");
        message.setText("Your OTP is: " + otp);

        mailSender.send(message);
	}
}