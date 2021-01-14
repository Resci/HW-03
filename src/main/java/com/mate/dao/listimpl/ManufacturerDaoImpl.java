package com.mate.dao.listimpl;

import com.mate.dao.ManufacturerDao;
import com.mate.db.Storage;
import com.mate.model.Manufacturer;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ManufacturerDaoImpl implements ManufacturerDao {
    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        Storage.addManufacturer(manufacturer);
        return manufacturer;
    }

    @Override
    public Optional<Manufacturer> get(Long id) {
        return Storage.manufacturers.stream()
                .filter(x -> Objects.equals(x.getId(),id))
                .findFirst();
    }

    @Override
    public List<Manufacturer> getAll() {
        return Storage.manufacturers;
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        Manufacturer old = get(manufacturer.getId()).get();
        Storage.manufacturers.set(Storage.manufacturers.indexOf(old), manufacturer);
        return old;
    }

    @Override
    public boolean delete(Long id) {
        return Storage.manufacturers.removeIf(x -> x.getId().equals(id));
    }
}