package com.hib.sample.utils;

import java.util.ArrayList;
import java.util.List;

import com.hib.sample.dao.CustomerDao;
import com.hib.sample.dao.ProductDao;
import com.hib.sample.dao.SupplierDao;
import com.hib.sample.model.Customer;
import com.hib.sample.model.Product;
import com.hib.sample.model.ProductDetails;
import com.hib.sample.model.Supplier;

public class RecordUtils {
	
	private CustomerDao employeeDao;
	
	private ProductDao productDao;
	private SupplierDao supplierDao;
	
	
	private Customer emp;
	private Supplier supplierOne;
	private Supplier supplierTwo;
	private Product product_a;
	private Product product_b;
	private Product product_c;
	private Product product_d;
	private Product product_e;
	private ProductDetails pdetails_a;
	private ProductDetails pdetails_b;
	private ProductDetails pdetails_c;
	private ProductDetails pdetails_d;
	private ProductDetails pdetails_e;
	
	
	private List<Product> supplierOneProducts = new ArrayList<Product>();
	private List<Product> supplierTwoProducts = new ArrayList<Product>();
	
	public static final String SUPPLIER_ONE = "supplierOne";
	public static final String SUPPLIER_TWO = "supplierTwo";
	
	public static final String PDETAILS_A_DESC = "pdetails_a: sample product desc";
	public static final String PDETAILS_A_NAME = "pdetails_a: product_a";
	
	public static final String PDETAILS_B_DESC = "pdetails_b: sample product desc";
	public static final String PDETAILS_B_NAME = "pdetails_b: product_b";
	
	public static final String PDETAILS_C_DESC = "pdetails_c: sample product desc";
	public static final String PDETAILS_C_NAME = "pdetails_c: product_c";
	
	public static final String PDETAILS_D_DESC = "pdetails_d: sample product desc";
	public static final String PDETAILS_D_NAME = "pdetails_d: product_d";
	
	public static final String PDETAILS_E_DESC = "pdetails_e: sample product desc";
	public static final String PDETAILS_E_NAME = "pdetails_e: product_e";
	
	public RecordUtils(Object... daos)
	{
		for (Object dao : daos){
			
			if (dao instanceof CustomerDao) {
				employeeDao = (CustomerDao)dao; 
			}
			else if (dao instanceof ProductDao) {
				productDao = (ProductDao)dao; 
			}
			else if (dao instanceof SupplierDao) {
				supplierDao = (SupplierDao)dao; 
			}
			else {
				System.out.println("missing dao");
			}
		}
	}
	
	
	
	public void generateSuppliersProducts()
	{
		supplierOne = new Supplier();
		supplierTwo = new Supplier();
		
		pdetails_a = new ProductDetails();
		pdetails_a.setProductDescription(PDETAILS_A_DESC);
		pdetails_a.setProductName(PDETAILS_A_NAME);
		
		product_a = new Product();
		product_a.setProductDetails(pdetails_a);
		product_a.setSupplier(supplierOne);
		product_a.setSupplier(supplierTwo);
		
		
		pdetails_b = new ProductDetails();
		pdetails_b.setProductDescription(PDETAILS_B_DESC);
		pdetails_b.setProductName(PDETAILS_B_NAME);
		
		product_b = new Product();
		product_b.setProductDetails(pdetails_b);
		product_b.setSupplier(supplierOne);
		
		
		pdetails_c = new ProductDetails();
		pdetails_c.setProductDescription(PDETAILS_C_DESC);
		pdetails_c.setProductName(PDETAILS_C_NAME);
		
		product_c = new Product();
		product_c.setProductDetails(pdetails_c);
		product_c.setSupplier(supplierOne);
		
		
		pdetails_d = new ProductDetails();
		pdetails_d.setProductDescription(PDETAILS_D_DESC);
		pdetails_d.setProductName(PDETAILS_D_NAME);
		
		product_d = new Product();
		product_d.setProductDetails(pdetails_d);
		product_d.setSupplier(supplierTwo);
		
		
		pdetails_e = new ProductDetails();
		pdetails_e.setProductDescription(PDETAILS_E_DESC);
		pdetails_e.setProductName(PDETAILS_E_NAME);
		
		product_e = new Product();
		product_e.setProductDetails(pdetails_e);
		product_e.setSupplier(supplierTwo);	
		
		
		supplierOneProducts.add(product_a);
		supplierOneProducts.add(product_b);
		supplierOneProducts.add(product_c);
		
		supplierTwoProducts.add(product_a);
		supplierTwoProducts.add(product_d);
		supplierTwoProducts.add(product_e);

		supplierOne.setProducts(supplierOneProducts);
		supplierOne.setSupplierName(SUPPLIER_ONE);
		
		supplierTwo.setProducts(supplierTwoProducts);
		supplierTwo.setSupplierName(SUPPLIER_TWO);
		
		
		productDao.makePersistent(product_a);
		productDao.makePersistent(product_b);
		productDao.makePersistent(product_c);
		productDao.makePersistent(product_d);
		productDao.makePersistent(product_e);
		
		
		supplierDao.makePersistent(supplierOne);
		supplierDao.makePersistent(supplierTwo);
	}

}
