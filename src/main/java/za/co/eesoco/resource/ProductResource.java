package za.co.eesoco.resource;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.eesoco.domain.Product;
import za.co.eesoco.service.ProductService;

@RestController
@RequestMapping("/")
public class ProductResource {

	@Autowired
	private ProductService productService;

	
	@GetMapping("/products")
	@CrossOrigin(origins = "*")
	public List<Product> products() {
		return productService.listAll();
	}

	
	@PostMapping("/addProduct")
	@CrossOrigin(origins = "*")
	public void addProduct(@RequestBody Product product) {
		productService.save(product);
	}

	
	@GetMapping("/products/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Product> getProduct(@PathVariable int id) {

		try {
			Product product = productService.getProduct(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {

			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}

	}

	
	@PutMapping("/products/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable int id) {

		try {
			Product productExist = productService.getProduct(id);
			productService.save(product);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/products/{id}")
	@CrossOrigin(origins = "*")
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}
	
}
