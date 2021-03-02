package jorge.munoz.reto_2.Services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import jorge.munoz.reto_2.Repositories.Entities.OrderProductEntity;
import jorge.munoz.reto_2.Repositories.Interfaces.OrderProductsRepository;
import jorge.munoz.reto_2.Services.Models.AuxDTO;
import jorge.munoz.reto_2.Services.Models.OrderProductDTO;
import jorge.munoz.reto_2.Services.Models.ProductDTO;


public class OrderProductsService {
    @Autowired
    private OrderProductsRepository orderProductsRepository;
    @Autowired
    private ModelMapper modelMappper;

    public List<OrderProductDTO> getAll() throws ResponseStatusException {
        
        List<OrderProductDTO> milista = orderProductsRepository.findAll().stream()
        .map(x -> modelMappper.map(x, OrderProductDTO.class))
        .collect(Collectors.toList());

        if(!milista.isEmpty()){
            return milista;
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error finding data");
        }
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

    

    public OrderProductDTO findbyId(Long id) throws ResponseStatusException{
        Optional<OrderProductEntity> entity = orderProductsRepository.findById(id);
        if(entity.isPresent()){
            return modelMappper.map(entity.get(), OrderProductDTO.class);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error finding data");
        }
    }

    public List<ProductDTO> findByOrderId(Long id){
        List<ProductDTO> a = orderProductsRepository.findByOrderId(id).stream()
        .map(x -> modelMappper.map(x, ProductDTO.class))
        .collect(Collectors.toList());

        return a;
    }

    public Long getTotalPriceByOrder(Long id){
        return orderProductsRepository.countTotalPrice(3L).stream()
        .findFirst().get();
    }

    public List<AuxDTO> getCartData(Long id){
        Collection<Object[]> a = orderProductsRepository.getCartData(3L);

        List<AuxDTO> e = a.stream()
        .map(x->new AuxDTO( (String) x[0], (int)x[1], (double)x[2],  (Long)x[3]))
        .collect(Collectors.toList());
        return e;
    }

    public void delete(Long ID) throws ResponseStatusException{
        Optional<OrderProductEntity> entityToDelete = orderProductsRepository.findById(ID);
        if(entityToDelete.isPresent()){
            orderProductsRepository.delete(entityToDelete.get());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error deletting new data");
        }

    }

    public void deleteByIdProduct(Long id) throws ResponseStatusException {

        Optional<OrderProductEntity> entityToDelete = orderProductsRepository.findById(id);
        
        if(entityToDelete.isPresent()){
            orderProductsRepository.deleteById(entityToDelete.get().getId());
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error deletting new data"); 
        }
        
        
    }
    

}
