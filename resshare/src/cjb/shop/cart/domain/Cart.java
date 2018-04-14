package cjb.shop.cart.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import cjb.shop.cart.domain.CartItem;

/**
 *@author chenjibao
 *@date2018年4月6日下午7:15:23
 *@description:购物车类
 */
public class Cart implements Serializable{
	//购物项集合Map：key是商品的id，value是购物项CartItem
	private Map<Integer,CartItem> map=new LinkedHashMap<Integer, CartItem>();
	//总计
	private double total;
	
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	public double getTotal() {
		return total;
	}
	/*
	 * 购物车功能
	 */
	//1、将购物项添加到购物车
	public void addCartItem(CartItem cartItem){
		// 判断购物车中是否已经存在该购物项:
				/*
				 *  * 如果存在:
				 *  	* 数量增加
				 *  	* 总计 = 总计 + 购物项小计
				 *  * 如果不存在:
				 *  	* 向map中添加购物项
				 *  	* 总计 = 总计 + 购物项小计
				 */
				// 获得商品id.
				Integer pid = cartItem.getProduct().getPid();
				// 判断购物车中是否已经存在该购物项:
				if(map.containsKey(pid)){
					// 存在
					CartItem _cartItem = map.get(pid);// 获得购物车中原来的购物项
					_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
//					map.put(pid, _cartItem);
				}else{
					// 不存在
					map.put(pid, cartItem);
				}
				// 设置总计的值
				total += cartItem.getSubtotal();
	}
	//2、将购物项从购物车移除
	public void removeCartItem(Integer pid){
		//移除购物项
		CartItem cartItem=map.remove(pid);
		//更新总计
		total-=cartItem.getSubtotal();
	} 
	//3、清空购物车
	public void clearCart(){
		//将map清空
		map.clear();
		//将总计设为0
		total=0;
	}
}
