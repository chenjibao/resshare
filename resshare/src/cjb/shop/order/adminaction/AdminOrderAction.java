package cjb.shop.order.adminaction;


import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cjb.shop.order.domain.Order;
import cjb.shop.order.domain.OrderItem;
import cjb.shop.order.service.OrderService;
import cjb.shop.utils.PageBean;
/**
 *@author chenjibao
 *@date2018年4月9日下午9:17:04
 *@description:后台订单管理的acton
 */
public class AdminOrderAction extends ActionSupport implements ModelDriven<Order>{
	//模型
	private Order order=new Order();
	//注入订单的service
	private OrderService orderService;
	//注入page参数
	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public Order getModel() {
		return order;
	}
	//带分页的查询所有订单的方法
	public String findAll(){
		PageBean<Order> pageBean=orderService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAllSuccess";
	}
	// 根据订单的id查询订单项:
	public String findOrderItem(){
		// 根据订单id查询订单项:
		List<OrderItem> list = orderService.findOrderItem(order.getOid());
		// 显示到页面:
		ActionContext.getContext().getValueStack().set("list", list);
		// 页面跳转
		return "findOrderItem";
	}
	//修改订单状态（发货）
	public String updateState(){
		//先查询再修改
		order=orderService.findByOid(order.getOid());
		order.setState(3);
		orderService.update(order);
		return "updateSuccess";
	}
	
}
