/*
 * ProductCategoryDto.java
 *
 * Created on Mar 13, 2024, 14.51
 */
package com.example.demo.product.adapter.in.restapi.dto;

import com.example.demo.product.application.entity.ProductCategory;

/**
 * Merepresentasikan dokumen JSON untuk objek ProductCategory yang tersimpan dalam sistem.
 * Kelas ini diasumsikan akan diubah otomatis menjadi JSON oleh Spring Framework.
 *
 * TODO: Ubah kelas ini menjadi record.
 * Apakah seperti ini ?
 * @author Irfin A., Nicholas Z.
 */
//public class ProductCategoryDto
//{
//    public int system_id;
//    public String name;
//    public String description;
//    public boolean is_active;
//
//    /**
//     * Mengubah objek ProductCategory menjadi DTO.
//     *
//     * @param _pc
//     * @return
//     */
//    public static ProductCategoryDto from(ProductCategory _pc)
//    {
//        var dto = new ProductCategoryDto();
//        dto.system_id = _pc.getSystemId();
//        dto.name = _pc.getName();
//        dto.description = _pc.getDescription();
//        dto.is_active = _pc.isActive();
//
//        return dto;
//    }
//}
public record ProductCategoryDto(int systemId, String name, String description, boolean isActive) {

    public static ProductCategoryDto from(ProductCategory pc) {
        return new ProductCategoryDto(
                pc.getSystemId(),
                pc.getName(),
                pc.getDescription(),
                pc.isActive()
        );
    }
}

