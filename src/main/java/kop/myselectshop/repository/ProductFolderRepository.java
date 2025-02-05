package kop.myselectshop.repository;

import kop.myselectshop.entity.Folder;
import kop.myselectshop.entity.Product;
import kop.myselectshop.entity.ProductFolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductFolderRepository extends JpaRepository<ProductFolder,Long> {
    Optional<ProductFolder> findByProductAndFolder(Product product, Folder folder);
}
