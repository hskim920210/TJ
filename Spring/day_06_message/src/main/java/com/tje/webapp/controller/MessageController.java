package com.tje.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tje.webapp.service.*;
import com.google.gson.Gson;
import com.tje.webapp.model.*;
import com.tje.webapp.setting.*;
import java.util.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/message")
public class MessageController {
	@Autowired
	private MemberSearchByIDService membersbIDService;
	@Autowired
	private MessageInsertService miService;
	@Autowired
	private MessageSearchByReceiverService msbrService;
	@Autowired
	private MessageSearchBySenderService msbsService;
	@Autowired
	private MessageSearchByIDService messagesbIDService;
	@Autowired
	private MessageUpdateReceiveTimeService murtService;
	@Autowired
	private MessageCountByReceiverService mcbrService;
	@Autowired
	private MessageCountBySenderService mcbsService;
	@Autowired
	private MessageSearchByReceiverDateService msbrdService;
	@Autowired
	private MessageSearchBySenderDateService msbsdService;
	@Autowired
	private PagingInfo pagingInfo;
	
	@GetMapping("/transform")
	public String transformForm() {
		return "message/transform";
	}
	
	// ajax 사용을 위한 기능
	@PostMapping("/searchID")
	// @ResponseBody 어노테이션
	// 현재 메소드에서 반환(리턴)하는 값을 클라이언트에게 즉시 전송하도록 제어하는 어노테이션
	// (VIEW 페이지로 이동하지 않고 현재 메소드에서 실행을 종료함)
	@ResponseBody
	public String searchID(@RequestParam(value="searchID") String searchID) {
		// System.out.println("searchID : " + searchID);
		Member member = new Member();
		member.setMember_id(searchID);
		
		List<Member> memberList = (List<Member>)membersbIDService.service(member, true);
		// 내가 가진 객체를 Json 형태로 변환해주거나, Json의 형태를 객체로 변환해주는 Gson
		Gson gson = new Gson();
		String strJson = gson.toJson(memberList);
		// System.out.println(strJson);
		// for(Member m : memberList) {
		// 	System.out.println(m.getMember_id());
		// }
		
		return strJson;
	}
	
	// 메세지 전송기능
	@PostMapping("/transform")
	public String transform(Message message, Model model) {
		
		int message_id = (Integer)miService.service(message);
		model.addAttribute("message_id", message_id);

		return "message/transformSubmit";
	}
	
	// 보낸 메세지함
	@GetMapping({"/send/{pageNo}", "/send"})
	public String send(@PathVariable(value = "pageNo", required = false)Integer page, Model model, HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "member/loginForm";
		}
		Member loginMember = (Member)session.getAttribute("loginMember");

		if(page == null) { page = 1; }
		
		HashMap<String, Object> args = new HashMap<String, Object>();
		args.put("curPageNo", page);
		
		Message message = new Message();
		message.setSender(loginMember.getMember_id());
		// System.out.println(loginMember.getMember_id());
		args.put("message", message);
		model.addAttribute("sList", msbsService.service(args));
		
		HashMap<String, Integer> result = (HashMap<String, Integer>)mcbsService.service(message);
		model.addAttribute("s_count", result.get("totalCount"));
		
		// 전체 페이지 개수
		int totalPageCount = (int)result.get("totalPageCount");
		// 시작 페이지와 종료 페이지 처리
		// 현재 페이지가 3인 경우 한 화면에 보여줄 범위는 5
		// 시작은 1, 종료는 5
		// 시작 -> 현재페이지 / 페이지범위 + 1
		// 종료 -? 시작 + 범위 - 1
//		int startPageNo = (page / pagingInfo.getPageRange()) * pagingInfo.getPageRange() + 1;
//		int endPageNo = totalPageCount < pagingInfo.getPageRange() ? totalPageCount : startPageNo + pagingInfo.getPageRange() - 1;
		int startPageNo =
				(page % pagingInfo.getPageRange() == 0 ? page-1 : page) / pagingInfo.getPageRange() * pagingInfo.getPageRange() + 1;
			
