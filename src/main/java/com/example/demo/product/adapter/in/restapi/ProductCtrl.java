package com.example.demo.product.adapter.in.restapi;

import com.example.demo.product.adapter.in.restapi.dto.ProductCategoryCreateDto;
import com.example.demo.product.adapter.in.restapi.dto.ProductCategoryDto;
import com.example.demo.product.adapter.in.restapi.dto.ProductCreateDto;
import com.example.demo.product.adapter.in.restapi.dto.ProductDto;
import com.example.demo.product.adapter.in.restapi.mapper.DtoToCmdMapper;
import com.example.demo.product.application.model.ProductHeaderModel;
import com.example.demo.product.application.port.in.ProductUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductCtrl {

    private final ProductUseCase useCase;


    public ProductCtrl(ProductUseCase _useCase)
    {
        useCase = _useCase;
    }

    @GetMapping("/list-all")
    public List<ProductHeaderModel> listAll()
    {
        var list = useCase.listAll();

        return list;
    }

    @GetMapping("/{_id}")
    public ResponseEntity<ProductDto> getById(@PathVariable int _id)
    {
        var opt = useCase.getById(_id);

        // Jika ketemu maka return 200 OK dengan body JSON
        if (opt.isPresent()) {
            var pc = opt.get();
            var dto = ProductDto.from(pc);

            return ResponseEntity.ok(dto);
        }

        // Jika tidak ketemu maka return 404 Not Found
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody ProductCreateDto _dto)
    {
        var cmd = DtoToCmdMapper.fromProductCreateDto(_dto);
        var p = useCase.create(cmd);

        return ResponseEntity.ok("Created: " + p.getName());
    }

    @PatchMapping("/update")
    public ResponseEntity<String> update()
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("/find")
    public ResponseEntity<String> findByName(@RequestParam String name)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
