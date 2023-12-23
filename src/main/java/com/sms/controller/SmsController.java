package com.sms.controller;


import com.sms.payload.SmsRequest;
import com.sms.service.SmsService;
import com.twilio.twiml.voice.Sms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class SmsController {

        private SmsService smsService;

        @Autowired
        public SmsController(SmsService smsService) {
            this.smsService = smsService;
        }

        @PostMapping("/send-sms")
        public void sendSMS(@RequestBody SmsRequest request) {
            smsService.sendSMS(request.getTo(), request.getMessage());
        }
    }


