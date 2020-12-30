package com.javaex.author01;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {
		AuthorDao authorDao = new AuthorDao();
		List<AuthorVo> authorList;
		
		//int count = authorDao.authorInsert("이문열", "경북 영양"); //작가테이블에 데이터 저장
		//System.out.println(count + "건 등록되었습니다.");
		
		//틍록
		AuthorVo authorVo1 = new AuthorVo("이문열", "경북 영양");
		authorDao.authorInsert(authorVo1);

		AuthorVo authorVo2 = new AuthorVo("박경리", "경상남도 통영");
		authorDao.authorInsert(authorVo2); //작가테이블에 데이터 저장
		
		AuthorVo authorVo3 = new AuthorVo("유시민", "17대 국회의원");
		authorDao.authorInsert(authorVo3);
		
		//리스트
		authorList = authorDao.getAuthorList();
		
		//리스트 전체 출력
		System.out.println("===========작가 리스트===========");
		for(int i=0; i<authorList.size();i++) {
			AuthorVo vo = authorList.get(i);
			System.out.println(vo.getAuthorId() + ", " + vo.getAuthorName() + ", " + vo.getAuthorDesc());
		}

		
		//작가 삭제
		authorDao.authorDelete(3);
		
		//리스트출력
		authorList = authorDao.getAuthorList();
		
		System.out.println("===========작가 리스트===========");
		for(int i=0; i<authorList.size();i++) {
			AuthorVo vo = authorList.get(i);
			System.out.println(vo.getAuthorId() + ", " + vo.getAuthorName() + ", " + vo.getAuthorDesc());
		}
		
		
		//작가 수정
		AuthorVo authorVo4 = new AuthorVo(2, "김경리", "제주도");
		authorDao.authorUpdate(authorVo4);
		
		//리스트출력
		authorList = authorDao.getAuthorList();
		
		System.out.println("===========작가 리스트===========");
		for(int i=0; i<authorList.size();i++) {
			AuthorVo vo = authorList.get(i);
			System.out.println(vo.getAuthorId() + ", " + vo.getAuthorName() + ", " + vo.getAuthorDesc());
		}

	}

}
