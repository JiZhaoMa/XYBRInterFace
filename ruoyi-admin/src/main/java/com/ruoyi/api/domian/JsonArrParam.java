package com.ruoyi.api.domian;

import java.util.List;

public class JsonArrParam {
    private List<Material> materialList;
    private List<Product> productList;

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
