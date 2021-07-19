package za.co.eesoco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.eesoco.domain.Product;
import za.co.eesoco.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	public List<Product> listAll() {
		return productRepo.findAll();
	}

	public void save(Product product) {
		productRepo.save(product);
	}

	public Product getProduct(int id) {
		return productRepo.findById(id).get();

	}

	public void deleteProduct(int id) {
		productRepo.deleteById(id);
	}

}