			int endPageNo = startPageNo + pagingInfo.getPageRange() - 1;
			if( endPageNo > totalPageCount )
				endPageNo = totalPageCount;
		// 이전, 이후
		// 이전을 만드는 경우는 시작이 1이 아닐 때
		// 이전페이지의 값은 시작 - 페이지 범위
		// 다음을 만드는 경우 종료가 최대페이지가 아날 때
		// 다음페이지의 값은 다음 + 1
		
		
		int beforePageNo = startPageNo != 1 ? startPageNo - pagingInfo.getPageRange() : -1;
		int afterPageNo = endPageNo != totalPageCount ? endPageNo + 1 : -1;
		
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("beforePageNo", beforePageNo);
		model.addAttribute("afterPageNo", afterPageNo);
		model.addAttribute("curPage", page);
		return "message/sendForm";
	}
	
	
	
	private String receiveForm(
			Integer page, Model model, HttpSession session) {
		Member loginMember = 
				(Member)session.getAttribute("loginMember");		
		HashMap<String, Object> args = 
				new HashMap<String, Object>();		
		
		args.put("curPageNo", page);		
		Message message = new Message();		
		message.setReceiver(loginMember.getMember_id());
		args.put("message", message);
		
		model.addAttribute("rList", msbrService.service(args));
		
		HashMap<String, Integer> result = 
			(HashMap<String, Integer>)mcbrService.service(message);
		model.addAttribute(
				"r_count", result.get("totalCount"));
		
		int totalPageCount = (int)result.get("totalPageCount");
		// 시작페이지와 종료페이지 처리
		// 현재 페이지가 3인경우 한 화면에 보여줄 범위는 5
		// 시작은 1, 종료는 5
		// 시작 -> 현재페이지 / 페이지범위 + 1
		// 종료 -> 시작 + 범위 - 1
		int startPageNo =
			(page % pagingInfo.getPageRange() == 0 ? page-1 : page) 
			/ pagingInfo.getPageRange() * pagingInfo.getPageRange() + 1;
		
		int endPageNo = startPageNo + pagingInfo.getPageRange() - 1;
		if( endPageNo > totalPageCount )
			endPageNo = totalPageCount;
		
		// 이전, 다음
		// 이전을 만드는 경우 시작이 1이 아닐 때
		// 이전페이지의 값은 시작 - 페이지점위
		// 다음을 만드는 경우 종료가 마지막 페이지가 아닐 때
		// 다음페이지의 값은 다음 + 1
		int beforePageNo = startPageNo != 1 ? startPageNo - pagingInfo.getPageRange() : -1;
		int afterPageNo = endPageNo != totalPageCount ? endPageNo + 1 : -1;
		
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("beforePageNo", beforePageNo);
		model.addAttribute("afterPageNo", afterPageNo);
		model.addAttribute("curPage", page);
		return "message/receiveForm";
	}
		
	@GetMapping("/receive/{pageNo}")
	public String receiveFormWithPageNo(
			@PathVariable("pageNo") Integer page,
			Model model, HttpSession session) {
		return receiveForm(page, model, session);
	}
		
	@GetMapping("/receive")
	public String receiveFormNotPageNo(			
			Model model, HttpSession session) {
		return receiveForm(1, model, session);
	}
	
	@PostMapping("/receiveSearch")
	public String receiveSubmit(			
			@ModelAttribute("command")MessageSearchCommand command, HttpSession session, Model model) {
		HashMap<String, Object> args = new HashMap<>();
		args.put("command", command);
		String receiver = ((Member)session.getAttribute("loginMember")).getMember_id();
		args.put("receiver", receiver);
		
		List<Message> searched = (List<Message>)msbrdService.service(args);
		
		model.addAttribute("searched", searched);
		model.addAttribute("searchedCount", searched == null ? 0 : searched.size());
		
		return "message/receiveSearchSubmit";
	}
	
	@PostMapping("/sendSearch")
	public String sendSearchSubmit(			
			@ModelAttribute("command")MessageSearchCommand command, HttpSession session, Model model) {
		HashMap<String, Object> args = new HashMap<>();
		args.put("command", command);
		String sender = ((Member)session.getAttribute("loginMember")).getMember_id();
		args.put("sender", sender);
		
		List<Message> searched = (List<Message>)msbsdService.service(args);
		
		model.addAttribute("searched", searched);
		model.addAttribute("searchedCount", searched == null ? 0 : searched.size());
		
		return "message/sendSearchSubmit";
	}
	
	
