package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.LoginException;
import logic.ShopService;
import logic.User;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private ShopService service;
	@GetMapping("*") //* : 그외 모든 get방식 요청 
	public ModelAndView getUser() {
		ModelAndView mav = new ModelAndView();
		mav.addObject(new User());
		return mav;
	}
	@PostMapping("join")
	public ModelAndView join
	             (@Valid User user,BindingResult bresult) {
		ModelAndView mav = new ModelAndView();
		if(bresult.hasErrors()) { //입력값 오류 발생
			mav.getModel().putAll(bresult.getModel());
			//전체적인 오류코드 등록
			bresult.reject("error.input.user");
			return mav;
		}
		//db에 회원정보 등록
		try {
			service.userInsert(user);
			mav.addObject("user",user);
		//DataIntegrityViolationException : 중복키 오류.
		//                       같은 이름의 userid값이존재	
		} catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			bresult.reject("error.duplicate.user");
			mav.getModel().putAll(bresult.getModel());
			return mav;
		}
		mav.setViewName("redirect:login");
		return mav;
	}
	/* 로그인 - POST 방식 요청
	 * 1. 유효성검증
	 *    User객체에 저장된 파라미터값을 이용하여 유효성검증.
	 * 2. 입력받은 userid,password 로 db에서 해당 정보를 읽기.
	 *     - userid가 없는 경우 
	 *     - password가 틀린 경우
	 *     - 정상적인 사용자인경우 : session에 로그인 정보 등록하기  
	 *       session.setAttribute("loginUser",user객체)       
	 */	
	@PostMapping("login")
	public ModelAndView login(@Valid User user, BindingResult bresult,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		//1. 유효성검증
		if(bresult.hasErrors()) {
			mav.getModel().putAll(bresult.getModel());
			bresult.reject("error.input.login");
			return mav;
		}
		//userid에 해당하는 User 정보를 db에서 읽어 오기
		User dbuser = null;
		try { //아이디가 없는 경우 예외처리
		   dbuser = service.getUser(user.getUserid());
		} catch(EmptyResultDataAccessException e) {
			bresult.reject("error.login.id");
			mav.getModel().putAll(bresult.getModel());
			return mav;
		}
		if(user.getPassword().equals(dbuser.getPassword())) {
			session.setAttribute("loginUser", dbuser);
		} else {
			bresult.reject("error.login.password");
			mav.getModel().putAll(bresult.getModel());
			return mav;
		}
		mav.setViewName("redirect:mypage?id="+user.getUserid());
		return mav;
	}
	//http://localhost:8088/springmvc1/user/logout
	@RequestMapping("logout")  //핵심메서드 : 기본 실행 메서드
	public String loginCheckLogout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	/*
	 * AOP 설정하기 : 
	 *   UserLoginAspect 클래스의 userIdCheck 메서드로 구현하기.
	 * 1.pointcut : UserController 클래스의 idCheck로 시작하는 메서드이고, 
	 *              마지막 매개변수의 id,session인 경우 
	 * 2. 로그인 여부 검증
	 *   - 로그인이 안된경우 로그인 후 거래하세요. 메세지 출력. login페이지 호출
	 * 3. admin이 아니면서, 로그인 아이디와 파라미터 id값이 다른 경우
	 *   - 본인만 거래 가능합니다. 메세지 출력. item/list 페이지 호출              
	 */
	@RequestMapping("mypage")
	public ModelAndView idCheckMypage(String id,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		//회원정보를 조회하여 user 이름으로 뷰로 전달
		User user = service.getUser(id);
		//주문정보를 조회하여 뷰에 전달 => 미완성
		mav.addObject("user", user);
		return mav;
	}
	@GetMapping("update")
	public ModelAndView idCheckUser(String id,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User user = service.getUser(id);
		mav.addObject("user",user);
		return mav;
	}
	@PostMapping("update")
	public ModelAndView idCheckUpdate
       (@Valid User user, BindingResult bresult,
    		            String userid,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		//유효성 검증
		if(bresult.hasErrors()) {
			mav.getModel().putAll(bresult.getModel());
			bresult.reject("error.update.user");
			return mav;
		}
		//비밀번호 검증 : 로그인된 정보의 비밀번호로 검증.
		User loginUser = (User)session.getAttribute("loginUser");
		if(!loginUser.getPassword().equals(user.getPassword())) {
			mav.getModel().putAll(bresult.getModel());
			bresult.reject("error.login.password");
			return mav;
		}
		//비밀번호 일치인 경우: db에 내용 수정
		try {
			service.userUpdate(user);
			//session에 로그인 정보 수정
			session.setAttribute("loginUser", user);
			mav.setViewName
			       ("redirect:mypage?id="+user.getUserid());
		} catch (Exception e) {
			e.printStackTrace();
			throw new LoginException
			("고객 정보 수정 실패","update?id="+user.getUserid());
		}
		return mav;
	}
}
