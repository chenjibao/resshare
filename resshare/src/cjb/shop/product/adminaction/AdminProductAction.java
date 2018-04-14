package cjb.shop.product.adminaction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import com.mchange.io.FileUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cjb.shop.categorysecond.domain.CategorySecond;
import cjb.shop.categorysecond.service.CategorySecondService;
import cjb.shop.product.domain.Product;
import cjb.shop.product.service.ProductService;
import cjb.shop.utils.PageBean;
/**
 *@author chenjibao
 *@date2018年4月8日下午10:23:27
 *@description:后台商品管理的Action
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product>{
	//模型驱动
	private Product product=new Product();
	//注入商品的service
	private ProductService productService;
	//注入page
	private Integer page;
	//注入二级分类的service
	private CategorySecondService categorySecondService;
	// 文件上传需要的三个属性:
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public Product getModel() {
		return product;
	}
	//查询所有商品的方法
//	adminProduct_findAll
	public String findAll(){
		//获取pageBean
		PageBean<Product> pageBean=productService.findByPage(page);
		//将数据保存到值栈中，然后在页面中显示
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		//页面跳转
		return "findAll";
	}
	
	//跳转到添加页面的方法
	public String addPage(){
		//查询所有的二级分类
		List<CategorySecond> csList=categorySecondService.findAll();
		//商品的集合保存到值栈中
		ActionContext.getContext().getValueStack().set("csList", csList);
		//页面跳转
		return "addPageSuccess";
	}
	// 保存商品的方法:
		public String save() throws IOException {
			// 将提交的数据添加到数据库中.
			product.setPdate(new Date());
			// product.setImage(image);
			if(upload != null){
				// 将商品图片上传到服务器上.
				// 获得上传图片的服务器端路径.
				String path = ServletActionContext.getServletContext().getRealPath(
						"/products");
				// 创建文件类型对象:
				File diskFile = new File(path + "//" + uploadFileName);
				// 文件上传:
				FileUtil.copyFile(upload, diskFile);
				product.setImage("products/" + uploadFileName);
			}
			productService.save(product);
			return "saveSuccess";
		}
		
		//删除商品的方法
		public String delete(){
			//先查询再删除
			product=productService.findByPid(product.getPid());
			//删除商品的图片
			String path=product.getImage();
			if(path!=null){
				String realPath=ServletActionContext.getServletContext().getRealPath("/"+path);
				System.out.println(realPath);
				File file=new File(realPath);
				file.delete();
			}
			productService.delete(product);
			return "deleteSuccess";
		}
		//跳转到编辑页面的方法（带数据跳转）
		public String edit(){
			//根据商品的id查询该商品，为了将商品信息显示到编辑页面上
			product=productService.findByPid(product.getPid());
			//查询所有二级分类的集合
			List<CategorySecond> csList=categorySecondService.findAll();
			//商品的集合保存到值栈中
			ActionContext.getContext().getValueStack().set("csList", csList);
			return "editSuccess";
		}
		// 修改商品的方法
		public String update() throws IOException {
			// 将信息修改到数据库
			product.setPdate(new Date());
			
			// 上传:
			if(upload != null ){
				String delPath = ServletActionContext.getServletContext().getRealPath(
						"/" + product.getImage());
				//先删除原来的图片
				File file = new File(delPath);
				file.delete();
				// 获得上传图片的服务器端路径.
				String path = ServletActionContext.getServletContext().getRealPath(
						"/products");
				// 创建文件类型对象:
				File diskFile = new File(path + "//" + uploadFileName);
				// 文件上传:
				FileUtil.copyFile(upload, diskFile);
				product.setImage("products/" + uploadFileName);
			}
			productService.update(product);
			// 页面跳转
			return "updateSuccess";
		}
}
