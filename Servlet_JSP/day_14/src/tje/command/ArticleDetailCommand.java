package tje.command;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.sql.*;
import tje.jdbc.util.*;
import tje.model.*;
import tje.service.*;

public class ArticleDetailCommand extends Command {
	private String formPage = "/WEB-INF/forms/article_detail.jsp";
	private String submitPage = "/WEB-INF/submits/article_detail.jsp";
	private String errorPage = "/WEB-INF/errors/article_detail.jsp";

	private ArticleDetailSearchService adsService = new ArticleDetailSearchService();
	private ArticleDetailUpdateReadCountService adurcService = new ArticleDetailUpdateReadCountService();
	private CommentListService clService = new CommentListService();

	protected String processForm(HttpServletRequest request, HttpServletResponse response) {

		int article_id = 0;

		try {
			article_id = Integer.parseInt(request.getParameter("article_id"));
		} catch (Exception e) {
			request.setAttribute("errorMsg", "잘못된 접근입니다");
			return errorPage;
		}

		DetailArticle model = new DetailArticle();
		model.setArticle_id(article_id);

		try (Connection conn = ConnectionProvider.getConnection()) {
			HashMap<String, Object> values = new HashMap<>();
			values.put("conn", conn);
			values.put("model", model);

			HashMap<String, Object> resultMap = null;
			if (request.getMethod().equals("GET")) {
				resultMap = adurcService.service(values);
				if (!(Boolean) resultMap.get("result")) {
					request.setAttribute("errorMsg", "조회수 갱신에 에러가 발생했습니다.");
					return errorPage;
				}
			}

			resultMap = adsService.service(values);
			if (!(Boolean) resultMap.get("result")) {
				request.setAttribute("errorMsg", "게시글을 찾을 수 없습니다.");
				return errorPage;
			}

			request.setAttribute("detailArticle", resultMap.get("detailArticle"));

			// 댓글 조회
			Comment comment = new Comment();
			comment.setArticle_id(article_id);
			values.put("model", comment);
			resultMap = clService.service(values);
			request.setAttribute("commentSize", resultMap.get("commentSize"));
			request.setAttribute("commentList", resultMap.get("commentList"));
//			if( !(Boolean)resultMap.get("result") ) {
//				request.setAttribute("errorMsg", "게시글을 찾을 수 없습니다.");
//				return errorPage;
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return formPage;
	}

	// POST 요청일 경우의 처리 로직을 구현하는 메소드
	protected String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		return processForm(request, response);
	}
}
