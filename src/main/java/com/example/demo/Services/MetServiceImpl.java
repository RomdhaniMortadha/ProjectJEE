package com.example.demo.Services;
import com.example.demo.DTO.Met.MetReponse;
import com.example.demo.DTO.Met.MetRequest;
import com.example.demo.Models.Met.DessertEntity;
import com.example.demo.Models.Met.EntreeEntity;
import com.example.demo.Models.Met.MetEntity;
import com.example.demo.Models.Met.PlatEntity;
import com.example.demo.Reposetories.DessertRepository;
import com.example.demo.Reposetories.EntreeRepository;
import com.example.demo.Reposetories.MetRepository;
import com.example.demo.Reposetories.PlatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class MetServiceImpl implements MetService {
    ModelMapper mapper = new ModelMapper();
    private MetRepository metRepository;
    private PlatRepository platRepository;
    private DessertRepository dessertRepository;
    private EntreeRepository entreeRepository;
    @Autowired
    public MetServiceImpl(MetRepository metRepository, PlatRepository platRepository, DessertRepository dessertRepository, EntreeRepository entreeRepository) {
        super();
        this.metRepository = metRepository;
        this.platRepository = platRepository;
        this.dessertRepository = dessertRepository;
        this.entreeRepository = entreeRepository;
    }

    @Override
    public List<MetReponse> getAllEntity() {

        List<MetEntity> mets = metRepository.findAll();
        List<MetReponse> reponse = new ArrayList<>();
        for (MetEntity met : mets) {
            reponse.add(mapper.map(met, MetReponse.class));
        }
        return reponse;
    }
    public List<MetReponse> getAllPlats(){
        List<MetReponse> metsResp=new ArrayList<>();
        List<PlatEntity> plats= platRepository.findAll();
        for (PlatEntity met:plats){
            metsResp.add(mapper.map(met,MetReponse.class));
        }
        return metsResp;
    }
    public List<MetReponse> getAllDesserts(){
        List<MetReponse> metsResp=new ArrayList<>();
        List<DessertEntity> desserts= dessertRepository.findAll();
        for (DessertEntity met:desserts){
            metsResp.add(mapper.map(met,MetReponse.class));
        }
        return metsResp;
    }
    public List<MetReponse> getAllEntrees() {
        List<MetReponse> metsResp = new ArrayList<>();
        List<EntreeEntity> entrees = entreeRepository.findAll();
        for (EntreeEntity met : entrees) {
            metsResp.add(mapper.map(met, MetReponse.class));
        }
        return metsResp;
    }
    @Override
    public MetReponse getEntityById(long id) {
        Optional<MetEntity> opt = metRepository.findById(id);
        MetEntity entity;
        if (opt.isPresent())
            entity = opt.get();
        else
            throw new NoSuchElementException("Met with this Id is not found");
        return mapper.map(entity,MetReponse.class);
    }


    /*public MetReponse addMet(MetRequest entityreq) {
        MetEntity met=mapper.map(entityreq,MetEntity.class);
        MetEntity metinBase=metRepository.save(met);

        return mapper.map(metinBase,MetReponse.class);
        */


    @Override
        public MetReponse addPlat(MetRequest entityreq){
            PlatEntity met=mapper.map(entityreq,PlatEntity.class);
            met.setNom(met.getNom().toUpperCase().trim());
            return mapper.map(platRepository.save(met),MetReponse.class);
        }
    @Override
        public MetReponse addEntree(MetRequest entityreq){
            EntreeEntity met=mapper.map(entityreq,EntreeEntity.class);
            met.setNom(met.getNom().toUpperCase().trim());
            return mapper.map(entreeRepository.save(met),MetReponse.class);
        }
    @Override
        public MetReponse addDessert(MetRequest entityreq){
            DessertEntity met=mapper.map(entityreq,DessertEntity.class);
            met.setNom(met.getNom().toUpperCase().trim());
            return mapper.map(dessertRepository.save(met),MetReponse.class);
        }




    @Override
    public MetReponse updateMet(long id, MetRequest newEntityreq) {

        MetEntity newEntity =mapper.map(newEntityreq,MetEntity.class );

        MetReponse metrep =this.getEntityById(id);
        MetEntity met =mapper.map(metrep,MetEntity.class);

        if ( newEntity.getNom() != null)
            met.setNom(newEntity.getNom());

        if ( newEntity.getPrix() != 0)
            met.setPrix(newEntity.getPrix());

        MetEntity metsv=metRepository.save(met);
        return mapper.map(metsv,MetReponse.class);
    }

    @Override
    public String deleteMet(long id) {
        MetReponse met = this.getEntityById(id);
        metRepository.deleteById(id);
        return "Met delted ! ";    }
}
