package com.cloudaidatastream.shoppingmart.service.serviceimpl;

import com.cloudaidatastream.shoppingmart.dto.ProductDTO;
import com.cloudaidatastream.shoppingmart.dto.SuccessResponseDTO;
import com.cloudaidatastream.shoppingmart.enums.Category;
import com.cloudaidatastream.shoppingmart.exceptions.ConflictException;
import com.cloudaidatastream.shoppingmart.exceptions.DataNotFoundException;
import com.cloudaidatastream.shoppingmart.exceptions.InvalidInputException;
import com.cloudaidatastream.shoppingmart.models.Product;
import com.cloudaidatastream.shoppingmart.repositories.ProductRepository;
import com.cloudaidatastream.shoppingmart.service.ProductService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hi on 31-01-2018.
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

	/*
	 * @Autowired private DozerBeanMapper dozerBeanMapper;
	 */
    @Override
    public String addProduct(ProductDTO dto) {
		/*
		 * Product product = dozerBeanMapper.map(dto, Product.class);
		 * productRepository.save(product);
		 */
        return "SUCCESS";
    }

    @Override
    public String uploadProducts(List<ProductDTO> dtos) throws ConflictException {
		/*
		 * for (ProductDTO dto: dtos) { try{ Product product = dozerBeanMapper.map(dto,
		 * Product.class); productRepository.save(product); } catch
		 * (DataIntegrityViolationException e){ throw new
		 * ConflictException("Duplicate Product Barcode"); } };
		 */
        return "SUCCESS";
    }

    @Override
    public ProductDTO findProductByCode(final String productId) throws InvalidInputException {
		
    	if (StringUtils.isBlank(productId)) {
			throw new InvalidInputException("Product id supplied is Empty/null");
		}
		ProductDTO productDTO = new ProductDTO();
		try {
			Product product = productRepository.findByCode(productId);
			BeanUtils.copyProperties(productDTO, product);
		} catch (IllegalAccessException except) {
			LOGGER.error("Illegal access in copy of entity to bean", except);
		} catch (InvocationTargetException except) {
			LOGGER.error("Invocation Target Exceptionin in copy of entity to bean", except);
		}
		return productDTO;
    }

    @Override
    public List<ProductDTO> retrieveProducts() {

		/*
		 * List<Product> products = productRepository.findAll();
		 * 
		 * List<ProductDTO> productDTOS = new ArrayList<>();
		 * 
		 * for (Product product: products) {
		 * productDTOS.add(dozerBeanMapper.map(product, ProductDTO.class)); }
		 */

        return null;
    }

    
	@Override
    public String updateProduct(ProductDTO dto, String productId) throws DataNotFoundException {

        Product product = productRepository.findByCode(productId);

        if(product != null) {        	
            product.setName(dto.getName());
            product.setCode(dto.getCode());            
            //product.setCategory(product.getCategory().get));
            product.setMrp_price(dto.getMrp_price());
            product.setImage(dto.getImage());
            product.setDetail(dto.getDetail());
            product.setOther_info(dto.getOther_info());
            productRepository.flush();

            return "SUCCESS";
        } else {
            throw new DataNotFoundException("Product Not Found");
        }
    }

    @Override
    public String deleteProduct(String productId) throws DataNotFoundException {

        Product product = productRepository.findByCode(productId);

        if(product != null){
            productRepository.delete(product);
            return "SUCCESS";
        } else {
            throw  new DataNotFoundException("Product Not Found");
        }



    }
}
