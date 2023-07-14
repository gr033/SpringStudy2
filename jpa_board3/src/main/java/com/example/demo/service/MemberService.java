package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.entity.Member;

import lombok.Setter;

@Service
@Setter
public class MemberService implements UserDetailsService {
	@Autowired
	private MemberDAO dao;
	
	//스프링 시큐리티에서는 로그인을 위한 get방식에 대한 폼 태그는 우리 마음대로 만들 수 있지만
	//실제 로그인 처리는 우리가 하지 않고 시큐리티가 알아서 처리해준다.
	//이 때 다음의 loadUserByUsername 메소드가 동작한다.
	//이 메소드는 매개변수로 사용자가 입력한 아이디가 전달되고, 우리는 이 아이디에 해당하는 회원의 정보를
	//dao로부터 불러온 다음 UserDetails 객체를 생성하여 반환하도록 만들어야 한다.
	//그 나머지 암호가 맞는지, 어떤 서비스를 위하여 권한이 있는지 등은 시큐리티가 판별한다.
	//만약, 해당 id의 고객이 없으면 예외를 발생시킨다.
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
//	    dao.save(new Member("kim",PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("kim"),"김유신","user"));
//	    dao.save(new Member("lee",PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("lee"),"이순신","admin"));
//	    dao.save(new Member("hong",PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("hong"),"홍길동","user"));
//	    System.out.println("회원을 추가 했습니다");
	     
	    Member m = dao.findById(username).get();
	    
		UserDetails user = null;
		if(m==null) {
			try {
				throw new UsernameNotFoundException(username);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else {
			user = User.builder().username(username)
					.password(m.getPwd()).roles(m.getRole()).build();
		}
		return user;
	}

}
