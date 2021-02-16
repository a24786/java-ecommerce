package jorge.munoz.reto_2.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import jorge.munoz.reto_2.Repositories.Entities.OrderEntity;
import jorge.munoz.reto_2.Repositories.Interfaces.OrdersRepository;
import jorge.munoz.reto_2.Services.Models.OrderDTO;



public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ModelMapper modelMappper;

    public List<OrderDTO> getAll(){
        return ordersRepository.findAll().stream()
        .map(x -> modelMappper.map(x, OrderDTO.class))
        .collect(Collectors.toList());
    }

    public OrderDTO add(OrderDTO order){
        OrderEntity entityToInsert = modelMappper.map(order, OrderEntity.class);
        OrderEntity result = ordersRepository.save(entityToInsert);
        return modelMappper.map(result, OrderDTO.class);
    }

    public Optional<OrderDTO> update(Long ID, OrderDTO order){
        Optional<OrderEntity> dataToUpdate = ordersRepository.findById(ID);
        if(dataToUpdate.isPresent()){
            if(dataToUpdate.get().getId() == ID){
                OrderEntity entityToUpdate = modelMappper.map(order, OrderEntity.class);
                entityToUpdate.setId(ID);
                OrderEntity result = ordersRepository.save(entityToUpdate);
                return Optional.of(modelMappper.map(result, OrderDTO.class));
            }
        }
        return Optional.empty();
    }

    public void delete(Long ID){
        Optional<OrderEntity> entityToDelete = ordersRepository.findById(ID);
        if(entityToDelete.isPresent()){
            ordersRepository.delete(entityToDelete.get());
        }
    }

    public OrderDTO findbyId(Long id){
        Optional<OrderEntity> entity = ordersRepository.findById(id);
        if(entity.isPresent()){
            return modelMappper.map(entity.get(), OrderDTO.class);
        }else{
            return null;
        }
    }

}
