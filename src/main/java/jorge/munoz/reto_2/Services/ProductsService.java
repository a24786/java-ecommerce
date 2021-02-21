package jorge.munoz.reto_2.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import jorge.munoz.reto_2.Repositories.Entities.ProductEntity;
import jorge.munoz.reto_2.Repositories.Interfaces.ProductsRepository;
import jorge.munoz.reto_2.Services.Models.ProductDTO;



public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private ModelMapper modelMappper;

    public List<ProductDTO> getAll(){
        return productsRepository.findAll().stream()
        .map(x -> modelMappper.map(x,ProductDTO.class))
        .collect(Collectors.toList());
    }


    public ProductDTO add(ProductDTO product){
        ProductEntity entityToInsert = modelMappper.map(product, ProductEntity.class);
        ProductEntity result = productsRepository.save(entityToInsert);
        return modelMappper.map(result, ProductDTO.class);
    }

    public Optional<ProductDTO> update(Long ID, ProductDTO product){
        Optional<ProductEntity> dataToUpdate = productsRepository.findById(ID);
        if(dataToUpdate.isPresent()){
            if(dataToUpdate.get().getId() == ID){
                ProductEntity entityToUpdate = modelMappper.map(product, ProductEntity.class);
                entityToUpdate.setId(ID);
                ProductEntity result = productsRepository.save(entityToUpdate);
                return Optional.of(modelMappper.map(result, ProductDTO.class));
            }
        }
        return Optional.empty();
    }

    public void delete(Long ID){
        Optional<ProductEntity> entityToDelete = productsRepository.findById(ID);
        if(entityToDelete.isPresent()){
            productsRepository.delete(entityToDelete.get());
        }
    }

    public ProductDTO findbyId(Long id){
        Optional<ProductEntity> entity = productsRepository.findById(id);
        if(entity.isPresent()){
            return modelMappper.map(entity.get(), ProductDTO.class);
        }else{
            return null;
        }
    }

}
