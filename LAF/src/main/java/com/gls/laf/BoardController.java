package com.gls.laf;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gls.laf.board.BoardService;
import com.gls.laf.board.BoardVO;


@Controller
@RequestMapping(value = "/board")
public class BoardController {

//	private final String MODULE = "image";

	@Autowired
	BoardService boardService;


//	@RequestMapping(value = "/mylist", method = RequestMethod.GET)
//	public String mylist() {
//		return "mylist";
//	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String boardlist(Model model, 
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range,
			@RequestParam(required = false, defaultValue = "2") int lost) throws Exception {
		// 페이징 계산을 위해 Pagination 클래스에 보내야 할 파라미터에는 '현재 페이지'와 '현재 페이지 범위', 그리고 '게시물의 총
		// 개수'가 있다.
		// lost의 경우 2가 all / 1이 found / 0이 lost이다.

//		int listCnt = 2;
//		
//		// 전체 게시글 개수
//		if(lost == 2) { // 전체 게시물
//			listCnt= boardService.getBoardListCnt();
//		}
//		else if(lost==1) { // Found 게시물
//			listCnt= boardService.getBoardListFoundCnt();
//		}
//		else if(lost==0) {  // Lost 게시물
//			listCnt= boardService.getBoardListLostCnt();
//		}
//		
//
//		// Pagination 객체생성
//		Pagination pagination = new Pagination();
//		pagination.pageInfo(page, range, listCnt, lost);
//		model.addAttribute("pagination", pagination);
//		
//		if(lost == 2) {
//			model.addAttribute("list", boardService.getBoardList(pagination));
//		}
//		else if(lost==1) {
//			model.addAttribute("list", boardService.getBoardListFound(pagination));
//		}
//		else if(lost==0) {
//			model.addAttribute("list", boardService.getBoardListLost(pagination));
//		}
		model.addAttribute("list", boardService.getBoardList());
		return "list";
	}

