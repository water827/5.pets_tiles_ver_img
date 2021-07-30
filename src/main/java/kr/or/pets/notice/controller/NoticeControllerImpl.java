package kr.or.pets.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import kr.or.pets.notice.service.NoticeService;
import kr.or.pets.notice.vo.NoticeVO;

@Controller("noticeController")
public class NoticeControllerImpl implements NoticeController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeControllerImpl.class);
	
	@Autowired
	private NoticeService noticeService;
	@Autowired
	public NoticeVO noticeVO;
	
	
	//01. 공지사항 전체 목록 조회
	@Override
	@RequestMapping(value = "/notice/listNotices.do", method = {RequestMethod.GET, RequestMethod.POST}) 
	public ModelAndView listNotices(HttpServletRequest request, HttpServletResponse response) throws Exception	 {
		
		  request.setCharacterEncoding("utf-8");
		  String section_ = request.getParameter("section");
		  String pageNum_ = request.getParameter("pageNum");
		  
		  int section = Integer.parseInt(((section_== null)?"1":section_));
		  int pageNum = Integer.parseInt(((pageNum_== null)?"1":pageNum_));
		  logger.info("section :" + section);
		  logger.info("pageNum :" + pageNum);
		  
		  Map<String, Integer> pagingMap = new HashMap<>(); 
		  pagingMap.put("section", section);
		  pagingMap.put("pageNum", pageNum);
		  logger.info("pagingMap1 :" + pagingMap);
		  
		  Map noticeMap = noticeService.listNotices(pagingMap);
		  logger.info("pagingMap2 :" + pagingMap);
		  noticeMap.put("section", section);
		  noticeMap.put("pageNum", pageNum);
		  
		  String viewName = (String)request.getAttribute("viewName");
		  logger.info("viewName :" + viewName);
		  ModelAndView mav = new ModelAndView(viewName);
		  mav.addObject("noticeMap", noticeMap);
		  
		  return mav;
		 
		}
}
	
/*
 * //02-1. 공시자항 작성화면
 * 
 * @RequestMapping(value = "notice/noticeInsert.do", method = RequestMethod.GET)
 * //get방식 public ModelAndView noticeInsert(HttpServletRequest request,
 * HttpServletResponse response) throws Exception{ //return
 * "notice/noticeInsert.do"; noticeInsert.jsp로 이동
 * 
 * String viewName = (String)request.getAttribute("viewName"); ModelAndView mav
 * = new ModelAndView(); mav.setViewName(viewName); return mav; }
 * 
 * //02-2. 공지사항 작성 처리
 * 
 * @Override
 * 
 * @RequestMapping(value = "notice/addNotice.do", method = RequestMethod.POST)
 * //post방식 public ModelAndView addNotice(HttpServletRequest request,
 * HttpServletResponse response) throws Exception {
 * request.setCharacterEncoding("utf-8");
 * 
 * NoticeVO noticeVO = new NoticeVO();
 * 
 * bind(request, noticeVO); int result = noticeService.addNotice(noticeVO);
 * 
 * ModelAndView mav = new ModelAndView("redirect:/notice/listNotices.do");
 * 
 * return mav; }
 * 
 * //03. 공지사항 상세내용 조회, 공지사항 조회수 증가 처리
 * 
 * @RequestMapping(value = "/notice/viewNotice.do" , method = RequestMethod.GET
 * ) public ModelAndView viewNotice(@RequestParam("no_number") int
 * no_number,HttpServletRequest request, HttpServletResponse response) throws
 * Exception { System.out.println(
 * "========================================-------------------------B");
 * request.setCharacterEncoding("utf-8");
 * 
 * // 조회수 증가 처리 //noticeService.increaseViewCnt(no_number, session);
 * 
 * // 모델(데이터) + 뷰(화면)를 함께 전달하는 객체 ModelAndView mav = new ModelAndView(); //뷰의 이름
 * mav.setViewName("/viewNotice"); // 뷰에 전달할 데이터
 * mav.addObject("notice",noticeService.readNotice(no_number)); return mav; }
 * 
 * 
 * @Override public ModelAndView viewNotice(HttpServletRequest request,
 * HttpServletResponse response) throws Exception { // TODO Auto-generated
 * method stub return null; }
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */







//@RequestMapping(value = "/notice/viewNotice.do"  /* , method = RequestMethod.GET */)
	/*
	 * public ModelAndView viewNotice1(HttpServletRequest request,
	 * HttpServletResponse response ,HttpSession session) throws Exception { String
	 * viewName = getViewName(request); // 조회수 증가 처리
	 * //noticeService.increaseViewCnt(no_number, session); // 모델(데이터) + 뷰(화면)를 함께
	 * 전달하는 객체 System.out.println(
	 * "========================================-------------------------S");
	 * 
	 * ModelAndView mav = new ModelAndView(); //뷰의 이름
	 * mav.setViewName("/viewNotice"); // 뷰에 전달할 데이터
	 * //mav.addObject("viewNotice",noticeService.readNotice(no_number)); return
	 * mav; }
	 */


	//viewNotice로 넘어가기 성공
	/*
	 * @Override public ModelAndView viewNotice(HttpServletRequest request,
	 * HttpServletResponse response, HttpSession session) throws Exception {
	 * 
	 * System.out.println(
	 * "========================================-------------------------B"); String
	 * viewName = getViewName(request); // 조회수 증가 처리
	 * //noticeService.increaseViewCnt(no_number, session); // 모델(데이터) + 뷰(화면)를 함께
	 * 전달하는 객체 System.out.println(
	 * "========================================-------------------------C");
	 * 
	 * ModelAndView mav = new ModelAndView(viewName); //뷰의 이름
	 * mav.setViewName("/viewNotice"); // 뷰에 전달할 데이터
	 * //mav.addObject("viewNotice",noticeService.readNotice(no_number)); return
	 * mav; }
	 */
	
	
	/*
	 * @Override public ModelAndView viewNotice(HttpServletRequest request,
	 * HttpServletResponse response,HttpSession session) throws Exception {
	 * 
	 * System.out.println(
	 * "========================================-------------------------B"); String
	 * viewName = getViewName(request);
	 * 
	 * // 조회수 증가 처리 int no_number =
	 * Integer.getInteger(request.getParameter("no_number"));
	 * noticeService.increaseViewCnt(no_number, session); // 모델(데이터) + 뷰(화면)를 함께
	 * 전달하는 객체 System.out.println(
	 * "========================================-------------------------C");
	 * 
	 * ModelAndView mav = new ModelAndView(viewName); //뷰의 이름
	 * mav.setViewName("/viewNotice"); // 뷰에 전달할 데이터
	 * mav.addObject("viewNotice",noticeService.readNotice(no_number)); return mav;
	 * }
	 */