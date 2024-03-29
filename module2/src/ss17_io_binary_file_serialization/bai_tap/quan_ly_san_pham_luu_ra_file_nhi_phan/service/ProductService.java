package ss17_io_binary_file_serialization.bai_tap.quan_ly_san_pham_luu_ra_file_nhi_phan.service;

import ss17_io_binary_file_serialization.bai_tap.quan_ly_san_pham_luu_ra_file_nhi_phan.model.Product;
import ss17_io_binary_file_serialization.bai_tap.quan_ly_san_pham_luu_ra_file_nhi_phan.repository.ProductRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    static Scanner sc = new Scanner(System.in);
    static ProductRepo productRepo = new ProductRepo();
    static List<Product> productsList = new ArrayList<>();
    static Product product = new Product();
    public static void setProductsList(List<Product> productsLists) {
        productsList = productsLists;
    }

    @Override
    public void add() {
        System.out.println("Thêm mới sản phẩm:");
        System.out.print("Nhập id sản phẩm: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên sản phẩm: ");
        String name = sc.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = sc.nextLine();
        System.out.print("Nhập mô tả sản phẩm: ");
        String describe = sc.nextLine();
        product = new Product(id, name, price, manufacturer, describe);
        productsList.add(product);
    }

    @Override
    public void display() {
        for (Product p : productsList) {
            System.out.println(p);
        }
    }

    @Override
    public void search() {
        System.out.print("Nhập id sản phẩm cần tìm: ");
        int id = Integer.parseInt(sc.nextLine());
        productRepo.search(id);
    }
    public void save(){
        productRepo.save(productsList);
    }
}
