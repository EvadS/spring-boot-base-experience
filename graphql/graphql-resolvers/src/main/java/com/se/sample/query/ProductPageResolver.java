package com.se.sample.query;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.se.sample.dao.entity.ProductPage;
import com.se.sample.service.QueryResolverCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductPageResolver extends QueryResolverCommon implements GraphQLResolver<ProductPage> {

    private static final Logger logger = LoggerFactory.getLogger(ProductPageResolver.class);

    public String getContent(ProductPage page)
    {
        logger.info("get content for product page:{}" , page);
        String contents = "contents string";

        return contents;
    }

    public String  setCategoryId(ProductPage page){
        logger.info("set category id  in GraphQLResolver" );
        // TODO: some logic

        String category = "category_0000001_resolver";


        return category;
    }



}
