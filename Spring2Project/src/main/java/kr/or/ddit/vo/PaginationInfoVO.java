package kr.or.ddit.vo;

import java.util.List;

import lombok.Data;

@Data
public class PaginationInfoVO<T> {
	private int totalRecord;	// 총 게시글 수
	private int totalPage;		// 총 페이지 수
	private int currentPage;	// 현재 페이지
	private int screenSize = 10;		// 페이지 당 게시글 수
	private int blockSize = 5;		// 페이지 블록 수
	private int startRow;		// 시작 row
	private int endRow;			// 끝 row
	private int startPage;		// 시작 페이지
	private int endPage;		// 끝 페이지
	private List<T> dataList;	// 결과를 넣을 데이터 리스트

	private String searchType;	// 검색 타입	
	private String searchWord;	// 검색 단어
	
	public PaginationInfoVO() {}
	
	// PaginationInfoVO 객체를 만들 때, 한 페이지당 게시글 수와 페이지 블록 수를
	// 원하는 값으로 초기화 할 수 있다.
	
	public PaginationInfoVO(int screenSize, int blockSize) {
		super();
		this.screenSize = screenSize;
		this.blockSize = blockSize;
	}
	
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		// ceil은 올림
		totalPage = (int)Math.ceil(totalRecord / (double)screenSize);
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		endRow = currentPage * screenSize;		// 끝 row = 현재 페이지 * 한 페이지당 게시글 수
		startRow = endRow - (screenSize - 1);	// 시작 row = 끝 row - (한 페이지당 게시글 수 - 1)
		
		// 마지막 페이지 = (현재 페이지 + (페이지 블록 사이즈 - 1)) / 페이지 블록 사이즈 * 페이지 블록 사이즈
		// blockSize * blockSize는 1,2,3,4,5,,,, 페이지마다 실수계산이 아닌 정수 계산을 이용해 endPage를 구한다.
		endPage = (currentPage + (blockSize - 1)) / blockSize * blockSize;
		startPage = endPage - (blockSize - 1);
		
	}
	
	public String getpagingHTML() {
		StringBuffer html = new StringBuffer();
	    // 현재 사용 중인 부트스트랩에서 사용하는 페이징 class명
		html.append("<ul class='pagination pagination-sm m-0 float-right'>");
		
		/*
		 * startPage는 1,6,11 이런 숫자로 증가해서 올라갑니다.
		 * 1-5범위 안에 있는 경우 Prev가 생성되지 않는다
		 * 6범위부터 Prev가 생성되는 조건이므로 Prev 버튼이 생성된다.
		 */
		if(startPage > 1) {
			html.append("<li class='page-item'><a href = '' class='page-link' data-page='"
					+ (startPage - blockSize) + "'>Prev</a></li>");
		}
		
		// 반복문 내 조건은 총 페이지가 있고 현재 페이지에 따라서 endPage 값이 결정된다.
		// 총 페이지가 14개고 현재 페이지가 9페이지라면 넘어가야할 페이지가 남아 있는것이기 때문에
		// endPage 만큼 반복되고 넘어가야할 페이지가 존재하지 않는 상태라면 마지막 페이지가 포함되어 있는
		// block 영역이므로 totalPage만큼 반복한다.
		for(int i = startPage; i <= (endPage < totalPage ? endPage : totalPage); i++) {
			if(i == currentPage) {
				html.append("<li class='page-item active'><span class='page-link'>"
						+ i + "</span></li>");
			}else {
				html.append("<li class='page-item'><a href='' class='page-link' data-page='"
						+ i + "'>" + i + "</a></li>");
			}
		}
		
	    // 다음 버튼 활성화 여부
		if(endPage < totalPage) {
			html.append("<li class='page-item'><a href='' class='page-link' data-page='"
					+ (endPage + 1 ) + "'>Next</a></li>");
		}
		
		html.append("</ul>");
		return html.toString();
	}
}
