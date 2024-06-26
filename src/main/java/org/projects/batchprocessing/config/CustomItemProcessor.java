package org.projects.batchprocessing.config;

import org.projects.batchprocessing.model.Product;
import org.springframework.batch.item.ItemProcessor;

public class  CustomItemProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product item) throws Exception {

        try{
            System.out.println("item.getDiscount() : " + item.getDiscount());
            int discountPercentage = Integer.parseInt(item.getDiscount());
            double originalPrice = Double.parseDouble(item.getPrice());
            double discount = ((double) discountPercentage /100)*originalPrice;
            double finalPrice = originalPrice-discount;
            item.setDiscountedPrice(String.valueOf(finalPrice));
        } catch (NumberFormatException exception){
            exception.printStackTrace();
        }
        return item;
    }
}
