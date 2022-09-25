package com.example.springwebstore.Mapper;

import com.example.springwebstore.DTO.ProductDTO;
import com.example.springwebstore.Data.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-23T21:46:26+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( dto.getId() );
        product.title( dto.getTitle() );
        product.price( dto.getPrice() );

        return product.build();
    }

    @Override
    public ProductDTO fromProduct(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( product.getId() );
        productDTO.setTitle( product.getTitle() );
        productDTO.setPrice( product.getPrice() );

        return productDTO;
    }

    @Override
    public List<Product> toProductList(List<ProductDTO> productDTOS) {
        if ( productDTOS == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productDTOS.size() );
        for ( ProductDTO productDTO : productDTOS ) {
            list.add( toProduct( productDTO ) );
        }

        return list;
    }

    @Override
    public List<ProductDTO> fromProductList(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( products.size() );
        for ( Product product : products ) {
            list.add( fromProduct( product ) );
        }

        return list;
    }
}
