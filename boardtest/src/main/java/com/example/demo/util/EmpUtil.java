package com.example.demo.util;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.dao.EmpDAO;
import com.example.demo.vo.EmpVO;
import com.sist.util.MyUtil;

import lombok.Setter;

@Component
@EnableScheduling
@Setter
public class EmpUtil {
	@Autowired
	private MailSender mailSender;
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private EmpDAO dao;

//	@Scheduled(cron = "0 43 14 5 * *")
	public void sendHtml() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		List<EmpVO> list = dao.findAllEmp();
		for (EmpVO e : list) {
			String from = "yuri98834@gmail.com";
			String to = e.getEmail();
			String data = MyUtil.getHtml(e);
			sender.send(new MimeMessagePreparator() {
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
					// TODO Auto-generated method stub
					message.setFrom(from);
					message.setTo(to);
					message.setSubject(e.getEname() + "님의 급여명세서[담당자: 심유리]");
					message.setText(data, true);
				}
			});
			System.out.println(e.getEname()+"("+to+")님에게 급여 명세서를 전송하였습니다.");
		}
	}

}
