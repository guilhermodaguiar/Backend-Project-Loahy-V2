package nl.novi.loahy.controllers;

import nl.novi.loahy.dtos.AboutBrandDto;
import nl.novi.loahy.dtos.AboutBrandInputDto;
import nl.novi.loahy.service.AboutBrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/about-loahy")
public class AboutBrandController {


    private final AboutBrandService aboutBrandService;

    public AboutBrandController(AboutBrandService aboutBrandService) {this.aboutBrandService = aboutBrandService; }

    @GetMapping(value = "")
    public ResponseEntity<List<AboutBrandDto>> getBrandsInfo(){

        List<AboutBrandDto> aboutBrandDto = aboutBrandService.getBrandsInfo();

        return ResponseEntity.ok().body(aboutBrandDto);
    }

    @PostMapping(value = "")
    ResponseEntity<Object> createBrand (@RequestBody AboutBrandInputDto inputDto) {
        AboutBrandDto aboutBrandDto = aboutBrandService.createBrandInfo(inputDto);

        return ResponseEntity.created(null).body(aboutBrandDto);
    }


    @PutMapping(value = "/{brandTitle}")
    public ResponseEntity<Object> updateBrandInfo(@PathVariable String brandTitle, @RequestBody AboutBrandInputDto newInput) {

        AboutBrandDto aboutBrandDto = aboutBrandService.updateBrandInfo(brandTitle, newInput);

        return ResponseEntity.ok().body(aboutBrandDto);
    }

}


