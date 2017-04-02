package kr.ac.hansung.cse.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.hansung.cse.model.Product;
import kr.ac.hansung.cse.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProductService productService;

	@RequestMapping
	public String adminPage() {
		return "admin";
	}

	@RequestMapping("/productInventory")
	public String getProducts(Model model) {
		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);
		return "productInventory";
	}

	@RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.GET)
	public String addProduct(Model model) {
		Product product = new Product();
		product.setCategory("��ǻ��");
		model.addAttribute("product", product);
		return "addProduct";
	}

	@RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.POST)
	public String addProductPost(@Valid Product product, BindingResult result, HttpServletRequest request) {
		// @Valid �� �Ѿ�� ��ü�� ������ �ǰ� ����� BindingResult �� �ڵ����� ���� �ȴ�.
		// View �� Product �� BindingResult �� �Ѵ� �Ѿ�� ������ Ʋ�� ��� �����Է� ���� �������� �ʰ� form �� �����ȴ�.
		// ����ڰ� �Է��� form data �� Product ��ü�� data binding �Ǽ� ���´�.
		
		if(result.hasErrors()){
			System.out.println("=========Form data has some Errors========");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors){
				System.out.println(error.getDefaultMessage());
			}
			
			return "addProduct";
		}
		
		
		// ---------- ImageFile �����ϴ� ����------------
		MultipartFile productImage = product.getProductImage();
		// request �� ��û�� ���� root directory �� �����´�.
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path savePath = Paths.get(rootDirectory+"\\resources\\images\\"+productImage.getOriginalFilename());
		if(productImage != null && !productImage.isEmpty()){
			try{
				// ������ �����Ҷ��� transforTo �޼ҵ� ���
				productImage.transferTo(new File(savePath.toString()));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// ------------------------------------------
		
		product.setImageFilename(productImage.getOriginalFilename());		
		
		if (!productService.addProduct(product)) {
			System.out.println("Adding Product Cannot be done");
		}
		// �ٷ� productInventory �� ȣ���ϸ� db���� �������� �����Ƿ� �ٽ� redirect �Ͽ� db ���� �� ���������� �Ѵ�.
		return "redirect:/admin/productInventory";
	}

	@RequestMapping("productInventory/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, HttpServletRequest request) {

		// ---------- ImageFile �����ϴ� ����------------
		
		Product product = productService.getProductById(id);
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path path = Paths.get(rootDirectory+"\\resources\\images\\"+product.getImageFilename());
		// File �� �����ϴ��� �˻�
		if(Files.exists(path)){
			try{
				// File �� �����ϸ� ����
				Files.delete(path);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		// ------------------------------------------	
		
		
		// {id} ���� @PathVariable�� ���� �ǰ� �ȴ�.
		if (!productService.deleteProductById(id)) {
			System.out.println("Deleting Product Cannot be done");
		}
		return "redirect:/admin/productInventory";
	}

	@RequestMapping(value = "productInventory/editProduct/{id}", method = RequestMethod.GET)
	public String editProduct(@PathVariable int id, Model model) { 
		// {id} ���� @PathVariable �� ���� �ǰԵȴ�.

		Product product = productService.getProductById(id);

		model.addAttribute("product", product);

		return "editProduct";
	}

	@RequestMapping(value = "productInventory/editProduct", method = RequestMethod.POST)
	public String editProductPost(@Valid Product product, BindingResult result, HttpServletRequest request) { 
		// View �� Product �� BindingResult �� �Ѵ� �Ѿ�� ������ Ʋ�� ��� �����Է� ���� �������� �ʰ� form �� �����ȴ�.
		
		if(result.hasErrors()){
			System.out.println("=========Form data has some Errors========");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors){
				System.out.println(error.getDefaultMessage());
			}
			
			return "editProduct";
		}
		

		// ---------- ImageFile �����ϴ� ����------------
		MultipartFile productImage = product.getProductImage();
		// request �� ��û�� ���� root directory �� �����´�.
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path savePath = Paths.get(rootDirectory+"\\resources\\images\\"+productImage.getOriginalFilename());
		if(productImage != null && !productImage.isEmpty()){
			try{
				// ������ �����Ҷ��� transforTo �޼ҵ� ���
				productImage.transferTo(new File(savePath.toString()));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// ------------------------------------------
		
		product.setImageFilename(productImage.getOriginalFilename());	
		
		
		if (!productService.editProduct(product)) {
			System.out.println("Editing Product Cannot be done");
		}

		return "redirect:/admin/productInventory";
	}

}
