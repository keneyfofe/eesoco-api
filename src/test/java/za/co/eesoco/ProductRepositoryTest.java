package za.co.eesoco;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import za.co.eesoco.domain.Product;
import za.co.eesoco.repository.ProductRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	TestEntityManager entityManager;

	@Test
	public void addProduct() {
		Product product = new Product();

		product.setName("Dell XPS ,16GB, 8Gen");
		product.setPrice(34999);
		product.setSize(15);
		product.setColor("Grey white");
		
		Product savedProduct = productRepository.save(product);
		Product existProduct = entityManager.find(Product.class, savedProduct.getId());
		
		assertThat(existProduct.getId()).isEqualTo(product.getId());

	}

}
