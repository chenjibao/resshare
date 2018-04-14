package cjb.shop.product.domain;

import java.util.Date;

import cjb.shop.categorysecond.domain.CategorySecond;
/**
 * @author chenjibao
 *@date2018年4月3日下午9:09:06
 *@description:商品的实体类
 */
public class Product {
	/*`pid` int(11) NOT NULL AUTO_INCREMENT,
	  `pname` varchar(255) DEFAULT NULL,
	  `market_price` double DEFAULT NULL,
	  `shop_price` double DEFAULT NULL,
	  `image` varchar(255) DEFAULT NULL,
	  `pdesc` varchar(255) DEFAULT NULL,
	  `is_hot` int(11) DEFAULT NULL,
	  `pdate` datetime DEFAULT NULL,
	  `csid` int(11) DEFAULT NULL,*/
	private Integer pid;
	private String pname;
	private Double market_price;
	private Double shop_price;
	private String image;
	private String pdesc;
	private Integer is_hot;
	private Date pdate;
	private CategorySecond categorySecond;//商品所属的二级分类
	
	public CategorySecond getCategorySecond() {
		return categorySecond;
	}
	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}
	public Double getShop_price() {
		return shop_price;
	}
	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Integer getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	
	
	

}
