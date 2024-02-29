package org.clients;

import org.entities.*;
import org.repos.*;

import java.sql.SQLException;
import java.sql.Time;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       // Example for CategoriesRepository
        CategoriesRepository categoriesRepository = new CategoriesRepository();
        Category category = new Category("aa", "bla bla");
//
//        // Insert
//        System.out.println(categoriesRepository.insert(category));
//
//        // Update
//        category.setId(5);
//        category.setDescription("Updated description");
//        System.out.println( categoriesRepository.update(category));
//
//        // Select
//        System.out.println(categoriesRepository.select(1));
//
//        // Select All
//        List<Category> allCategories = categoriesRepository.selectAll();
//        System.out.println("All Categories: " + allCategories);
//
//        System.out.println(categoriesRepository.delete(5));
//
//        // Example for BranchRepository
        BranchRepository branchRepository = new BranchRepository();
        Branch branch = new Branch(
                "Example Branch",
                "Building 123",
                "Main Street",
                Time.valueOf("09:00:00"),
                Time.valueOf("17:00:00"),
                "123-456-7890",
                1
        );
//
//        // Insert
//        branchRepository.insert(branch);
//
//        // Update
//        branch.setId(3);
//        branch.setName("Updated Branch");
//        System.out.println(branchRepository.update(branch));
//
//        // Select
//        System.out.println(branchRepository.select(3));
//
//        // Select All
//        List<Branch> allBranches = branchRepository.selectAll();
//        System.out.println("All Branches: " + allBranches);
//
//        // Delete (commented to avoid actual deletion)
//        // branchRepository.delete(1);
//
//        // Example for BrandRepository
        BrandRepository brandRepository = new BrandRepository();
        Brand brand = new Brand("b1", "http://example.com/logo");
//
//        // Insert
//        brandRepository.insert(brand);
//
//        // Update
//        brand.setName("Updated Brand");
//        brandRepository.update(brand);
//
//        // Select
//        System.out.println(brandRepository.select(1));
//
//        // Select All
//        List<Brand> allBrands = brandRepository.selectAll();
//        System.out.println("All Brands: " + allBrands);
//
//        // Delete (commented to avoid actual deletion)
//        // brandRepository.delete(1);
//
//        // Example for CityRepository
        CityRepository cityRepository = new CityRepository();
        City city = new City("Example City");
//
//        // Insert
//        cityRepository.insert(city);
//
//        // Update
//        city.setName("Updated City");
//        cityRepository.update(city);
//
//        // Select
//        System.out.println(cityRepository.select(1));
//
//        // Select All
//        List<City> allCities = cityRepository.selectAll();
//        System.out.println("All Cities: " + allCities);
//
//        // Delete (commented to avoid actual deletion)
//        // cityRepository.delete(1);
//
//        // Example for ProductRepository
        ProductRepository productRepository = new ProductRepository();
        Product product = new Product("Product1", "Description", "http://example.com/pic", 1, 1);
//
//        // Insert
//        productRepository.insert(product);
//
//        // Update
//        product.setName("Updated Product");
//        productRepository.update(product);
//
//        // Select
//        System.out.println(productRepository.select(1));
//
//        // Select All
//        List<Product> allProducts = productRepository.selectAll();
//        System.out.println("All Products: " + allProducts);
//
//        // Delete (commented to avoid actual deletion)
//        // productRepository.delete(1);
    }
}
