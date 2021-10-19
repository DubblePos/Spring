package kr.co.sboard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.ArticleVo;

@Repository
public interface BoardDao {

	public void insertArticle(ArticleVo vo);
	public ArticleVo selectArticle(int seq);
	public List<ArticleVo> selectArticles();
	public void updateArticle(int seq);	 //int seq 글번호로 삭제 및 업데이트
	public void deleteArticle(int seq);
	
}