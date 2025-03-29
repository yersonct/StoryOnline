package OnliX.TiendaOnline.service;

import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired
    public IReview ReviewData;
    public List<review> findAllShipment(){
        return ReviewData.findAll();
    }
    public 

}
