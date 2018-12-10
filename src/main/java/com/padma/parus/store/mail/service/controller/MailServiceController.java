package com.padma.parus.store.mail.service.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padma.parus.store.mail.service.payload.AccountChange;
import com.padma.parus.store.mail.service.payload.PasswordReset;
import com.padma.parus.store.mail.service.payload.VerifyEmail;
import com.padma.parus.store.mail.service.service.MailService;

import freemarker.template.TemplateException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/mail")
@Api(value = "Send email Rest API", description = "Defines endpoints that " +
		"can be hit only from server on same LAN so that email can be sent.")
public class MailServiceController {
	
	@Autowired
	private MailService mailService;
	
	@ApiOperation(value = "Send verify user email")
	@PostMapping("/verifyemail")
	public String sendEmailVerification(@Valid @RequestBody VerifyEmail verifyEmail) 
	{
			try {
				mailService.sendEmailVerification(verifyEmail.getEmailVerificationUrl(), verifyEmail.getTo());
			} catch (IOException | TemplateException | MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return "completed";
	}
	
	@ApiOperation(value = "Send rest password link to user")
	@PostMapping("/resetlink")
	public void sendResetLink(@Valid @RequestBody PasswordReset passwordReset) {
		try {
			mailService.sendResetLink(passwordReset.getResetPasswordLink(), passwordReset.getTo());
		} catch (IOException | TemplateException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@ApiOperation(value = "Send change of email adress information via email to user")
	@PostMapping("/accountchangeemail")
	public void sendAccountChangeEmail(@Valid @RequestBody AccountChange accountChange) 
	{
			try {
				mailService.sendAccountChangeEmail(accountChange.getAction(), accountChange.getActionStatus(), accountChange.getTo());
			} catch (IOException | TemplateException | MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
