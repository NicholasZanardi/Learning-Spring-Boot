/*
 * ProductCategoryCtrl.java
 *
 * Created on Mar 13, 2024, 11.58
 */
package com.example.demo.product.adapter.in.restapi;

import com.example.demo.product.adapter.in.restapi.dto.ProductCategoryCreateDto;
import com.example.demo.product.adapter.in.restapi.dto.ProductCategoryDto;
import com.example.demo.product.adapter.in.restapi.mapper.DtoToCmdMapper;
import com.example.demo.product.application.model.ProductCategoryHeaderModel;
import com.example.demo.product.application.port.in.ProductCategoryUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Irfin A, Nicholas Z.
 */
@RestController
@RequestMapping("/api/v1/product-categories")
public class ProductCategoryCtrl
{
    private final ProductCategoryUseCase useCase;


    public ProductCategoryCtrl(ProductCategoryUseCase _useCase)
    {
        useCase = _useCase;
    }

    @GetMapping("/list-all")
    public List<ProductCategoryHeaderModel> listAll()
    {
        var list = useCase.listAllActive();

        return list;
    }

    @GetMapping("/{_id}")
    public ResponseEntity<ProductCategoryDto> getById(@PathVariable int _id)
    {
        var opt = useCase.getById(_id);

        // Jika ketemu maka return 200 OK dengan body JSON
        if (opt.isPresent()) {
            var pc = opt.get();
            var dto = ProductCategoryDto.from(pc);

            return ResponseEntity.ok(dto);
        }

        // Jika tidak ketemu maka return 404 Not Found
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody ProductCategoryCreateDto _dto)
    {
        var cmd = DtoToCmdMapper.fromCreateDto(_dto);
        var pc = useCase.create(cmd);

        return ResponseEntity.ok("Created: " + pc.getSystemId());
    }

    @PatchMapping("/update")
    public ResponseEntity<String> update()
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("/find")
    public ResponseEntity<ProductCategoryDto> findByName(@RequestParam String name)
    {
        var opt = useCase.findByName(name);
        if (opt.isPresent()) {
            var json = ProductCategoryDto.from(opt.get());

            return ResponseEntity.ok(json);
        }
        else
            return ResponseEntity.notFound().build();
    }
}
