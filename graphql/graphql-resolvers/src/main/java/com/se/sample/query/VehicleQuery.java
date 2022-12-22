package com.se.sample.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import com.se.sample.dao.entity.PricingOptions;
import com.se.sample.dao.entity.ProductPage;
import com.se.sample.dao.entity.Vehicle;
import com.se.sample.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
@Component
public class VehicleQuery implements GraphQLQueryResolver {
    @Autowired
    private VehicleService vehicleService;
    public List<Vehicle> getVehicles(final int count) {
        return this.vehicleService.getAllVehicles(count);
    }
    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleService.getVehicle(id);
    }



    public ProductPage findProductPageByPartNumber(String brand, String environment, String locale, String currency,
                                                   String partNumber, String categoryId, String contentType, PricingOptions pricingOptions)
    {
        ProductPage page = new ProductPage(brand, environment, locale, currency);
        page.setContentType(contentType);
        page.setPartNumber(partNumber);
        page.setCategoryId(categoryId);
        page.setPricingOptions(pricingOptions);

        page.setUrl("default url");
        page.setId("id_0001");
        page.setCategoryId("id_from_query_resolver");
        page.setViewport("viewport");

        return page;
    }
}