package com.platzi.Market_new.product.service;

import com.platzi.Market_new.Exception.exceptions.MessageGeneric;
import com.platzi.Market_new.product.dto.ProductDto;
import com.platzi.Market_new.product.entity.Producto;
import com.platzi.Market_new.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Optional<ProductDto> getProductId(Integer idProducto) {

        return Optional.ofNullable(productRepository.getProductoId(idProducto).map(producto -> {
            return modelMapper.map(producto, ProductDto.class);
                }).orElseThrow(() -> new IllegalArgumentException("El producto no existe"))
        );
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        if (existsByProductNombre(productDto.getNombre())){
            throw new IllegalArgumentException("Y existe un producto con este nombre");
        }
        try {
            return modelMapper.map(productRepository.save(modelMapper.map(productDto, Producto.class)),ProductDto.class);
        }catch (Exception ex){
            throw new IllegalArgumentException("JSON mal estructurado");
        }
    }

    @Override
    public ProductDto updateProduct(Integer idProducto, ProductDto productDto) {
        if (!existsByProductNombre(productDto.getNombre())){
            return productRepository.findById(idProducto).map(producto -> {
                producto.setNombreProduct((productDto.getNombre()!= null)?productDto.getNombre():producto.getNombreProduct());
                return modelMapper.map(productRepository.save(producto),ProductDto.class);
            }).orElseThrow(()-> new IllegalArgumentException("no se encontro el producto a actualizar"));
        }
        throw new IllegalArgumentException("Ya existe un producto con este nombre");
    }

    @Override
    public Boolean deleteProduct(Integer idProducto) {
        if(productRepository.findById(idProducto).isPresent()){
            productRepository.deleteById(idProducto);
            return true;
        }
        return false;
    }

    @Override
    public Boolean existsByProductNombre(String productNombre) {
        return productRepository.existsByProductNombre(productNombre);
    }


}
