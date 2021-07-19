
  package za.co.eesoco.repository;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  
  import za.co.eesoco.domain.User;
  
  public interface UserRepository extends JpaRepository<User, Long> {
  
  }
 