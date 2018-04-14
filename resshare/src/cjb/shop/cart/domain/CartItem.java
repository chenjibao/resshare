package cjb.shop.cart.domain;

import cjb.shop.product.domain.Product;

/**
 *@author chenjibao
 *@date2018年4月6日下午7:14:50
 *@description:购物项类
 */
public class CartItem {
	private Product product;//购物项中商品
	private int count;//商品数量
	private double subtotal;//商品小计
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return count*product.getShop_price();
	}
}
