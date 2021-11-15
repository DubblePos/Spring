package kr.co.kmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.ProductOrderDao;
import kr.co.kmarket.vo.ProductOrderVo;

@Service
public class ProductOrderService {
	
	@Autowired
	private ProductOrderDao dao;
	
	public void insertOrder(ProductOrderVo vo) {
		dao.insertOrder(vo);
	} //리턴받을 키값이 있지만 void해도된다?? why? mapping 하고 키값이  ProductOrderVo 안에 있는 orderId로 바인딩 되기때문에???
	
	public void insertOrderDetail(int orderId, int productCode, int count) {
		dao.insertOrderDetail(orderId, productCode, count);
	}
	
	public List<ProductOrderVo> selectOrders(int orderId) {
		return dao.selectOrders(orderId);
	}
	
	public void selectOrder() {}
	
	public int updateOrder(ProductOrderVo vo) {
		return dao.updateOrder(vo);
	}
	public void deleteOrder() {}
	
}