package kr.co.kmarket.dao;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductOrderVo;

@Repository
public interface ProductOrderDao {

	public void insertOrder(ProductOrderVo vo);
	public void selectOrder();
	public void selectOrders();
	public void updateOrder();
	public void deleteOrder();
}