//	@RequestMapping(value = "/list_found", method = RequestMethod.GET)
//	public String boardlist_found(Model model, 
//			@RequestParam(required = false, defaultValue = "1") int page,
//			@RequestParam(required = false, defaultValue = "1") int range) throws Exception {
//		// 페이징 계산을 위해 Pagination 클래스에 보내야 할 파라미터에는 '현재 페이지'와 '현재 페이지 범위', 그리고 '게시물의 총
//		// 개수'가 있다.
//		
//		
//		System.out.println("DEBUG : Inside list_found!!!");
//		
//		// 전체 게시글 개수
//		int listCnt_found = boardService.getBoardListFoundCnt();
//		System.out.println("DEBUG : listCnt_found : " + listCnt_found);
//
//		// Pagination 객체생성
//		Pagination pagination_found = new Pagination();
//		pagination_found.pageInfo(page, range, listCnt_found);
//		
//		model.addAttribute("pagination", pagination_found);
//		model.addAttribute("list_found", boardService.getBoardListFound(pagination_found));
//		return "list_found";
//	}
//
//	@RequestMapping(value = "/list_lost", method = RequestMethod.GET)
//	public String boardlist_lost(Model model, 
//			@RequestParam(required = false, defaultValue = "1") int page,
//			@RequestParam(required = false, defaultValue = "1") int range) throws Exception {
//		// 페이징 계산을 위해 Pagination 클래스에 보내야 할 파라미터에는 '현재 페이지'와 '현재 페이지 범위', 그리고 '게시물의 총
//		// 개수'가 있다.
//		
//		System.out.println("DEBUG : Inside list_lost!!!!");
//
//		// 전체 게시글 개수
//		int listCnt_lost = boardService.getBoardListLostCnt();
//
//		// Pagination 객체생성
//		Pagination pagination_lost = new Pagination();
//		pagination_lost.pageInfo(page, range, listCnt_lost);
//		System.out.println("DEBUG : listcnt_lost : " + listCnt_lost);
//		
//		model.addAttribute("pagination", pagination_lost);
//		model.addAttribute("list_lost", boardService.getBoardListLost(pagination_lost));
//		return "list_lost";
//	}

	/*
	@RequestMapping(value = "/my_page", method = RequestMethod.GET)
	public String myPage() {
		return "my_page";
	}

	@RequestMapping(value = "/log_out", method = RequestMethod.GET)
	public String logout() {
		return "log_out";
	}

	@RequestMapping(value = "/chat_page", method = RequestMethod.GET)
	public String chatpage() {
		return "chat_page";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPost() {
		return "addpostform";
	}

	@RequestMapping(value = "/addok", method = RequestMethod.POST)
	public String addPostOK(HttpServletRequest servletRequest, @ModelAttribute BoardVO vo, Model model,
			RedirectAttributes rttr) throws IllegalStateException, IOException {

		MultipartFile file = vo.getPhotofile(); // 파일 가져와라
		String fileName; // 파일 이름 저장 변수

		if (file != null) { // 파일이 있다면

			fileName = file.getOriginalFilename(); // 파일 이름 저장 변수에 파일 이름 저장

			String realPath = servletRequest.getSession().getServletContext().getRealPath("/resources/upload/");
			// 이 (상대)경로에 저장할 수 있도록 / 실제 서버의 위치를 모르기 때문에 webapp 기준으로 상대경로로 접근한다. 이렇게 하면 루트부터
			// full path를 가져온다.

			File dir = new File(realPath);
			if (!dir.exists())
				dir.mkdir(); // 폴더 생성
			System.out.println("DEBUG: " + realPath + fileName); // 확인용

			// 저장하려는 파일시스템의 실제 위경로와 파일 이름을 주고 중복 파일이 존재하는지 여부 체크
			String saveFileName = FileUtil.checkDuplicate(realPath + fileName);
			System.out.println("DEBUG: " + saveFileName); // 확인용

			File imagefile = new File(saveFileName); // 중복값 제거한 이름의 파일 생성

			// File imageFile = new File(realPath, filename);

			try {
				file.transferTo(imagefile); // 실질적으로 서버에 파일 저장

				// 서버에 올라간 파일명만 가져오기 - path는 없음
				String uploadFileName = saveFileName.substring(saveFileName.lastIndexOf("/") + 1);
				System.out.println("DEBUG: " + uploadFileName); // 확인용

				// DB에 정보 저장

				vo.setPhotourl(uploadFileName);
				// vo.setPhotourl("/winter/resources/upload/" + uploadFileName);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		

		if (boardService.insertBoard(vo) == 0) {
			System.out.println("데이터 추가 실패");
		}

		else {
			System.out.println("데이터 추가 성공!!");
			rttr.addFlashAttribute("process_result", "write success");
		}

		// model.addAttribute("u", vo);
		return "redirect:list";
	}

	@RequestMapping(value = "/editform/{id}", method = RequestMethod.GET)
	public String editPost(@PathVariable("id") int id, Model model) {
		BoardVO boardVO = boardService.getBoard(id);
		model.addAttribute("u", boardVO);
		return "editform";
	}

	@RequestMapping(value = "/editok", method = RequestMethod.POST)
	public String editPostOk(BoardVO vo, RedirectAttributes rttr) {
		if (boardService.updateBoard(vo) == 0) {
			System.out.println("데이터 수정 실패 ");
		}

		else {
			System.out.println("데이터 수정 성공!!!");

		}

		return "redirect:list";
	}

	@RequestMapping(value = "/deleteok/{id}", method = RequestMethod.GET)
	public String deletePost(@PathVariable("id") int id, RedirectAttributes rttr) {
		int i = boardService.deleteBoard(id);
		if (i == 0) {
			System.out.println("데이터 삭제 실패 ");
		} else {
			System.out.println("데이터 삭제 성공!!!");
			rttr.addFlashAttribute("process_result", "delete success");
		}

		return "redirect:../list";
	}  */

}       