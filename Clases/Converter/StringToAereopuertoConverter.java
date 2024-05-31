package com.springboot.aereolinea.Converter;

import org.springframework.core.convert.converter.Converter;
import com.springboot.aereolinea.Model.Entity.Aereopuerto;
import com.springboot.aereolinea.Model.Service.InterfaceAereopuertoService;
import org.springframework.stereotype.Component;

@Component
public class StringToAereopuertoConverter implements Converter<String, Aereopuerto> {

    private final InterfaceAereopuertoService aereopuertoService;

    public StringToAereopuertoConverter(InterfaceAereopuertoService aereopuertoService) {
        this.aereopuertoService = aereopuertoService;
    }

    @Override
    public Aereopuerto convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        Long id = Long.parseLong(source);
        return aereopuertoService.findOne(id);
    }

}
