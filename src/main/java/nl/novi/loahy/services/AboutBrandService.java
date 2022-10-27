package nl.novi.loahy.services;

import nl.novi.loahy.dtos.AboutBrandDto;
import nl.novi.loahy.dtos.AboutBrandInputDto;
import nl.novi.loahy.exceptions.AboutBrandNotFoundException;
import nl.novi.loahy.models.AboutBrand;
import nl.novi.loahy.repositories.AboutBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AboutBrandService {


    private final AboutBrandRepository aboutBrandRepository;

    @Autowired
    public AboutBrandService(AboutBrandRepository aboutBrandRepository) {
        this.aboutBrandRepository = aboutBrandRepository;
    }

    public List<AboutBrandDto> getBrandsInfo() {
        List<AboutBrandDto> collection = new ArrayList<>();
        List<AboutBrand> list = aboutBrandRepository.findAll();
        for (AboutBrand aboutBrand : list) {
            collection.add(fromBrand(aboutBrand));
        }
        return collection;
    }


    public AboutBrandDto createBrandInfo(AboutBrandInputDto inputDto) {

        AboutBrand newBrand = transferToAboutBrand(inputDto);

        aboutBrandRepository.save(newBrand);

        return fromBrand(newBrand);
    }

    public AboutBrandDto updateBrandInfo(String brandTitle, AboutBrandInputDto inputDto) {
        if (aboutBrandRepository.findById(brandTitle).isPresent()) {

            AboutBrand aboutBrand = aboutBrandRepository.findById(brandTitle).get();

            AboutBrand aboutBrand1 = transferToAboutBrand(inputDto);
            aboutBrand1.setBrandTitle(aboutBrand.getBrandTitle());

            aboutBrandRepository.save(aboutBrand1);

            return fromBrand(aboutBrand1);
        } else {
            throw new AboutBrandNotFoundException(brandTitle);
        }
    }

    public AboutBrandDto fromBrand(AboutBrand aboutBrand) {

        var brandDto = new AboutBrandDto();

        brandDto.brandTitle = aboutBrand.getBrandTitle();
        brandDto.brandInformation = aboutBrand.getBrandInformation();

        return brandDto;
    }


    public AboutBrand transferToAboutBrand(AboutBrandInputDto inputDto){
        var aboutBrand = new AboutBrand();

        aboutBrand.setBrandInformation(inputDto.getBrandInformation());

        return aboutBrand;
    }

}
