package cjb.shop.cart.action;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cjb.shop.cart.domain.Cart;
import cjb.shop.cart.domain.CartItem;
import cjb.shop.product.domain.Product;
import cjb.shop.product.service.ProductService;

public class CartAction extends ActionSupport {
		//注入商品编号pid
		private Integer pid;
		//注入商品数量count
		private Integer count;
		//注入ProductService
		private ProductService productService;
		
		public void setProductService(ProductService productService) {
			this.productService = productService;
		}
		public void setPid(Integer pid) {
			this.pid = pid;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
	/**
	 * 将购物项添加到购物车
	 * @return
	 */
	public String addCart() {
		// 创建一个CartItem对象
		CartItem cartItem = new CartItem();
		//设置数量
		cartItem.setCount(count);
		//设置商品
		Product product=productService.findByPid(pid); 
		cartItem.setProduct(product);
		//将购物项添加到购物车
		Cart cart=getCart();
		cart.addCartItem(cartItem);
		return "addCart";
	}
	//清空购物车
	public String clearCart(){
		Cart cart=getCart();
		cart.clearCart();
		return "clearCart";
	}
	//我的购物车
	public String myCart(){
		return "myCart";
	}
	//获取购物车
	private Cart getCart() {
		Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			ServletActionContext.getRequest().getSession()
					.setAttribute("cart", cart);
		}
		return cart;
	}
	public String removeCart(){
		Cart cart=getCart();
		cart.removeCartItem(pid);
		return "removeCart";
	}
	

}