//	// 받은 메세지함 ( 선생님 코드는 바로 위에 있음 )
//	@GetMapping({"/receive/{pageNo}", "/receive"})
//	// pageNo를 가져오되 꼭 필요한건 아니다. -> required = false : 패쓰 베리어블 없어도 된다.
//	public String receiveForm(@PathVariable(value = "pageNo", required = false)Integer page, Model model, HttpSession session) {
//		if(session.getAttribute("loginMember") == null) {
//			return "member/loginForm";
//		}
//		
//		Member loginMember = (Member)session.getAttribute("loginMember");
//		
//		if(page == null) { page = 1; }
//		
//		HashMap<String, Object> args = new HashMap<String, Object>();
//		args.put("curPageNo", page);
//		
//		Message message = new Message();
//		message.setReceiver(loginMember.getMember_id());
//		
//		args.put("message", message);
//		model.addAttribute("rList", msbrService.service(args));
//		
//		HashMap<String, Integer> result = (HashMap<String, Integer>)mcbrService.service(message);
//		model.addAttribute("r_count", result.get("totalCount"));
//		
//		// 전체 페이지 개수
//		int totalPageCount = (int)result.get("totalPageCount");
//		// 시작 페이지와 종료 페이지 처리
//		// 현재 페이지가 3인 경우 한 화면에 보여줄 범위는 5
//		// 시작은 1, 종료는 5
//		// 시작 -> 현재페이지 / 페이지범위 + 1
//		// 종료 -? 시작 + 범위 - 1
////		int startPageNo = (page / pagingInfo.getPageRange()) * pagingInfo.getPageRange() + 1;
////		int endPageNo = totalPageCount < pagingInfo.getPageRange() ? totalPageCount : startPageNo + pagingInfo.getPageRange() - 1;
//		int startPageNo =
//				(page % pagingInfo.getPageRange() == 0 ? page-1 : page) / pagingInfo.getPageRange() * pagingInfo.getPageRange() + 1;
//			
//			int endPageNo = startPageNo + pagingInfo.getPageRange() - 1;
//			if( endPageNo > totalPageCount )
//				endPageNo = totalPageCount;
//		// 이전, 이후
//		// 이전을 만드는 경우는 시작이 1이 아닐 때
//		// 이전페이지의 값은 시작 - 페이지 범위
//		// 다음을 만드는 경우 종료가 최대페이지가 아날 때
//		// 다음페이지의 값은 다음 + 1
//		
//		
//		int beforePageNo = startPageNo != 1 ? startPageNo - pagingInfo.getPageRange() : -1;
//		int afterPageNo = endPageNo != totalPageCount ? endPageNo + 1 : -1;
//		
//		model.addAttribute("totalPageCount", totalPageCount);
//		model.addAttribute("startPageNo", startPageNo);
//		model.addAttribute("endPageNo", endPageNo);
//		model.addAttribute("beforePageNo", beforePageNo);
//		model.addAttribute("afterPageNo", afterPageNo);
//		model.addAttribute("curPage", page);
//		
//		return "message/receiveForm";
//	}
	
	
	
	
	//  receive_notRead
	@GetMapping({"/receive_notRead/{pageNo}", "/receive_notRead"})
	public String receive_notReadForm(@PathVariable(value = "pageNo", required = false)Integer page, Model model, HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "member/loginForm";
		}
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(page == null) { page = 1; }
		
		HashMap<String, Object> args = new HashMap<String, Object>();
		args.put("curPageNo", page);
		
		Message message = new Message();
		message.setReceiver(loginMember.getMember_id());
		
		args.put("message", message);
		model.addAttribute("rList", msbrService.service(args));
		
		HashMap<String, Integer> result = (HashMap<String, Integer>)mcbrService.service(message);
		model.addAttribute("r_count", result.get("totalCount"));
		
		int totalPageCount = (int)result.get("totalPageCount");
		int startPageNo =
				(page % pagingInfo.getPageRange() == 0 ? page-1 : page) / pagingInfo.getPageRange() * pagingInfo.getPageRange() + 1;
			
			int endPageNo = startPageNo + pagingInfo.getPageRange() - 1;
			if( endPageNo > totalPageCount )
				endPageNo = totalPageCount;
		int beforePageNo = startPageNo != 1 ? startPageNo - pagingInfo.getPageRange() : -1;
		int afterPageNo = endPageNo != totalPageCount ? endPageNo + 1 : -1;
		
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("beforePageNo", beforePageNo);
		model.addAttribute("afterPageNo", afterPageNo);
		model.addAttribute("curPage", page);
		
		return "message/receiveForm";
	}
	
	
//		// 받은 메세지함
//		@GetMapping("/receive/{pageNo}")
//		// pageNo를 가져오되 꼭 필요한건 아니다. -> required = false : 패쓰 베리어블 없어도 된다.
//		public String receiveFormWithPageNo(@PathVariable(name="pageNo") Integer page, Model model, HttpSession session) {
//			return receiveFormWithPageNo(page, model, session);
//		}

	// PathVariable (특정 값을 결정이 안된 변수로 받아올 때 {}를 사용한다)
	// : URL 정보를 변수의 값으로 사용하는 방법.
	// ex) http://www.naver.com/article/10 -> 10의 내용을 꺼내오는 법.
	// 	   http://www.google.com/dept/10/emp/5 -> 10번 부서의 5번 사원
	@GetMapping("/content/{message_id}")
	public String content( @PathVariable("message_id") int message_id, Model model ) {
		Message message = new Message();
		message.setMessage_id(message_id);
		
		murtService.service(message);
		model.addAttribute("message", messagesbIDService.service(message));
		return "message/message";
	}
	
	@GetMapping("/content_send/{message_id}")
	public String content_send( @PathVariable("message_id") int message_id, Model model ) {
		Message message = new Message();
		message.setMessage_id(message_id);
		Message send_msg = (Message)messagesbIDService.service(message);
		model.addAttribute("message", send_msg);
		return "message/message_send";
	}
	
	
	
	
	
//	@GetMapping("/send_detail")
//	public String send_detail(@RequestParam(name = "message_id") int message_id, Model model) {
//		Message message = new Message();
//		message.setMessage_id(message_id);
//		Message send_msg = (Message)messagesbIDService.service(message);
//		
//		model.addAttribute("msg", send_msg);
//		return "message/send_detail";
//	}
	
//	@GetMapping("/receive_detail")
//	public String receive_detail(@RequestParam(name = "message_id") int message_id, Model model) {
//		Message message = new Message();
//		message.setMessage_id(message_id);
//		Message receive_msg = (Message)msgsbIDService.service(message);
//		
//		if(receive_msg.getReceive_time() == null) {
//			murtService.service(receive_msg);
//		}
//		model.addAttribute("msg", receive_msg);
//		return "message/receive_detail";
//	}
}
