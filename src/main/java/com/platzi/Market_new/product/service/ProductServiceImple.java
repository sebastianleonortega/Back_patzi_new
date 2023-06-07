package com.platzi.Market_new.product.service;

import com.platzi.Market_new.product.dto.ProductDto;
import com.platzi.Market_new.product.entity.Product;
import com.platzi.Market_new.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImple implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDto> getAllProduct(){
        return productRepository.findAll().stream().map(product -> {
            return modelMapper.map(product,ProductDto.class);
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDto> getProductId(Integer idProduct) {

        return Optional.ofNullable(productRepository.getProductoId(idProduct).map(product -> {
            return modelMapper.map(product, ProductDto.class);
                }).orElseThrow(() -> new IllegalArgumentException("El producto no existe"))
        );
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        if (existsByProductNombre(productDto.getProductName())){
            throw new IllegalArgumentException("Y existe un producto con este nombre");
        }
        try {
            return modelMapper.map(productRepository.save(modelMapper.map(productDto, Product.class)),ProductDto.class);
        }catch (Exception ex){
            throw new IllegalArgumentException("JSON mal estructurado");
        }
    }

    @Override
    public ProductDto updateProduct(Integer idProduct, ProductDto productDto) {
        if (!existsByProductNombre(productDto.getProductName())){
            return productRepository.findById(idProduct).map(producto -> {
                producto.setProductName((productDto.getProductName()!= null)?productDto.getProductName():producto.getProductName());
                producto.setQuantityStock((productDto.getQuantityStock()!=null)?productDto.getQuantityStock():producto.getQuantityStock());
                producto.setState(productDto.getState());
               producto.setPriceSale((productDto.getPriceSale()!=0)? productDto.getPriceSale() : producto.getPriceSale());
                return modelMapper.map(productRepository.save(producto),ProductDto.class);
            }).orElseThrow(()-> new IllegalArgumentException("no se encontro el producto a actualizar"));
        }
        throw new IllegalArgumentException("Ya existe un producto con este nombre");
    }

    @Override
    public Boolean deleteProduct(Integer idProduct) {
        if(productRepository.findById(idProduct).isPresent()){
            productRepository.deleteById(idProduct);
            return true;
        }
        return false;
    }

    @Override
    public Boolean existsByProductNombre(String productNombre) {
        return productRepository.existsByProductName(productNombre);
    }

    @Override
    public List<ProductDto> getProductByCategory(Integer idCategory) {
        return productRepository.findByIdCategory(idCategory).stream().map(product -> {
            return modelMapper.map(product, ProductDto.class);
        }).collect(Collectors.toList());
    }


}
