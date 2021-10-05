package br.com.giovanederenevick.lazyloadingsolving.repositories;

import br.com.giovanederenevick.lazyloadingsolving.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
