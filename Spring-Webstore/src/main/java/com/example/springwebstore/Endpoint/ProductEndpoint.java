package com.example.springwebstore.Endpoint;

import com.example.springwebstore.DTO.ProductDTO;
import com.example.springwebstore.Service.ProductService;
import com.example.springwebstore.we.products.GetProductsRequest;
import com.example.springwebstore.we.products.GetProductsResponse;
import com.example.springwebstore.we.products.ProductsWS;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;

@Endpoint
public class ProductEndpoint {
    public static final String NAMESPACE_URL = "http://polozov.com/springeshop/ws/products";

    private final ProductService productService;

    public ProductEndpoint(final ProductService productService) {
        this.productService = productService;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getProductsRequest")
    @ResponsePayload
    public GetProductsResponse getGreeting(@RequestPayload GetProductsRequest request)
            throws DatatypeConfigurationException {
        GetProductsResponse response = new GetProductsResponse();
        productService.getAll()
                .forEach(dto -> response.getProducts().add(createProductWS(dto)));
        return response;
    }

    private ProductsWS createProductWS(ProductDTO dto){
        ProductsWS ws = new ProductsWS();
        ws.setId(dto.getId());
        ws.setPrice(dto.getPrice());
        ws.setTitle(dto.getTitle());
        return ws;
    }
}
