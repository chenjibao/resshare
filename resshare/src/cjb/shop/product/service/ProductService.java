package cjb.shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cjb.shop.product.dao.ProductDao;
import cjb.shop.product.domain.Product;
import cjb.shop.utils.PageBean;
/**
 * @author chenjibao
 *@date2018年4月3日下午9:08:49
 *@description:商品的业务层类
 */
@Transactional
public class ProductService {
	//注入ProductDao
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	/**
	 * 首页上热门商品的查询
	 * @return
	 */
	public List<Product> findHot() {
		return productDao.findHot();
	}
	/**
	 * 首页最新商品查询
	 * @return
	 */
	public List<Product> findNew() {
		return productDao.findNew();
	}
	/**
	 * 根据id查询商品
	 * @param pid
	 * @return
	 */
	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}
	/**
	 * 根据cid和当前页数来查询商品
	 * @param cid
	 * @param page
	 * @return
	 */
	public PageBean<Product> findByPageCid(Integer cid, int page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示记录数
		int limit=8;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount=0;
		totalCount=productDao.findTotalCountByCid(cid);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage=0;
//		totalPage=(int) Math.ceil(totalCount/limit);向上取整
		if(totalCount/limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		
		//设置每页显示的数据集合
		int begin=(page-1)*limit;
		List<Product> list=productDao.findByPageCid(cid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	/**
	 * 根据二级分类id查询商品
	 * @param csid
	 * @param page
	 * @return
	 */
	public PageBean<Product> findByPageCsid(Integer csid, int page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示记录数
		int limit=8;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount=0;
		totalCount=productDao.findTotalCountByCsid(csid);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage=0;
//		totalPage=(int) Math.ceil(totalCount/limit);向上取整
		if(totalCount/limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		
		//设置每页显示的数据集合
		int begin=(page-1)*limit;
		List<Product> list=productDao.findByPageCsid(csid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	//业务层分页查询商品的方法
	public PageBean<Product> findByPage(Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 8;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:
		// 从哪开始:
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}
	//业务层将商品保存到数据
	public void save(Product product) {
		productDao.save(product);
	}
	//删除商品的方法
	public void delete(Product product) {
		productDao.delete(product);
	}
	//业务层修改商品的方法
	public void update(Product product) {
		productDao.update(product);
	}
	public PageBean<Product> findByProductPartName(String searchkey, int page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示记录数
		int limit=8;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount=0;
		totalCount=productDao.findTotalCountBySearchkey(searchkey);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage=0;
//		totalPage=(int) Math.ceil(totalCount/limit);向上取整
		if(totalCount/limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		
		//设置每页显示的数据集合
		int begin=(page-1)*limit;
		List<Product> list=productDao.findByPageSearchkey(searchkey,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	

}
