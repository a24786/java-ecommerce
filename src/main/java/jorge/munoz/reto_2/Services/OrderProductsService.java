package jorge.munoz.reto_2.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import jorge.munoz.reto_2.Repositories.Entities.OrderProductEntity;
import jorge.munoz.reto_2.Repositories.Interfaces.OrderProductsRepository;
import jorge.munoz.reto_2.Services.Models.OrderProductDTO;


public class OrderProductsService {
    @Autowired
    private OrderProductsRepository orderProductsRepository;
    @Autowired
    private ModelMapper modelMappper;

    public List<OrderProductDTO> getAll(){
        return orderProductsRepository.findAll().stream()
        .map(x -> modelMappper.map(x, OrderProductDTO.class))
        .collect(Collectors.toList());
    }

    public OrderProductDTO add(OrderProductDTO order){
        OrderProductEntity entityToInsert = modelMappper.map(order, OrderProductEntity.class);
        OrderProductEntity result = orderProductsRepository.save(entityToInsert);
        return modelMappper.map(result, OrderProductDTO.class);
    }

    public Optional<OrderProductDTO> update(Long ID, OrderProductDTO order){
        Optional<OrderProductEntity> dataToUpdate = orderProductsRepository.findById(ID);
        if(dataToUpdate.isPresent()){
            if(dataToUpdate.get().getId() == ID){
                OrderProductEntity entityToUpdate = modelMappper.map(order, OrderProductEntity.class);
                entityToUpdate.setId(ID);
                OrderProductEntity result = orderProductsRepository.save(entityToUpdate);
                return Optional.of(modelMappper.map(result, OrderProductDTO.class));
            }
        }
        return Optional.empty();
    }

    public void delete(Long ID){
        Optional<OrderProductEntity> entityToDelete = orderProductsRepository.findById(ID);
        if(entityToDelete.isPresent()){
            orderProductsRepository.delete(entityToDelete.get());
        }
    }

    public OrderProductDTO findbyId(Long id){
        Optional<OrderProductEntity> entity = orderProductsRepository.findById(id);
        if(entity.isPresent()){
            return modelMappper.map(entity.get(), OrderProductDTO.class);
        }else{
            return null;
        }
    }

}
