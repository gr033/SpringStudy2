package methodtest;

import java.lang.reflect.Method;

public class MainTest {
	public static void main(String[] args) {
		MyUtil mu = new MyUtil();
//		String result = mu.sayHello("길동");
		String methodName = "sayHello";
		//문자열 변수 methodName에 저장된 sayHello를 호출하고 싶음
		
		String result=null;
		try {
			//그 메소드의 클래스 이름에 해당하는 Class 객체를 생성
			Class<?> cls = Class.forName(mu.getClass().getName());
			
			//그 클래스에 정의된 동작시키고자 하는 method 객체를 생성
			//getDeclaredMethod(methodName, String.class)
			//첫번째 매개변수는 동작시키고자 하는 메소드 이름
			//두번째 매개변수부터는 그 메소드의 매개변수의 자료형을 입력
			Method method = cls.getDeclaredMethod(methodName, String.class);
			
			//method 객체를 통해서 문자열로 된 메소드를 실행
			//첫번째 매개변수로 그 메소드가 속해있는 객체
			//두번째 매개변수로부터는 그 메소드의 매개변수를 나열
			result = (String)method.invoke(mu, "길동");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error: "+e.getMessage());
		}
		
		System.out.println(result);
	}
}
