package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.Product;
import Repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}
   
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Product getProductById(int id) {
		return productRepository.findById(id).orElse(null);
		
	}	
	
	public String deleteProductById(int id) {
		productRepository.deleteById(id);
		return "Product Removed "+id;
	}	
	
}
